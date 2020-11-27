package com.lingdong.front.admin.auth;

import com.lingdong.common.model.oversea_bi.client.AdminUserClient;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class LingdongUserDetailServiceImpl implements LingdongUserDetailService {

    @Autowired
    private AdminUserClient adminUserClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserDto adminUserDto = adminUserClient.selectByUsername(username).getData();

        UserDetails user = User.builder()
                .username(adminUserDto.getUsername())
                .password(adminUserDto.getPassword())
                .authorities(adminUserDto.getMeunList().toArray(new String[adminUserDto.getMeunList().size()]))
                .build();
        return user;
    }
}
