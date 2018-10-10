package com.huhupa.base.core.permission;

import com.huhupa.base.config.shiro.freemarker.HasPermissionTag;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component("permissionManager")
public class PermissionManager extends HasPermissionTag{

    PermissionManager(){
        super();
    }
    public static boolean hasPermission(String p){
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(p);
    }

}
