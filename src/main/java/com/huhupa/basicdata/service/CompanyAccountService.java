package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyAccount;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface CompanyAccountService extends IBaseService<CompanyAccount, Integer> {

    public CompanyAccount findActiveById(String id);

    public List<CompanyAccount> findAllActive();

    public void deleteLogicById(String id);
}
