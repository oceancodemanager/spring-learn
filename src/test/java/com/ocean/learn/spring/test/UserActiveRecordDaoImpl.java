
package com.dayee.wintalent.report.user.dao;

import java.util.Date;

import com.dayee.utilities.lang.DateUtil;
import com.dayee.wintalent.framework.dao.jdbc.MappingDaoImpl;

public class UserActiveRecordDaoImpl extends MappingDaoImpl implements UserActiveRecordDao {

    private static final String INSERT_RECORD = "INSERT INTO t_user_active_record(F_USER_ID,F_SESSION_ID,F_LOGIN_TIME,F_LAST_ACTIVE_TIME,F_LAST_ACTIVE_TYPE,F_DATE) values(?,?,?,?,?,?)";

    @Override
    public void insertRecord(Integer userId, String sessionId, Date now, int lastActiveType) {

        String date = DateUtil.format(now, DateUtil.DATE_FORMAT_YMD);
        super.update(INSERT_RECORD, userId, sessionId, now, now, lastActiveType, date);
    }

    private static final String UPDATE_LAST_ACTIVE_TIME = "UPDATE t_user_active_record SET F_LAST_ACTIVE_TIME=?,F_LAST_ACTIVE_TYPE=? WHERE F_SESSION_ID = ? AND F_USER_ID = ? AND F_DATE = ?";

    @Override
    public void updateLastActiveTime(Integer userId, String sessionId, Date now, int lastActiveType) {

        String date = DateUtil.format(now, DateUtil.DATE_FORMAT_YMD);
        super.update(UPDATE_LAST_ACTIVE_TIME, now, lastActiveType, sessionId, userId, date);
    }
}
