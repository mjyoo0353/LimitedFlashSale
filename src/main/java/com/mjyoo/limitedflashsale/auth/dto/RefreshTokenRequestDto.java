package com.mjyoo.limitedflashsale.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequestDto {

    private String email;
    private String refreshToken;
}
