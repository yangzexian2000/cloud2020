package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * controller层
 *
 * @author xian on 2021/10/20
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    //从80端口请求过来的数据  表单提交的数据 要带上requestbody 这个属性 不能接收不到值
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("payment："+payment);
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if (result > 0) {
            return  new CommonResult(200,"插入数据库成功server.port:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****插入结果："+paymentById);
        int i = 10/2;
        log.info("s:"+i);
        if (paymentById !=null) {
            return  new CommonResult(200,"查询成功server.port:"+serverPort,paymentById);
        }else{
            return new CommonResult(444,"没有对应记录，查询的id"+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取全部的service
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***** element:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
