package com.wf.training.pms.service;

import java.util.List;

import com.wf.training.pms.dto.CompanyDto;
import com.wf.training.pms.dto.InvestorDto;
import com.wf.training.pms.dto.LoginDto;
import com.wf.training.pms.entity.RecentlyViewedCompanies;

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
