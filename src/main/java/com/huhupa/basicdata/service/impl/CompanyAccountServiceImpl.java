package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyAccountDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.service.CompanyAccountService;
import com.huhupa.basicdata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public CompanyAccount findActiveById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id不能为空");
		}
		CompanyAccount res = new CompanyAccount();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return companyAccountDao.findOne(Example.of(res));
	}

	@Override
	public List<CompanyAccount> findAllActive() {
		CompanyAccount res = new CompanyAccount();
		res.setValid(Global.ACTIVE);
		return companyAccountDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id为空");
		}
		CompanyAccount res = new CompanyAccount();
		res.setId(id);
		CompanyAccount one = companyAccountDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			companyAccountDao.saveAndFlush(one);
		}
	}
}
