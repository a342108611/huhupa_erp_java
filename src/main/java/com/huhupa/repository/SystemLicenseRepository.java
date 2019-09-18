package com.huhupa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huhupa.core.license.License;
import com.huhupa.entity.SystemLicense;

/**
 * 授权码
 * @author huhupa 朱勇军
 *
 */
public interface SystemLicenseRepository extends JpaRepository<SystemLicense, Integer>{

	@Query(value="SELECT sl.* FROM t_system_license sl WHERE sl.`product_name`=?1",nativeQuery=true)
	List<SystemLicense> findByProductName(String productName);


}
