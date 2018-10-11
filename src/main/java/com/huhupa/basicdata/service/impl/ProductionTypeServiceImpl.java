package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ProductDao;
import com.huhupa.basicdata.dao.ProductionTypeDao;
import com.huhupa.basicdata.entity.Product;
import com.huhupa.basicdata.entity.ProductionType;
import com.huhupa.basicdata.service.ProductService;
import com.huhupa.basicdata.service.ProductionTypeService;
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
@Service("productionTypeService")
public class ProductionTypeServiceImpl extends BaseServiceImpl<ProductionType, Integer> implements ProductionTypeService {

	@Autowired
	private ProductionTypeDao productionTypeDao;

	@Override
	public IBaseDao<ProductionType, Integer> getBaseDao() {
		return productionTypeDao;
	}
}
