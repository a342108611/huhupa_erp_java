package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.IncomeCategory;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface IncomeCategoryService extends IBaseService<IncomeCategory, Integer> {

    public IncomeCategory findActiveById(Integer id);

    public List<IncomeCategory> findAllActive();

    public void deleteLogicById(Integer id);
}
