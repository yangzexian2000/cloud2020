package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @authoer:zexian
 * @createDate:2022/6/29
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException e)
    {
        return new CommonResult(2022,"自定义的限流处理信息。。。handleException");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(2022,"自定义的限流处理信息。。。handleException2");
    }
}
