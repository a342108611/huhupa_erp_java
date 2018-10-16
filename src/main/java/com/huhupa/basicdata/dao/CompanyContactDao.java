package com.huhupa.basicdata.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.entity.CompanyContact;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyContactDao extends IBaseDao<CompanyContact, Integer> {

}
