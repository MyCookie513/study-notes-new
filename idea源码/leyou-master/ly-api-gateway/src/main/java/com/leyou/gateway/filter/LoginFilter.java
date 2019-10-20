package com.leyou.gateway.filter;

import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.utils.CookieUtils;
import com.leyou.gateway.properties.FilterProperties;
import com.leyou.gateway.properties.JwtProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bystander
 * @date 2018/10/2
 */
@Slf4j
@Component
@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})
public class LoginFilter extends ZuulFilter {

    @Autowired
    private JwtProperties props;

    @Autowired
    private FilterProperties filterProps;


    @Override   //todo  - `pre`：请求在被路由之前执行
            //todo      - `routing`：在路由请求时调用
            //todo      - `post`：在routing和errror过滤器之后调用
            //todo      - `error`：处理请求时发生错误调用
    public String filterType() {
        return "pre";
    }





    @Override  //todo 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
    public int filterOrder() {
        return 5;
    }







    @Override    //todo 根据url判定是否要执行过滤器
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        //判断白名单
        return !isAllowPath(requestURI);
    }





    @Override     //todo 对请求进行逻辑判定看是否允许通过
    public Object run() {
        //获取上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = context.getRequest();
        String token = CookieUtils.getCookieValue(request, props.getCookieName());
        try {
            //从Token获取解析用户信息
            JwtUtils.getUserInfo(props.getPublicKey(), token);
            //解析成功，什么都不做，放行

            //todo 如果做权限管理的话，在这做权限检验
        } catch (Exception e) {
            //todo 检验出现异常，返回403  同时拒绝请求，返回禁止进入的状态码
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(403);
            log.error("非法访问，未登录，地址：{}", request.getRemoteHost(), e);
        }
        return null;
    }





    /**
     * 判断请求URI是不是白名单中的URI
     *
     * @param requestURI
     * @return
     */
    private Boolean isAllowPath(String requestURI) {
        boolean flag = false;

        for (String allowPath : filterProps.getAllowPaths()) {
            if (requestURI.startsWith(allowPath)) {
                //允许
                flag = true;
                break;
            }
        }
        return flag;


    }
}
