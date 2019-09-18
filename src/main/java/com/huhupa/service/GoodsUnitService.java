package com.huhupa.service;

import java.util.List;

import com.huhupa.entity.GoodsUnit;

/**
 * 商品单位Service接口
 * @author huhupa 朱勇军
 *
 */
public interface GoodsUnitService {

	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public GoodsUnit findById(Integer id);
	
	/**
	 * 查询所有商品单位信息
	 * @return
	 */
	public List<GoodsUnit> listAll();
	
	/**
	 * 修改或者修改商品单位信息
	 * @param goods
	 */
	public void save(GoodsUnit goodsUnit);
	
	/**
	 * 根据id删除商品单位
	 * @param id
	 */
	public void delete(Integer id);
}
