package com.kery.jkeeper.component;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/26
 */
@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        CommonResult result = null;
        //根据限流降级的策略规则，不同的异常返回不同的提示语，
        if (e instanceof FlowException) {
            result = CommonResult.failed("接口限流了");
        } else if (e instanceof DegradeException) {
            result = CommonResult.failed("服务降级了");
        } else if (e instanceof ParamFlowException) {
            result = CommonResult.failed("热点参数限流了");
        } else if (e instanceof SystemBlockException) {
            result = CommonResult.failed("触发系统保护规则了");
        } else if (e instanceof AuthorityException) {
            result = CommonResult.failed("授权规则不通过");
        }

        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), result);
    }
}
