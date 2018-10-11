package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.SpendingCategoryDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.SpendingCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.SpendingCategoryService;
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
@Service("spendingCategoryService")
public class SpendingCategoryServiceImpl extends BaseServiceImpl<SpendingCategory, Integer> implements SpendingCategoryService {

	@Autowired
	private SpendingCategoryDao spendingCategoryDao;

	@Override
	public IBaseDao<SpendingCategory, Integer> getBaseDao() {
		return spendingCategoryDao;
	}
}
