package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.BasicMaterialDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.service.BasicMaterialService;
import com.huhupa.basicdata.service.CompanyService;
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
@Service("basicMaterialService")
public class BasicMaterialServiceImpl extends BaseServiceImpl<BasicMaterial, Integer> implements BasicMaterialService {

	@Autowired
	private BasicMaterialDao basicMaterialDao;

	@Override
	public IBaseDao<BasicMaterial, Integer> getBaseDao() {
		return basicMaterialDao;
	}
}
