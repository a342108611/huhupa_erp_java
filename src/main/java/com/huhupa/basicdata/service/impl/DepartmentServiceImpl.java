package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.DepartmentDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Department;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.DepartmentService;
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
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department, Integer> implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public IBaseDao<Department, Integer> getBaseDao() {
		return departmentDao;
	}

	@Override
	public Department findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		Department res = new Department();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return departmentDao.findOne(Example.of(res));
	}

	@Override
	public List<Department> findAllActive() {
		return null;
	}

	@Override
	public void deleteLogicById(Integer id) {

	}
}
