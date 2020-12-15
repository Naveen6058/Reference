package com.wf.training.pms.service;

import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.BackOfficeLoginDto;

@Service
public interface BackOfficeUserService {
	
	public boolean validateUser(BackOfficeLoginDto user);
}
