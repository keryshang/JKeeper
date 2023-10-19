package com.kery.jkeeper.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description: MinIO Bucket访问策略配置
 * Author: Kery
 * Date: 2023/10/19
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class BucketPolicyConfigDto {

    private String Version;
    private List<Statement> Statement;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Builder
    public static class Statement {
        private String Effect;
        private String Principal;
        private String Action;
        private String Resource;

    }
}
