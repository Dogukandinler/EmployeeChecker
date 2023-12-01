package com.example.employeechecker.controller;

import com.example.employeechecker.dto.CaptchaResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mac")
@Slf4j
public class MacController {

    @PostMapping
    public ResponseEntity<Void> logMac(@RequestBody CaptchaResponseDto captchaResponseDto) {
        log.info(captchaResponseDto.toString());
        return ResponseEntity.ok().build();
    }

}
