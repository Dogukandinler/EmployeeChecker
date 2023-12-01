package com.example.employeechecker.controller;

import com.example.employeechecker.dto.CaptchaResponseDto;
import com.example.employeechecker.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private final CaptchaService captchaService;

    @Autowired
    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @PostMapping("/response")
    public ResponseEntity<String> handleCaptchaResponse(@RequestBody CaptchaResponseDto captchaResponseDTO) {
        // Extract relevant information from DTO and save to the database
        captchaService.processCaptchaResponse(captchaResponseDTO.getMacAddress(), captchaResponseDTO.getResponseTimeSeconds());

        return ResponseEntity.ok("Captcha response processed successfully.");
    }
}