package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Department;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface DepartmentService extends IBaseService<Department, Integer> {

    public Department findActiveById(Integer id);

    public List<Department> findAllActive();

    public void deleteLogicById(Integer id);
}
