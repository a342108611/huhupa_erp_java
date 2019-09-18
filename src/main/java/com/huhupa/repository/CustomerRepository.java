package com.huhupa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.huhupa.entity.Customer;

/**
 * 客户Repository接口
 * @author huhupa 朱勇军
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>,JpaSpecificationExecutor<Customer>{

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	@Query(value="select * from t_customer where name like ?1",nativeQuery=true)
	public List<Customer> findByName(String name);
}
