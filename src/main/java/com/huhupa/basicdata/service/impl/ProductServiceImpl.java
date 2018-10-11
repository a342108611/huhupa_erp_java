package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.ProductDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Product;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.ProductService;
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
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public IBaseDao<Product, Integer> getBaseDao() {
		return productDao;
	}
}
