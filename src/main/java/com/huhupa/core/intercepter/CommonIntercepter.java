package com.huhupa.core.intercepter;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.huhupa.config.Constant;
import com.huhupa.core.license.LicenseService;
import com.huhupa.entity.SystemLicense;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@Component
public class CommonIntercepter implements HandlerInterceptor {
	
	@Resource
	private LicenseService licenseService;
	
	private boolean isAccessWhitelist(String uri) {
		if (Arrays.asList(Constant.accessWhitelist).contains(uri)) {
			return true;
		} else if (uri.startsWith("/static") || uri.startsWith("/js") || uri.startsWith("/css") || uri.startsWith("/images")) {
			return true;
		}
		
		return false;
	}


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request uri:" + request.getRequestURI());
        if (isAccessWhitelist(request.getRequestURI())) {
        	return true;
        }
        SystemLicense existLicense = licenseService.getExistLicense("ERP");
        if (existLicense == null || !licenseService.checkLicense(existLicense.getLicense())) {
        	System.out.println("重定向");
//        	response.sendRedirect("/license.html");
        	redirect(request, response);
        	return false;
        }
        return true;
    }

  //对于请求是ajax请求重定向问题的处理方法
    private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
        System.out.println("basePath:" + basePath);
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", basePath + "/license.html");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            response.sendRedirect(basePath + "/license.html");
        }
	}


	@Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
