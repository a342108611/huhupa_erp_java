package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.UnitDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.SpendingCategory;
import com.huhupa.basicdata.entity.Unit;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.UnitService;
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
@Service("unitService")
public class UnitServiceImpl extends BaseServiceImpl<Unit, Integer> implements UnitService {

	@Autowired
	private UnitDao unitDao;

	@Override
	public IBaseDao<Unit, Integer> getBaseDao() {
		return unitDao;
	}

	@Override
	public Unit findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		Unit res = new Unit();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return unitDao.findOne(Example.of(res));
	}

	@Override
	public List<Unit> findAllActive() {
		return null;
	}

	@Override
	public void deleteLogicById(Integer id) {

	}
}
