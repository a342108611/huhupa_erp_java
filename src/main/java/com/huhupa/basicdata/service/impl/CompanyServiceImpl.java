package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.CompanyCategoryDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.dao.PaymentMethodDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.CompanyService;
import com.huhupa.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Autowired
	private CompanyCategoryDao companyCategoryDao;

	@Autowired
	private PaymentMethodDao paymentMethodDao;

	@Autowired
	private ClerkDao clerkDao;

	@Override
	public IBaseDao<Company, Integer> getBaseDao() {
		return companyDao;
	}

	@Override
	public Company save(Company company, Integer companyCategoryId, Integer paymentMethodId, String salesStaffId) {
		if (null == company) {
			throw new RuntimeException("要保存的公司为空");
		}
		CompanyCategory companyCategory = null;
		if (null != companyCategoryId) {
			companyCategory = companyCategoryDao.findOne(companyCategoryId);
		}
		PaymentMethod paymentMethod = null;
		if (null != paymentMethodId) {
			paymentMethod = paymentMethodDao.findOne(paymentMethodId);
		}
		Clerk clerk = new Clerk();
		clerk.setId(salesStaffId);
		Clerk salesStaff = null;
		if (null != paymentMethodId) {
			salesStaff = clerkDao.findOne(Example.of(clerk));
		}
		company.setCreatedtime(DateUtil.getNow());
		company.setSalesStaff(salesStaff);
		company.setModifiedtime(DateUtil.getNow());
		company.setCreateduser(TokenManager.getCurrentUser().getUserName());
		company.setModifieduser(TokenManager.getCurrentUser().getUserName());
		company.setCompanyCategory(companyCategory);
		company.setPaymentMethod(paymentMethod);
		return save(company);
	}

	@Override
	public Company findByUUID(String id) {
		validNotNullStringParams(id);
		Company company = new Company();
		company.setId(id);
		company.setValid(Global.ACTIVE);
		Company one = companyDao.findOne(Example.of(company));
		return one;
	}

	@Override
	public void deleteLogicByUUID(String id) {
		validNotNullStringParams(id);
		Company company = new Company();
		company.setId(id);
		Company one = companyDao.findOne(Example.of(company));
		if (one != null) {
			one.setValid(Global.DELETE);
			companyDao.saveAndFlush(one);
		}
	}

	@Override
	public List<Company> findAllActive() {
		Company company = new Company();
		company.setValid(Global.ACTIVE);
		List<Company> all = companyDao.findAll(Example.of(company));
		return all;
	}

	@Override
	public Company update(Company company, Integer companyCategoryId, Integer paymentMethodId) {
		validNotNullStringParams(company.getId());
		CompanyCategory companyCategory = null;
		if (null != companyCategoryId) {
			companyCategory = companyCategoryDao.findOne(companyCategoryId);
		}
		PaymentMethod paymentMethod = null;
		if (null != paymentMethodId) {
			paymentMethod = paymentMethodDao.findOne(paymentMethodId);
		}
		company.setCompanyCategory(companyCategory);
		company.setPaymentMethod(paymentMethod);
		return companyDao.saveAndFlush(company);
	}
}
