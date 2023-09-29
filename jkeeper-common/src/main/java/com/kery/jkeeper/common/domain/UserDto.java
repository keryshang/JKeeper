package com.kery.jkeeper.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;
    private List<String> roles;

    public UserDto(long id, String username, String password, int status, String clientId, ArrayList<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.clientId = clientId;
        this.roles = roles;
    }
}
