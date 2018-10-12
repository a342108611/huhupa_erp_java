package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface ClerkService extends IBaseService<Clerk, Integer> {

    public Clerk findActiveById(String id);

    public List<Clerk> findAllActive();

    public void deleteLogicById(String id);
}
