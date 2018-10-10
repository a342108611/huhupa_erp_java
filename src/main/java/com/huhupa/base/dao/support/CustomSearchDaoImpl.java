package com.huhupa.base.dao.support;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Component("customSearchDao")
public class CustomSearchDaoImpl implements CustomSearchDao{

    //实体管理类，对持久化实体做增删改查，自动义sq操作模板所需要的核心类
    @Autowired
    public EntityManager entityManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map> findAllByParams(String sql, Object... args) {
        //获取session
        Session session = (Session) entityManager.getDelegate();
        org.hibernate.Query q = session.createSQLQuery(sql);
        //查询结果转map
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        int i = 0;
        for (Object arg : args
                ) {
            q.setParameter(i++, arg);
        }
        return q.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<Map> findPageByParams(String sql, Pageable pageable, Object... args) {
        Session session = (Session) entityManager.getDelegate();
        org.hibernate.Query q = session.createSQLQuery(sql);
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        int i = 0;
        for (Object arg : args
                ) {
            q.setParameter(i++, arg);
        }

        List<Map> totalCount = q.list();
        q.setFirstResult(pageable.getPageSize() * (pageable.getPageNumber() - 1));
        q.setMaxResults(pageable.getPageSize());
        List<Map> pageCount = q.list();
        Page<Map> pages = new PageImpl<>(pageCount, pageable, totalCount.size());
        return pages;
    }
}
