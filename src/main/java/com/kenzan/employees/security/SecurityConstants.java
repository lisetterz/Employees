package com.kenzan.employees.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String DELETION_URL = "/employees/delete/{id}";
    public static final String GETALL_URL = "/employees/getAll";
    public static final String DELETEALL_URL = "/employees/deleteAll";
}
