package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.PaymentMethodDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service("paymentMethodService")
public class PaymentMethodServiceImpl extends BaseServiceImpl<PaymentMethod, Integer> implements PaymentMethodService {

	@Autowired
	private PaymentMethodDao paymentMethodDao;

	@Override
	public IBaseDao<PaymentMethod, Integer> getBaseDao() {
		return paymentMethodDao;
	}
}
