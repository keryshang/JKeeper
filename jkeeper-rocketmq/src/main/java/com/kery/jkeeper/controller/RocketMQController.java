package com.kery.jkeeper.controller;

import cn.hutool.core.util.StrUtil;
import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.MQProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/21
 */
@Controller
@Api(tags = "RocketMQController")
@Tag(name = "RocketMQController", description = "RocketMQ模块API")
@RequestMapping("/rocketmq")
public class RocketMQController {

    @Autowired
    private MQProducerService producerService;

    @ApiOperation("RocketMQ发送同步消息")
    @GetMapping("/sendMessage")
    @ResponseBody
    public CommonResult<SendResult> sendMessage(String message){
        if (StrUtil.isEmptyIfStr(message)){
            return CommonResult.failed("发送信息不能为空");
        }
        return CommonResult.success(producerService.sendMsg(message));
    }

    @ApiOperation("RocketMQ发送异步消息")
    @GetMapping("/sendAsyncMessage")
    @ResponseBody
    public CommonResult sendAsyncMessage(String message){
        if (StrUtil.isEmptyIfStr(message)){
            return CommonResult.failed("发送信息不能为空");
        }
        producerService.sendAsyncMsg(message);
        return CommonResult.success();
    }

    @ApiOperation("RocketMQ发送Tag消息")
    @GetMapping("/sendTagMessage")
    @ResponseBody
    public CommonResult<SendResult> sendTagMessage(String message){
        if (StrUtil.isEmptyIfStr(message)){
            return CommonResult.failed("发送信息不能为空");
        }
        return CommonResult.success(producerService.sendTagMsg(message));
    }
}
