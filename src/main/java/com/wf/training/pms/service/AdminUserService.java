package com.wf.training.pms.service;

import com.wf.training.pms.dto.BackofficeInputDto;
import com.wf.training.pms.dto.AdminLoginDto;
import com.wf.training.pms.entity.AdminUser;


public interface AdminUserService {
	
	public AdminUser get(Integer id);
	public boolean addBackOfficeUser(BackofficeInputDto user);
	public boolean validateUser(AdminLoginDto user);
}
