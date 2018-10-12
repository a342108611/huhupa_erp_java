package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Unit;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface UnitService extends IBaseService<Unit, Integer> {

    public Unit findActiveById(Integer id);

    public List<Unit> findAllActive();

    public void deleteLogicById(Integer id);
}
