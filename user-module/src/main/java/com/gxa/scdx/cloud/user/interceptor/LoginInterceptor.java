package com.gxa.scdx.cloud.user.interceptor;


/**
 * (ResultDTO) dto对象
 *
 * @author all;
 * @version 1.0
 * @since 2021-06-25 11:06:37
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 前置方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断是否登录？
        // 判断session
        // 没有登录=》重定向到登录页面
        // 已经登录=》 直接放行

        // 先去获取session对象
//        HttpSession session = request.getSession();
//        // 获取存放的登录标记
//        String adminName = (String) session.getAttribute("adminName");
//        // 判断session的值是否为null
//        if (adminName == null) {
//            // 说明未登录
//            // 重定向到登录页面
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> map = new HashMap<>();
//            map.put("code", 406);
//            map.put("msg", "没有登录，被拒绝");
//            response.setContentType("application/json;charset=utf-8");  // 设置相应给页面的结果为json，语言编码为utf-8
//            PrintWriter writer = response.getWriter();
//            writer.print(objectMapper.writeValueAsString(map));
//            return false;
//        }
        // true: 放行， false: 拦截
        return true;
    }

    /**
     * 后置方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
