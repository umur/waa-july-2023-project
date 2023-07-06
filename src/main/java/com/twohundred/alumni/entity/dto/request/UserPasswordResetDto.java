package com.twohundred.alumni.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPasswordResetDto {
    private Long id;
    private String oldPassword;
    private String newPassword;
    private String newPasswordConfirm;
}
