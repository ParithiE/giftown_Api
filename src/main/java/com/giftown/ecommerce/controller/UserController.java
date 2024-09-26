package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.User.UserRequest;
import com.giftown.ecommerce.entity.User;
import com.giftown.ecommerce.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        try {
            User user = userMapper.registerUser(userRequest);
            return ResponseEntity.ok("User registered successfully. Please verify your phone with OTP.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping("/verify-otp")
//    public ResponseEntity<?> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
//        try {
//            boolean isVerified = otpService.validateOtp(phoneNumber, otp);
//            if (isVerified) {
//                return ResponseEntity.ok("Phone number verified successfully.");
//            } else {
//                return ResponseEntity.badRequest().body("Invalid OTP.");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
}