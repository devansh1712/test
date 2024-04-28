package com.BlogApp_With_Mircroservices.payload;

import lombok.Data;

@Data
public class LoginDto {
    private  String username;
    private  String password;
}
