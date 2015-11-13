package io.github.gefangshuai.server.core.spring;

import io.github.gefangshuai.server.core.config.Menu;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义全局拦截器
 * Created by gefangshuai on 2015/11/3.
 */
public class NavigationHandlerInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger(NavigationHandlerInterceptor.class);
    private static final String NAV_MENU_ATTR = "nav_menu";
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String menu = "";
        Method method = ((HandlerMethod) handler).getMethod();
        Class clazz = ((HandlerMethod) handler).getBeanType();
        if (method.isAnnotationPresent(Menu.class)) {
            Menu menuAnno = method.getAnnotation(Menu.class);
            menu = menuAnno.value();
        } else if (clazz.isAnnotationPresent(Menu.class)) {
            Menu menuAnno = (Menu) clazz.getAnnotation(Menu.class);
            menu = menuAnno.value();
        }
        request.setAttribute(NAV_MENU_ATTR, menu);
        logger.debug("---servlet menu: " + menu);
        super.postHandle(request, response, handler, modelAndView);
    }
}
