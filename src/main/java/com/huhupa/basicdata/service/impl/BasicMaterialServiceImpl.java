package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.BasicMaterialDao;
import com.huhupa.basicdata.dao.CompanyDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.service.BasicMaterialService;
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

	@Override
	public BasicMaterial findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		BasicMaterial res = new BasicMaterial();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return basicMaterialDao.findOne(Example.of(res));
	}

	@Override
	public List<BasicMaterial> findAllActive() {
		BasicMaterial res = new BasicMaterial();
		res.setValid(Global.ACTIVE);
		return basicMaterialDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		BasicMaterial res = new BasicMaterial();
		res.setId(id);
		BasicMaterial one = basicMaterialDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			basicMaterialDao.saveAndFlush(one);
		}
	}
}
