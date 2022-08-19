package org.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Acos、
 * @date 2022-07-19 17:45
 * GitHub: https://github.com/bumblebee-code-gh
 * Description:
 */
@Component
public class CommonFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(CommonFilter.class);

    @Override
    public String filterType() {
        // 返回当前过滤器的类型，决定当前过滤器在什么时候执行
        // pre表示在目标微服务前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        // 获取RequestContext对象
        RequestContext currentContext = RequestContext.getCurrentContext();

        // 获取Request对象
        HttpServletRequest request = currentContext.getRequest();

        // 获取当前请求参数
        String parameter = request.getParameter("signal");

        return "hello".equals(parameter);
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("当前请求要进行过滤，run()方法执行了！");

        // 当前实现会忽略这个方法的返回值，所有返回null，不做特殊处理
        return null;
    }
}
