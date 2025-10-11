package com.ecom.dto.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequest {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
