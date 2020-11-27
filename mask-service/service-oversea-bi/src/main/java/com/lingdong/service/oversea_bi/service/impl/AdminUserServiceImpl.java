package com.lingdong.service.oversea_bi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingdong.common.model.global_exception.ErrorEnum;
import com.lingdong.common.model.global_exception.LingdongException;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import com.lingdong.common.model.oversea_bi.param.AdminUserSignUpParam;
import com.lingdong.common.util.utils.BeanCopierUtil;
import com.lingdong.service.oversea_bi.dao.AdminUserMapper;
import com.lingdong.service.oversea_bi.dao.AdminUserRoleMapper;
import com.lingdong.service.oversea_bi.entity.AdminUser;
import com.lingdong.service.oversea_bi.entity.AdminUserRole;
import com.lingdong.service.oversea_bi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台-用户信息表(AdminUser)表服务实现类
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

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

    @Override
    public void signUp(AdminUserSignUpParam param) {
        QueryWrapper<AdminUser> query = new QueryWrapper<>();
        query.eq("username", param.getUsername());
        AdminUser userFromDatabase = adminUserMapper.selectOne(query);
        if (userFromDatabase != null) {
            throw new LingdongException(ErrorEnum.E100400, "用户名已存在，请更换用户名。");
        }
        insertUserAndUserRoles(param);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUserAndUserRoles(AdminUserSignUpParam param) {
        AdminUser adminUser = BeanCopierUtil.copyForClass(param, AdminUser.class);
        adminUserMapper.insert(adminUser);

        List<AdminUserRole> userRoles = param.getRoleIds().stream()
                .map(roleId -> AdminUserRole.builder().userId(adminUser.getUserId()).roleId(roleId).build())
                .collect(Collectors.toList());
        adminUserRoleMapper.insertBatch(userRoles);
    }
}