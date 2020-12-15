package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.InvestorDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.entity.RecentlyViewedCompanies;

public interface InvestorService {

	public List<InvestorDto> fetchAllInvestors();
	public InvestorDto fetchSingleInvestor(Long id);
	public InvestorDto addInvestor(InvestorDto investorDto);
	public InvestorDto editInvestor(Long id, InvestorDto investorDto);
	public InvestorDto deleteInvestor(Long id);
	boolean validateInvestor(LoginDto investorLoginDto);
	public RecentlyViewedCompanies addRecentViewCompany(LoginDto investorLoginDto, CompanyDto companyDto);
	public List<CompanyDto> getAllRecentViewCompanies(String loginKey);	
	
}
