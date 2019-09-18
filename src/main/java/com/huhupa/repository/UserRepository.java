package com.huhupa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.huhupa.entity.User;

/**
 * 用户Repository接口
 * @author huhupa 朱勇军
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

	/**
	 * 根据用户名查找用户实体
	 * @param userName
	 * @return
	 */
	@Query(value="select * from t_user where user_name=?1",nativeQuery=true)
	public User findByUserName(String userName);
}
