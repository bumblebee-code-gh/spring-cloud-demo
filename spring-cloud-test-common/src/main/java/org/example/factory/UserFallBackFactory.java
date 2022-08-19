package org.example.factory;

import feign.hystrix.FallbackFactory;
import org.example.api.UserRemoteService;
import org.example.entity.User;
import org.example.util.ResultEntity;
import org.springframework.stereotype.Component;

/**
 * @author Acos、
 * @date 2022-07-18 15:46
 * GitHub: https://github.com/bumblebee-code-gh
 * Description:
 * 1.实现Consumer端服务降级功能
 * 2.实现@FeignClient注解标记的接口类型
 * 3.在create()方法中返回@FeignClient注解标记的接口类型的对象，当provider调用失败后，会执行这个对象对应的方法
 * 4.这个类必须使用@Component注解将当前类加入IOC容器，当然当前类必须能够被扫描到
 */
@Component
public class UserFallBackFactory implements FallbackFactory<UserRemoteService> {


    @Override
    public UserRemoteService create(Throwable cause) {
        return new UserRemoteService() {
            @Override
            public User getUserByFeign() {
                return null;
            }

            @Override
            public ResultEntity<User> getUserByHystrix(String signal) {
                return ResultEntity.failed("降级机制生效：" + cause.getMessage());
            }
        };
    }
}
