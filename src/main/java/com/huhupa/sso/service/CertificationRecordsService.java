package com.huhupa.sso.service;

import com.huhupa.base.entity.User;
import com.huhupa.base.service.support.IBaseService;
import com.huhupa.sso.entity.CertificationRecords;

/**
 * <p>
 * 应用服务类
 * </p>
 *
 * @author SPPan
 * @since
 */
public interface CertificationRecordsService extends IBaseService<CertificationRecords,Integer> {

	/**
	 * 添加
	 * @param certificationRecords
	 */
	CertificationRecords saveOrUpdate(CertificationRecords certificationRecords);

	/**
	 * 获取
	 * @param
	 */
	CertificationRecords getCertificationRecords(User user);

	/**
	 *
	 * @param accessToken
	 * @return
	 */
	CertificationRecords getCertificationRecords(String accessToken);

	/**
	 * 删除
	 * @param certificationRecords 数据库的
	 * @return
	 */
	int deleteCertificationRecords(CertificationRecords certificationRecords);
	
}
