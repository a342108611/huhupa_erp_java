package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Product;
import com.huhupa.basicdata.entity.ProductionType;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface ProductionTypeService extends IBaseService<ProductionType, Integer> {

    public ProductionType findActiveById(Integer id);

    public List<ProductionType> findAllActive();

    public void deleteLogicById(Integer id);
}
