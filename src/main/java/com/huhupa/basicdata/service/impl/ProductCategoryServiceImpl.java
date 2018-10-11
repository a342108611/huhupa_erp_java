package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.ProductCategoryDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.ProductCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
