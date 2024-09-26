package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.dto.User.UserRequest;
import com.giftown.ecommerce.entity.User;
import com.giftown.ecommerce.repository.UserRepository;
import com.giftown.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
//
//@Autowired
//private PasswordEncoder passwordEncoder;
//
//@Autowired
//private OtpService otpService; // Optional: For OTP verification

    public User registerUser(UserRequest userRequest) {
        // Check if the email or phone number already exists
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent() ||
                userRepository.findByPhoneNumber(userRequest.getPhoneNumber()).isPresent()) {
        }

        // Encrypt the password
        //String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        // Create User entity and save
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
//    user.setPassword(encodedPassword);

        // Save user
        user = userRepository.save(user);

        // Optional: Send OTP for verification
//    String otp = otpService.generateOtp(user.getPhoneNumber());
//    otpService.sendOtp(user.getPhoneNumber(), otp);

        return user;
    }
}