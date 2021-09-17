package com.home.demo.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NonNull
    Long id;
    String name;
    String description;
}
