package com.wf.training.bootapprestfulcrud.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.BackOfficeLoginDto;
import com.wf.training.bootapprestfulcrud.entity.BackOfficeUser;
import com.wf.training.bootapprestfulcrud.repository.BackOfficeUserRepository;
import com.wf.training.bootapprestfulcrud.repository.SuperUserRepository;
import com.wf.training.bootapprestfulcrud.service.BackOfficeUserService;

@Service
public class BackOfficeUserServiceImpl implements BackOfficeUserService {

	@Autowired
	private SuperUserRepository repo;
	
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
