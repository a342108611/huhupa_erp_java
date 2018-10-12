package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.Company;

/**
 * <p>
 * 客户服务类
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface CompanyService extends IBaseService<Company, Integer> {

    Company save(Company company, Integer companyCategoryId, Integer paymentMethodId);
}
