package com.huhupa.basicdata.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.PaymentMethod;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
public interface PaymentMethodService extends IBaseService<PaymentMethod, Integer> {

    public PaymentMethod findActiveById(Integer id);

    public List<PaymentMethod> findAllActive();

    public void deleteLogicById(Integer id);
}
