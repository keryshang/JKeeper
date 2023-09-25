package com.kery.jkeeper.service;


import com.kery.jkeeper.model.UmsMember;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
public interface UmsMemberService {

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 根据手机号获取会员
     */
    UmsMember getByUserTelephone(String telephone);

    /**
     * 用户注册
     */
    void register(String username, String password, String telephone);

    /**
     * 更新用户密码
     */
    void updatePassword(String telephone, String password);
}
