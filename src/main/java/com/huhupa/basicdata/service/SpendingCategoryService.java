package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.SpendingCategory;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface SpendingCategoryService extends IBaseService<SpendingCategory, Integer> {

    public SpendingCategory findActiveById(Integer id);

    public List<SpendingCategory> findAllActive();

    public void deleteLogicById(Integer id);
}
