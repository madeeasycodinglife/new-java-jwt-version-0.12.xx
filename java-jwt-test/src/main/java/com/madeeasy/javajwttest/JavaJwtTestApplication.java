package com.madeeasy.javajwttest;

import com.madeeasy.javajwttest.service.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JavaJwtTestApplication {

    public static void main(String[] args) {
//		SpringApplication.run(JavaJwtTestApplication.class, args);

        JwtUtil jwtUtil = new JwtUtil();
//		String token = jwtUtil.generateToken("pabitra");
//		System.out.println("token = " + token);
        String username = jwtUtil.getUsername("eyJhbGciOiJIUzUxMiJ9" +
                ".eyJqdGkiOiJiYTQ4YjA2OS03N2E1LTRhYTgtYWExZC04ZTc3NWMzMTAyMWYiLCJzdWIiOiJwYWJpdHJhIiwiaXNzIjoiTWFkZUVhc3kiLCJpYXQiOjE2OTY5MTIxMDYsImV4cCI6MTY5NjkxMjcwNn0.deIBUGA-FQvWOk-OZqhl163NxQfpEEU1WAJctjzmbU8oX8TdNCUPjrjWiP2Jd_uLJyPXf-o7a97vQx2u7EK-pw");
        System.out.println("username = " + username);
    }

}
