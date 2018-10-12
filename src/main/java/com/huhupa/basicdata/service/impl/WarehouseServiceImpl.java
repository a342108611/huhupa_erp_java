package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.WarehouseDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.Unit;
import com.huhupa.basicdata.entity.Warehouse;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.WarehouseService;
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
@Service("warehouseService")
public class WarehouseServiceImpl extends BaseServiceImpl<Warehouse, Integer> implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	@Override
	public IBaseDao<Warehouse, Integer> getBaseDao() {
		return warehouseDao;
	}

	@Override
	public Warehouse findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		Warehouse res = new Warehouse();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return warehouseDao.findOne(Example.of(res));
	}

	@Override
	public List<Warehouse> findAllActive() {
		Warehouse res = new Warehouse();
		res.setValid(Global.ACTIVE);
		return warehouseDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		Warehouse res = new Warehouse();
		res.setId(id);
		Warehouse one = warehouseDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			warehouseDao.saveAndFlush(one);
		}
	}
}
