package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.common.utils.StringUtils;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.DeliveryAddressDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.DeliveryAddress;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public DeliveryAddress findActiveById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("id不能为空");
		}
		DeliveryAddress res = new DeliveryAddress();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return deliveryAddressDao.findOne(Example.of(res));
	}

	@Override
	public List<DeliveryAddress> findAllActive() {
		return null;
	}

	@Override
	public void deleteLogicById(String id) {

	}
}
