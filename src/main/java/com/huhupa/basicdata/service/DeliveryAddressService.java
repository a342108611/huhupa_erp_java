package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.DeliveryAddress;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface DeliveryAddressService extends IBaseService<DeliveryAddress, Integer> {

    public DeliveryAddress findActiveById(String id);

    public List<DeliveryAddress> findAllActive();

    public void deleteLogicById(String id);
}
