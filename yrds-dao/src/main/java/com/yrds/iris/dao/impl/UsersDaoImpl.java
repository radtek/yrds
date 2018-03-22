package com.yrds.iris.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kivi.framework.db.dao.BaseDao;
import com.kivi.framework.exception.AppException;
import com.yrds.iris.constant.YrdsError;
import com.yrds.iris.dao.UsersDao;
import com.yrds.iris.persist.model.Users;

@Repository
public class UsersDaoImpl extends BaseDao<Users> implements UsersDao {

    private static final Logger log = LoggerFactory.getLogger(UsersDaoImpl.class);

    @Override
    public Users getByStaffId( String staffId, Integer status ) {
        Users entity = new Users();
        entity.setStaffId(staffId);
        entity.setStatus(status);

        List<Users> list = super.selectByEntity(entity);
        if (list == null || list.isEmpty()) {
            log.error("数据库中的员工id[{}]记录不存在", staffId);
            throw new AppException(YrdsError.E_RECORD_NOT_EXIST, "员工信息记录不存在");
        }

        if (list.size() > 1) {
            log.error("数据库中的员工id[{}]记录有多条，无法确定使用哪一条。", staffId);
            throw new AppException(YrdsError.E_RECORD_NOT_UNIQUE, "员工信息记录有重复");
        }

        return list.get(0);
    }

}
