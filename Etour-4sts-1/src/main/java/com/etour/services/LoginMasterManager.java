package com.etour.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.etour.dto.*;
import com.etour.entities.Customer_Master;
public interface LoginMasterManager {
	ResponseEntity<LoginResponse> login(LoginRequest request);

}

