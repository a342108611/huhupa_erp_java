package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyCategoryDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.service.CompanyCategoryService;
import com.huhupa.basicdata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 实现类
 * </p>
 *
 * @author huhupa
 * @since 2018-10-11
 */
@Service("companyCategoryService")
public class CompanyCategoryServiceImpl extends BaseServiceImpl<CompanyCategory, Integer> implements CompanyCategoryService {

	@Autowired
	private CompanyCategoryDao companyCategoryDao;

	@Override
	public IBaseDao<CompanyCategory, Integer> getBaseDao() {
		return companyCategoryDao;
	}
}
