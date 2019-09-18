package com.huhupa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.huhupa.entity.GoodsType;

/**
 * 商品类别Repository接口
 * @author huhupa 朱勇军
 *
 */
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Integer>,JpaSpecificationExecutor<GoodsType>{

	/**
	 * 根据父节点查找商品类别
	 * @param parentId
	 * @return
	 */
	@Query(value="select * from t_goodstype where p_id=?1",nativeQuery=true)
	public List<GoodsType> findByParentId(int parentId);
}
