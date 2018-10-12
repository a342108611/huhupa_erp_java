package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.ProductCategoryDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.entity.ProductCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, Integer> implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Override
	public IBaseDao<ProductCategory, Integer> getBaseDao() {
		return productCategoryDao;
	}

	@Override
	public ProductCategory findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		ProductCategory res = new ProductCategory();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return productCategoryDao.findOne(Example.of(res));
	}

	@Override
	public List<ProductCategory> findAllActive() {
		ProductCategory res = new ProductCategory();
		res.setValid(Global.ACTIVE);
		return productCategoryDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		ProductCategory res = new ProductCategory();
		res.setId(id);
		ProductCategory one = productCategoryDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			productCategoryDao.saveAndFlush(one);
		}
	}
}
