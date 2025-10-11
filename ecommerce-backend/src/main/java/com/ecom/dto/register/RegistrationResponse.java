package com.ecom.dto.register;

import com.ecom.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationResponse {
    
    private String name;
    private String email;
    private String phone;
    private String address;

    public RegistrationResponse(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }
}
