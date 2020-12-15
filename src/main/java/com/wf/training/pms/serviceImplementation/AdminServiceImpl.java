package com.wf.training.pms.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.BackofficeInputDto;
import com.wf.training.pms.dto.AdminLoginDto;
import com.wf.training.pms.entity.BackOfficeUser;
import com.wf.training.pms.entity.AdminUser;
import com.wf.training.pms.repository.AdminUserRepository;
import com.wf.training.pms.repository.BackOfficeUserRepository;
import com.wf.training.pms.service.AdminUserService;

@Service
public class AdminServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository repo;
	
	@Autowired
	private BackOfficeUserRepository borepo;
	
	
	public AdminUser get(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public boolean addBackOfficeUser(BackofficeInputDto user) {
		BackOfficeUser buser=new BackOfficeUser();
		buser.setEmailId(user.getEmailId());
		buser.setFirstName(user.getFirstName());
		buser.setLastName(user.getLastName());
		buser.setPassword(user.getPassword());
		this.borepo.save(buser);
		user.setLoginId(buser.getLoginId());
		return true;
	}

	@Override
	public boolean validateUser(AdminLoginDto user) {
		AdminUser superUser=repo.findByName(user.getSuperUserId());
		if(superUser==null)
			return false;
		else
			if(superUser.getPassword().equals(user.getPassword()))
				return true;
			else
				return false;
	}
	
}
