package com.lingdong.front.admin.auth;

import com.lingdong.common.model.global_exception.ErrorEnum;
import com.lingdong.common.model.global_exception.LingdongException;
import com.lingdong.common.model.oversea_bi.dto.AdminUserDto;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 自定义参数解析器：识别用户信息参数（LoginUserInfo），并获取用户信息注入参数中
 * @author wangwl
 * @date 2020/5/22 11:00
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 如果参数类型是 AdminUserDto 并且有 CurrentUser 注解，则解析器生效
        return methodParameter.getParameterType().isAssignableFrom(AdminUserDto.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        AdminUserDto loginUserInfo = AdminUserHolder.getAdminUser();
        if (loginUserInfo == null) {
            throw new LingdongException(ErrorEnum.E100401);
        }
        return loginUserInfo;
    }
}
