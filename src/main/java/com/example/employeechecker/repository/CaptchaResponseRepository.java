package com.example.employeechecker.repository;

import com.example.employeechecker.model.CaptchaResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptchaResponseRepository extends JpaRepository<CaptchaResponse, Long> {

}