package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.UnitDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Unit;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.UnitService;
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
@Service("unitService")
public class UnitServiceImpl extends BaseServiceImpl<Unit, Integer> implements UnitService {

	@Autowired
	private UnitDao unitDao;

	@Override
	public IBaseDao<Unit, Integer> getBaseDao() {
		return unitDao;
	}
}
