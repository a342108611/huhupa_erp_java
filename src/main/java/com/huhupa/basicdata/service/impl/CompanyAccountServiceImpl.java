package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyAccountDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.service.CompanyAccountService;
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
@Service("companyAccountService")
public class CompanyAccountServiceImpl extends BaseServiceImpl<CompanyAccount, Integer> implements CompanyAccountService {

	@Autowired
	private CompanyAccountDao companyAccountDao;

	@Override
	public IBaseDao<CompanyAccount, Integer> getBaseDao() {
		return companyAccountDao;
	}
}
