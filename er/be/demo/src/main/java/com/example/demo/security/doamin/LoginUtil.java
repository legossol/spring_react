package com.example.demo.security.doamin;

import java.io.Serializable;

public class LoginUtil implements Serializable{
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    
}
