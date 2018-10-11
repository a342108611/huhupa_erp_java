package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.BasicMaterialDao;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.service.BasicMaterialService;
import com.huhupa.basicdata.service.ClerkService;
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
@Service("clerkService")
public class ClerkServiceImpl extends BaseServiceImpl<Clerk, Integer> implements ClerkService {

	@Autowired
	private ClerkDao clerkDao;

	@Override
	public IBaseDao<Clerk, Integer> getBaseDao() {
		return clerkDao;
	}
}
