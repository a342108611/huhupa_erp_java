package com.huhupa.basicdata.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Education;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDao extends IBaseDao<Education, Integer> {

}