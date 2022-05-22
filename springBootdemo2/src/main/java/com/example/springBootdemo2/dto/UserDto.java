package com.example.springBootdemo2.dto;


import com.example.springBootdemo2.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private User user;
    private Set<Role> roles;
}
