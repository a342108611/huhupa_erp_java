package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Product;
import com.huhupa.basicdata.entity.ProductCategory;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface ProductCategoryService extends IBaseService<ProductCategory, Integer> {

    public ProductCategory findActiveById(Integer id);

    public List<ProductCategory> findAllActive();

    public void deleteLogicById(Integer id);
}
