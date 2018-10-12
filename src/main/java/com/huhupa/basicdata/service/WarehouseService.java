package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Warehouse;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface WarehouseService extends IBaseService<Warehouse, Integer> {

    public Warehouse findActiveById(Integer id);

    public List<Warehouse> findAllActive();

    public void deleteLogicById(Integer id);
}
