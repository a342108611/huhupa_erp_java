package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.EducationDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.Department;
import com.huhupa.basicdata.entity.Education;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.EducationService;
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
@Service("educationService")
public class EducationServiceImpl extends BaseServiceImpl<Education, Integer> implements EducationService {

	@Autowired
	private EducationDao educationDao;

	@Override
	public IBaseDao<Education, Integer> getBaseDao() {
		return educationDao;
	}

	@Override
	public Education findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		Education res = new Education();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return educationDao.findOne(Example.of(res));
	}

	@Override
	public List<Education> findAllActive() {
		Education res = new Education();
		res.setValid(Global.ACTIVE);
		return educationDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		Education res = new Education();
		res.setId(id);
		Education one = educationDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			educationDao.saveAndFlush(one);
		}
	}
}
