package com.lingdong.service.oversea.bi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingdong.service.oversea.bi.config.AdminUserDto;
import com.lingdong.service.oversea.bi.config.BeanCopierUtil;
import com.lingdong.service.oversea.bi.dao.AdminUserMapper;
import com.lingdong.service.oversea.bi.entity.AdminUser;
import com.lingdong.service.oversea.bi.service.AdminUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台-用户信息表(AdminUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-23 15:18:48
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> query = new QueryWrapper<>();
        query.eq("username", username);
        query.eq("status", "NORMAL");
        AdminUser adminUser = adminUserMapper.selectOne(query);

        List<String> menuList = adminUserMapper.selectMenuListByUserId(adminUser.getUserId());
        UserDetails user = User.builder()
                .username(adminUser.getUsername())
                .password(adminUser.getPassword())
                .authorities(menuList.toArray(new String[menuList.size()]))
                .build();
        return user;
    }

    @Override
    public AdminUserDto selectByUsername(String username) {
        QueryWrapper<AdminUser> query = new QueryWrapper<>();
        query.eq("username", username);
        query.eq("status", "NORMAL");
        AdminUser adminUser = adminUserMapper.selectOne(query);
        List<String> menuList = adminUserMapper.selectMenuListByUserId(adminUser.getUserId());
        AdminUserDto adminUserDto = BeanCopierUtil.copyForClass(adminUser, AdminUserDto.class);
        adminUserDto.setMeunList(menuList);
        return adminUserDto;
    }
}