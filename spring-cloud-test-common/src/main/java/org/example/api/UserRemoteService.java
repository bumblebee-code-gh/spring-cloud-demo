package org.example.api;

import org.example.entity.User;
import org.example.factory.UserFallBackFactory;
import org.example.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient注解表示当前接口和一个provider对应，
//             注解中的value属性指定要调用的provider的微服务名称
//             注解中的fallbackFactory属性指定provider不可用时提供备用方案的工厂类型
// @FeignClient("provider-demo")
@FeignClient(value = "provider-demo", fallbackFactory = UserFallBackFactory.class)
public interface UserRemoteService {

    // 远程调用的接口方法
    // 要求@RequestMapping注解映射的地址一致
    // 要求方法声明一致
    // 用来获取请求参数的@RequestParm、@PathVariable、@RequestBody不能省略，要求两边一致
    @RequestMapping("/provider/get/user/feign")
    public User getUserByFeign();

    @RequestMapping("/provider/get/user/hystrix")
    public ResultEntity<User> getUserByHystrix(@RequestParam("signal") String signal);

}
