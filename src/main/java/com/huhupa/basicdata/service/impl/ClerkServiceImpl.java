package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.BasicMaterialDao;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.service.BasicMaterialService;
import com.huhupa.basicdata.service.ClerkService;
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
@Service("clerkService")
public class ClerkServiceImpl extends BaseServiceImpl<Clerk, Integer> implements ClerkService {

	@Autowired
	private ClerkDao clerkDao;

	@Override
	public IBaseDao<Clerk, Integer> getBaseDao() {
		return clerkDao;
	}

	@Override
	public Clerk findActiveById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id不能为空");
		}
		Clerk res = new Clerk();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return clerkDao.findOne(Example.of(res));
	}


	@Override
	public List<Clerk> findAllActive() {
		Clerk res = new Clerk();
		res.setValid(Global.ACTIVE);
		return clerkDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id为空");
		}
		Clerk res = new Clerk();
		res.setId(id);
		Clerk one = clerkDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			clerkDao.saveAndFlush(one);
		}
	}
}
