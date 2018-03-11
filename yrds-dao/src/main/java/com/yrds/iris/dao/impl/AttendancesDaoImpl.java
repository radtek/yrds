package com.yrds.iris.dao.impl;


import org.springframework.stereotype.Repository;

import com.kivi.framework.db.dao.BaseDao;
import com.yrds.iris.dao.AttendancesDao;
import com.yrds.iris.persist.model.Attendances;

@Repository
public class AttendancesDaoImpl extends BaseDao<Attendances> implements AttendancesDao {

}
