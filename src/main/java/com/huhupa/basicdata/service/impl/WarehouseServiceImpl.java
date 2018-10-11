package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.WarehouseDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Warehouse;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.WarehouseService;
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
@Service("warehouseService")
public class WarehouseServiceImpl extends BaseServiceImpl<Warehouse, Integer> implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	@Override
	public IBaseDao<Warehouse, Integer> getBaseDao() {
		return warehouseDao;
	}
}
