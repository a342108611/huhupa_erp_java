package com.huhupa.base.service.business;

import com.huhupa.base.entity.AttendanceRecords;
import com.huhupa.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface AttendanceService extends IBaseService<AttendanceRecords, Integer>{

    void saveOrUpdate(AttendanceRecords records);

    Page<AttendanceRecords> findMyAttendanceList(PageRequest pageRequest);
}
