package com.huhupa.base.dao.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CustomSearchDao {

    /**
     * sql查询
     *
     * @param sql
     * @param args
     * @return
     */
    List<Map> findAllByParams(String sql, Object... args);

    /**
     * sql分页查询
     *
     * @param sql
     * @param args
     * @return
     */
    Page<Map> findPageByParams(String sql, Pageable pageable, Object... args);
}