package com.ss.springsecurityjwt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class UserDto {
	private String username;
	private String password;
}
