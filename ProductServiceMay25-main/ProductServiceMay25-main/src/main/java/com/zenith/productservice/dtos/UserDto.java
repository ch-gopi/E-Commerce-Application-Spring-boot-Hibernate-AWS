package com.zenith.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;
//    private List<Role> roles = new ArrayList<>();
}
