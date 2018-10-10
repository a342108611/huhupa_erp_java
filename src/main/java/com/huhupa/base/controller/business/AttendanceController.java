package com.huhupa.base.controller.business;

import com.huhupa.common.JsonResult;
import com.huhupa.base.controller.BaseController;
import com.huhupa.base.core.permission.PermissionManager;
import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.entity.AttendanceRecords;
import com.huhupa.base.entity.User;
import com.huhupa.base.service.business.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/business")
public class AttendanceController extends BaseController{

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/attendance/fillAttendance")
    public String index() {
        return "business/attendance/fillAttendance";
    }

    @RequestMapping(value = "/attendance/fillAttendance/addForm")
    public String addForm(ModelMap map) {
        User user = TokenManager.getToken(true);
        map.put("user",user);
        return "business/attendance/form";
    }

    @RequestMapping(value = "/attendance/fillAttendance/editForm/{id}")
    public String editForm(@PathVariable Integer id, ModelMap map) {
        AttendanceRecords records = attendanceService.find(id);
        User user = records.getUser();
        map.put("user",user);
        map.put("records",records);
        return "business/attendance/form";
    }

    @RequestMapping(value = "/attendance/delete/{id}")
    @ResponseBody
    public JsonResult deleteObject(@PathVariable Integer id, ModelMap map) {
        try {
            attendanceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/attendance/list")
    @ResponseBody
    public Page<AttendanceRecords> attendanceList(ModelMap map) {
        boolean b = PermissionManager.hasPermission("system:user:index");
        if (b){
            return  attendanceService.findAll(getPageRequest());
        }else{
            Page<AttendanceRecords> records = attendanceService.findMyAttendanceList(getPageRequest());
            return records;
        }

    }

    @RequestMapping(value = "/attendance/save")
    @ResponseBody
    public JsonResult saveOrUpdate(AttendanceRecords records, ModelMap map) {
        try {
            attendanceService.saveOrUpdate(records);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
