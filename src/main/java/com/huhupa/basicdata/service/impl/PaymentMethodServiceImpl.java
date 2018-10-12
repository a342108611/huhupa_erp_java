package com.huhupa.basicdata.service.impl;

import com.huhupa.base.common.Global;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.basicdata.dao.ClerkDao;
import com.huhupa.basicdata.dao.PaymentMethodDao;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.IncomeCategory;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.PaymentMethodService;
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
@Service("paymentMethodService")
public class PaymentMethodServiceImpl extends BaseServiceImpl<PaymentMethod, Integer> implements PaymentMethodService {

	@Autowired
	private PaymentMethodDao paymentMethodDao;

	@Override
	public IBaseDao<PaymentMethod, Integer> getBaseDao() {
		return paymentMethodDao;
	}

	@Override
	public PaymentMethod findActiveById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id不能为空");
		}
		PaymentMethod res = new PaymentMethod();
		res.setValid(Global.ACTIVE);
		res.setId(id);
		return paymentMethodDao.findOne(Example.of(res));
	}

	@Override
	public List<PaymentMethod> findAllActive() {
		PaymentMethod res = new PaymentMethod();
		res.setValid(Global.ACTIVE);
		return paymentMethodDao.findAll(Example.of(res));
	}

	@Override
	public void deleteLogicById(Integer id) {
		if (null == id) {
			throw new RuntimeException("id为空");
		}
		PaymentMethod res = new PaymentMethod();
		res.setId(id);
		PaymentMethod one = paymentMethodDao.findOne(Example.of(res));
		if (one != null) {
			one.setValid(Global.DELETE);
			paymentMethodDao.saveAndFlush(one);
		}
	}
}
