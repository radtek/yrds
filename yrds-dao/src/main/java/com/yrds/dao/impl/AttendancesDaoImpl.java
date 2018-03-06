package com.yrds.dao.impl;


import org.springframework.stereotype.Repository;

import com.kivi.framework.db.dao.BaseDao;
import com.yrds.dao.AttendancesDao;
import com.yrds.persist.model.Attendances;

@Repository
public class AttendancesDaoImpl extends BaseDao<Attendances> implements AttendancesDao {

}
