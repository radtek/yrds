package com.yrds.iris.dao;

import com.kivi.framework.db.dao.IDao;
import com.yrds.iris.persist.model.Users;

public interface UsersDao extends IDao<Users> {
    /**
     * 根据员工号查询员工信息
     * 
     * @param staffId
     * @return
     */
    Users getByStaffId( String staffId, Integer status );
}
