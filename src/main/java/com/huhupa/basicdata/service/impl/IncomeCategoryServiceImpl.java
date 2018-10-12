package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.IncomeCategoryDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Education;
import com.huhupa.basicdata.entity.IncomeCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.IncomeCategoryService;
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
@Service("incomeCategoryService")
public class IncomeCategoryServiceImpl extends BaseServiceImpl<IncomeCategory, Integer> implements IncomeCategoryService {

	@Autowired
	private IncomeCategoryDao incomeCategoryDao;

	@Override
	public IBaseDao<IncomeCategory, Integer> getBaseDao() {
		return incomeCategoryDao;
	}

	@Override
	public IncomeCategory findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		IncomeCategory res = new IncomeCategory();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return incomeCategoryDao.findOne(Example.of(res));
	}

	@Override
	public List<IncomeCategory> findAllActive() {
		return null;
	}

	@Override
	public void deleteLogicById(Integer id) {

	}
}
