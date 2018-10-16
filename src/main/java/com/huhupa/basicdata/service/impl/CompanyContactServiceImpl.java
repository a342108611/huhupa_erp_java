package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyAccountDao;
import com.huhupa.basicdata.dao.CompanyContactDao;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.entity.CompanyContact;
import com.huhupa.basicdata.service.CompanyAccountService;
import com.huhupa.basicdata.service.CompanyContactService;
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
@Service("companyContactService")
public class CompanyContactServiceImpl extends BaseServiceImpl<CompanyContact, Integer> implements CompanyContactService {

	@Autowired
	private CompanyContactDao companyContactDao;

	@Override
	public IBaseDao<CompanyContact, Integer> getBaseDao() {
		return companyContactDao;
	}

	@Override
	public CompanyContact findActiveById(Integer id) {
		return null;
	}

	@Override
	public List<CompanyContact> findAllActive() {
		return null;
	}

	@Override
	public void deleteLogicById(Integer id) {
	}
}
