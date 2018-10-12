package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Company;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface BasicMaterialService extends IBaseService<BasicMaterial, Integer> {

    public BasicMaterial findActiveById(Integer id);

    public List<BasicMaterial> findAllActive();

    public void deleteLogicById(Integer id);
}
