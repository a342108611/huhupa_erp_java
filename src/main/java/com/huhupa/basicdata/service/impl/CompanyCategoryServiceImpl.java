package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.CompanyCategoryDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.service.CompanyCategoryService;
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
@Service("companyCategoryService")
public class CompanyCategoryServiceImpl extends BaseServiceImpl<CompanyCategory, Integer> implements CompanyCategoryService {

	@Autowired
	private CompanyCategoryDao companyCategoryDao;

	@Override
	public IBaseDao<CompanyCategory, Integer> getBaseDao() {
		return companyCategoryDao;
	}

	@Override
	public CompanyCategory findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		CompanyCategory res = new CompanyCategory();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return companyCategoryDao.findOne(Example.of(res));
	}

	@Override
	public List<CompanyCategory> findAllActive() {
		CompanyCategory res = new CompanyCategory();
		res.setValid(Global.ACTIVE);
		return companyCategoryDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		CompanyCategory res = new CompanyCategory();
		res.setId(id);
		CompanyCategory one = companyCategoryDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			companyCategoryDao.saveAndFlush(one);
		}
	}
}
