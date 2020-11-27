package com.lingdong.service.oversea_bi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description JWT工具类
 */
public class JwtTokenUtil {

    /**
     * 生成足够的安全随机密钥，以适合符合规范的签名
     */
    private static final byte[] API_KEY_SECRET_BYTES = DatatypeConverter.parseBase64Binary(SecurityConstant.JWT_SECRET_KEY);
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(API_KEY_SECRET_BYTES);

    public static String createToken(Long userId, String username, List<String> menus, boolean isRememberMe) {
        long expiration = isRememberMe ? SecurityConstant.EXPIRATION_REMEMBER : SecurityConstant.EXPIRATION;
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
        String token = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setId(String.valueOf(userId))
                .setIssuer(SecurityConstant.TOKEN_ISS)
                .setIssuedAt(createdDate)
                .setSubject(username)
                .setExpiration(expirationDate)
                .claim(SecurityConstant.ROLE_CLAIMS, String.join(",", menus))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
        return SecurityConstant.TOKEN_PREFIX + token;
    }

    public static String getUserId(String token) {
        Claims claims = getClaims(token);
        return claims.getId();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        Claims claims = getClaims(token);
        String role = (String) claims.get(SecurityConstant.ROLE_CLAIMS);
        List<SimpleGrantedAuthority> authorities = Arrays.stream(role.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(username, token, authorities);
    }

    private static Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
