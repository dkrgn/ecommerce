package com.ecom.dto.user;

import com.ecom.model.Role;
import com.ecom.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private Role role;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}
