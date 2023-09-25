package com.kery.jkeeper.controller;

import cn.hutool.core.util.StrUtil;
import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.model.UmsMember;
import com.kery.jkeeper.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@Api(tags = "UmsMemberController")
@Tag(name = "UmsMemberController", description = "Mybatis操作会员API")
@RestController("/member")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("根据手机号获取会员信息")
    @GetMapping("/queryUserByTelephone")
    public CommonResult<UmsMember> queryUserByTelephone(@RequestParam String telephone){
        UmsMember umsMember = umsMemberService.getByUserTelephone(telephone);
        if (umsMember == null) {
            return CommonResult.failed("用户不存在");
        }
        return CommonResult.success(umsMember);
    }

    @ApiOperation("会员注册")
    @GetMapping("/register")
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone){
        umsMemberService.register(username, password, telephone);
        return CommonResult.success("注册成功");
    }

    @ApiOperation("修改密码")
    @GetMapping("/updatePassword")
    public CommonResult updatePassword(@RequestParam String password,
                                       @RequestParam String telephone){
        umsMemberService.updatePassword(telephone, password);
        return CommonResult.success("密码修改成功");
    }
}
