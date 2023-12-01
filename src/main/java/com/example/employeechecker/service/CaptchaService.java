package com.example.employeechecker.service;

import com.example.employeechecker.model.CaptchaResponse;
import com.example.employeechecker.model.User;
import com.example.employeechecker.repository.CaptchaResponseRepository;
import com.example.employeechecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptchaService {
    private final UserRepository userRepository;
    private final CaptchaResponseRepository captchaResponseRepository;

    @Autowired
    public CaptchaService(UserRepository userRepository, CaptchaResponseRepository captchaResponseRepository) {
        this.userRepository = userRepository;
        this.captchaResponseRepository = captchaResponseRepository;
    }

    public void processCaptchaResponse(String macAddress, int responseTimeSeconds) {
        // Find or create the user
        User user = userRepository.findByMacAddress(macAddress)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setMacAddress(macAddress);
                    // Set other user properties as needed
                    return userRepository.save(newUser);
                });

        // Record the captcha response
        CaptchaResponse captchaResponse = new CaptchaResponse();
        captchaResponse.setUser(user);
        captchaResponse.setResponseTimeSeconds(responseTimeSeconds);
        captchaResponseRepository.save(captchaResponse);
    }
}