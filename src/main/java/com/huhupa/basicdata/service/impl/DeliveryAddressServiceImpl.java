package com.huhupa.basicdata.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.DeliveryAddressDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.DeliveryAddress;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.DeliveryAddressService;
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
@Service("deliveryAddressService")
public class DeliveryAddressServiceImpl extends BaseServiceImpl<DeliveryAddress, Integer> implements DeliveryAddressService {

	@Autowired
	private DeliveryAddressDao deliveryAddressDao;

	@Override
	public IBaseDao<DeliveryAddress, Integer> getBaseDao() {
		return deliveryAddressDao;
	}
}
