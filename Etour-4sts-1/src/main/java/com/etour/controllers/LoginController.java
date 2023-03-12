package com.etour.controllers;
import com.etour.dto.*;
import com.etour.entities.Customer_Master;
import com.etour.services.LoginMasterManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginMasterManager manager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    	return manager.login(request);
        }
    
    }



