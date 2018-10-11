package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户  服务实现类
 * </p>
 *
 * @author huhupa
 * @since 2018-10-11
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<Company, Integer> implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public IBaseDao<Company, Integer> getBaseDao() {
		return companyDao;
	}
}
