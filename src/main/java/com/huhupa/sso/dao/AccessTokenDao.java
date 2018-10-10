package com.huhupa.sso.dao;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.sso.entity.AccessToken;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenDao extends IBaseDao<AccessToken, Integer> {

}
