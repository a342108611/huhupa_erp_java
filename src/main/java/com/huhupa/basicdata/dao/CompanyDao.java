package com.huhupa.basicdata.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.basicdata.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends IBaseDao<Company, Integer> {

}
