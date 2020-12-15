package com.wf.training.bootapprestfulcrud.service;

import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.BackOfficeLoginDto;

@Service
public interface BackOfficeUserService {
	
	public boolean validateUser(BackOfficeLoginDto user);
}
