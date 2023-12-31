package com.kery.jkeeper.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.kery.jkeeper.common.constant.AuthConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Kery
 * @Description: 资源管理Service实现类
 * @date 2023/9/28
 */
@Service
public class ResourceServiceImpl {
    private Map<String, List<String>> resourceRolesMap;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/jkeeper-nacos/nacos/getAge", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/jkeeper-nacos/nacos/getName", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/jkeeper-nacos/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRolesMap);
    }
}
