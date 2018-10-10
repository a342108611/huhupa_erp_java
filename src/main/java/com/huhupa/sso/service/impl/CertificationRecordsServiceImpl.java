package com.huhupa.sso.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.entity.User;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.sso.dao.CertificationRecordsDao;
import com.huhupa.sso.entity.CertificationRecords;
import com.huhupa.sso.service.CertificationRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class CertificationRecordsServiceImpl extends BaseServiceImpl<CertificationRecords, Integer> implements CertificationRecordsService {

	@Autowired
	private CertificationRecordsDao certificationRecordsDao;

	@Override
	public IBaseDao<CertificationRecords, Integer> getBaseDao() {
		return this.certificationRecordsDao;
	}

	@Override
	public CertificationRecords saveOrUpdate(CertificationRecords certificationRecords) {
		if (null == certificationRecords) {
			throw new RuntimeException("要保存的认证记录不能为空");
		}
		try {
			CertificationRecords save = certificationRecordsDao.save(certificationRecords);
			return save;
		}catch (Exception e){
			e.printStackTrace();
			this.logger.error("" + e);
		}
		return null;
	}

	@Override
	public CertificationRecords getCertificationRecords(User user) {
		return null;
	}

	@Override
	public CertificationRecords getCertificationRecords(String accessToken) {
		return null;
	}

	@Override
	public int deleteCertificationRecords(CertificationRecords certificationRecords) {
		return 0;
	}
}
