package com.huhupa.config;

import java.util.List;

public interface Constant {
	
	/**
	 * 访问白名单
	 */
	String[] accessWhitelist = {
			"/license.html",
			"/user/login",
			"/api/v1/license/register",
			"/drawImage",
			"/logout",
			"/error",
			"/api/v1/license/apply"
			};

}
