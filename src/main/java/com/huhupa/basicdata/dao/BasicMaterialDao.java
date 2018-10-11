package com.huhupa.basicdata.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicMaterialDao extends IBaseDao<BasicMaterial, Integer> {

}
