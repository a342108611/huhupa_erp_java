package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.EducationDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Education;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.EducationService;
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
@Service("educationService")
public class EducationServiceImpl extends BaseServiceImpl<Education, Integer> implements EducationService {

	@Autowired
	private EducationDao educationDao;

	@Override
	public IBaseDao<Education, Integer> getBaseDao() {
		return educationDao;
	}
}
