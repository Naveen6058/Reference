package com.wf.training.bootapprestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.SuperUser;

@Repository
public interface SuperUserRepository extends JpaRepository<SuperUser, Integer>{

	SuperUser findById(int id);
	
	
}
