package com.huhupa.base.service.business.impl;

import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.dao.business.AttendanceDao;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.entity.AttendanceRecords;
import com.huhupa.base.entity.User;
import com.huhupa.base.service.business.AttendanceService;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("attendanceService")
public class AttendanceServiceImpl extends BaseServiceImpl<AttendanceRecords, Integer> implements AttendanceService{

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public IBaseDao<AttendanceRecords, Integer> getBaseDao() {
        return this.attendanceDao;
    }

    @Override
    public void saveOrUpdate(AttendanceRecords records) {
        if(null != records.getId()){
            AttendanceRecords ar = find(records.getId());
            ar.setDays(records.getDays());
            ar.setStartTime(records.getStartTime());
            ar.setEndTime(records.getEndTime());
            ar.setType(records.getType());
            ar.setNote(records.getNote());
            ar.setUpdatedTime(new Date());
            ar.setUser(records.getUser());
            update(ar);
        }else{
            Date date = new Date();
            records.setCreatedTime(date);
            records.setUpdatedTime(date);
            records.setValid(1);
            save(records);
        }
    }

    @Override
    public Page<AttendanceRecords> findMyAttendanceList(PageRequest pageRequest) {
        User token = TokenManager.getToken(true);
        AttendanceRecords records = new AttendanceRecords();
        records.setUser(token);
        Example<AttendanceRecords> recordsExample = Example.of(records);
        Page<AttendanceRecords> all = this.getBaseDao().findAll(recordsExample, pageRequest);
        return all;
    }
}
