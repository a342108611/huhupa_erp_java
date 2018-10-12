package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.entity.CompanyCategory;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface CompanyCategoryService extends IBaseService<CompanyCategory, Integer> {

    public CompanyCategory findActiveById(Integer id);

    public List<CompanyCategory> findAllActive();

    public void deleteLogicById(Integer id);
}
