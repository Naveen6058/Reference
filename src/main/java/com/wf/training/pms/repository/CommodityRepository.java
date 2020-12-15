package com.wf.training.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.pms.entity.Commodity;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer>{

	Commodity findByCommodityName(String commodityName);

}


