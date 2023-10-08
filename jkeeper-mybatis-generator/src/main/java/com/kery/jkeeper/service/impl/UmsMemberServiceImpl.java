package com.kery.jkeeper.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.kery.jkeeper.common.exception.Asserts;
import com.kery.jkeeper.mapper.UmsMemberMapper;
import com.kery.jkeeper.model.UmsMember;
import com.kery.jkeeper.model.UmsMemberExample;
import com.kery.jkeeper.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Override
    public UmsMember getById(Long id) {
        return umsMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public UmsMember getByUserTelephone(String telephone) {
        UmsMemberExample umsMemberExample = new UmsMemberExample();
        umsMemberExample.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = umsMemberMapper.selectByExample(umsMemberExample);
        if (CollectionUtils.isEmpty(memberList)) {
            return null;
        }
        return memberList.get(0);
    }

    @Override
    public void register(String username, String password, String telephone) {

        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> umsMembers = umsMemberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            Asserts.fail("该用户已经存在");
        }
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(BCrypt.hashpw(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        umsMemberMapper.insert(umsMember);
    }

    @Override
    public void updatePassword(String telephone, String password) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = umsMemberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            Asserts.fail("该账号不存在");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(BCrypt.hashpw(password));
        umsMemberMapper.updateByPrimaryKeySelective(umsMember);
    }
}
