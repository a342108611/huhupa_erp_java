package com.huhupa.basicdata.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.ProductionType;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionTypeDao extends IBaseDao<ProductionType, Integer> {

}
