package com.jason.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class loginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取到请求的上下文：这个请求的上下文一直存在于路由的前中后，不存在于转发的微服务中
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        //获取请求参数 access-token
        String token=request.getParameter("access-token");
        //判断是否存在
        if(StringUtils.isBlank(token)) {
            //不存在未登录，则拦截
            requestContext.setSendZuulResponse(false);
            //返回403，请求的资源禁止访问；
            requestContext.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        return null;
    }
}
