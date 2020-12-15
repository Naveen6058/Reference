package com.wf.training.bootapprestfulcrud.service;

import com.wf.training.bootapprestfulcrud.dto.BackofficeInputDto;
import com.wf.training.bootapprestfulcrud.dto.SuperUserLoginDto;
import com.wf.training.bootapprestfulcrud.entity.SuperUser;


public interface SuperUserService {
	
	public SuperUser get(Integer id);
	public boolean addBackOfficeUser(BackofficeInputDto user);
	public boolean validateUser(SuperUserLoginDto user);
}
