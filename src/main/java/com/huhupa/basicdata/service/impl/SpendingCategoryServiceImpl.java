package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.SpendingCategoryDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.ProductCategory;
import com.huhupa.basicdata.entity.SpendingCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.SpendingCategoryService;
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
@Service("spendingCategoryService")
public class SpendingCategoryServiceImpl extends BaseServiceImpl<SpendingCategory, Integer> implements SpendingCategoryService {

	@Autowired
	private SpendingCategoryDao spendingCategoryDao;

	@Override
	public IBaseDao<SpendingCategory, Integer> getBaseDao() {
		return spendingCategoryDao;
	}

	@Override
	public SpendingCategory findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		SpendingCategory res = new SpendingCategory();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return spendingCategoryDao.findOne(Example.of(res));
	}

	@Override
	public List<SpendingCategory> findAllActive() {
		SpendingCategory res = new SpendingCategory();
		res.setValid(Global.ACTIVE);
		return spendingCategoryDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		SpendingCategory res = new SpendingCategory();
		res.setId(id);
		SpendingCategory one = spendingCategoryDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			spendingCategoryDao.saveAndFlush(one);
		}
	}
}
