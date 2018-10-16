package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.CompanyContact;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface CompanyContactService extends IBaseService<CompanyContact, Integer> {

    public CompanyContact findActiveById(Integer id);

    public List<CompanyContact> findAllActive();

    public void deleteLogicById(Integer id);
}
