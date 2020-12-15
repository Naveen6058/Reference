package com.wf.training.pms.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.BackOfficeLoginDto;
import com.wf.training.pms.entity.BackOfficeUser;
import com.wf.training.pms.repository.BackOfficeUserRepository;
import com.wf.training.pms.service.BackOfficeUserService;

@Service
public class BackOfficeUserServiceImpl implements BackOfficeUserService {
	
	@Autowired
	private BackOfficeUserRepository borepo;


	@Override
	public boolean validateUser(BackOfficeLoginDto user) {
		BackOfficeUser boUser=borepo.findByLoginId(user.getLoginId());
		if(boUser==null)
			return false;
		else
			if(boUser.getPassword().equals(user.getPassword()))
				return true;
			else
				return false;
			
	}
	

	
}
