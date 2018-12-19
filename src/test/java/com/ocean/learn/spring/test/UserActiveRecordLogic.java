
package com.dayee.wintalent.report.user.logic;

import java.util.Date;

import com.dayee.utilities.lang.DateUtil;
import com.dayee.wintalent.framework.constant.RequestConstants;
import com.dayee.wintalent.report.user.constants.UserActiveRecordConstants;
import com.dayee.wintalent.report.user.dao.UserActiveRecordDao;

public class UserActiveRecordLogic {

    private UserActiveRecordDao userActiveRecordDao;

    /**
     * 新增记录则返回字符串，无新增则返回null
     * 
     * @param userId
     * @param sessionId
     * @param sessionUserActiveKey
     * @return
     */
    public String recordLogin(Integer userId, String sessionId, Object sessionUserActiveKey) {

        Date now = new Date();
        String date = DateUtil.format(now, DateUtil.DATE_FORMAT_YMD);
        String userActiveKey = sessionId + RequestConstants.USER_ACTIVE_KEY_SPLIT
                               + userId
                               + RequestConstants.USER_ACTIVE_KEY_SPLIT
                               + date;
        if (sessionUserActiveKey == null) {
            userActiveRecordDao.insertRecord(userId, sessionId, now, UserActiveRecordConstants.LAST_ACTIVE_TYPE_LOGIN);
            return userActiveKey;
        } else {
            if (!((String) sessionUserActiveKey).equals(userActiveKey)) {
                userActiveRecordDao.insertRecord(userId, sessionId, now,
                                                 UserActiveRecordConstants.LAST_ACTIVE_TYPE_LOGIN);
                return userActiveKey;
            }
        }
        return null;
    }

    /**
     * 新增记录则返回字符串，无新增则返回null
     * 
     * @param userId
     * @param sessionId
     * @param sessionUserActiveKey
     * @return
     */
    public String recordLastActiveTime(Integer userId,
                                       String sessionId,
                                       int lastActiveType,
                                       Object sessionUserActiveKey) {

        Date now = new Date();
        String userActiveKey = null;
        // 判断是否去加记录
        if (lastActiveType != UserActiveRecordConstants.LAST_ACTIVE_TYPE_LOGIN
            && lastActiveType != UserActiveRecordConstants.LAST_ACTIVE_TYPE_FORCE_LOGOUT) {
            userActiveKey = recordLogin(userId, sessionId, sessionUserActiveKey);
        }
        if (userActiveKey == null) {
            userActiveRecordDao.updateLastActiveTime(userId, sessionId, now, lastActiveType);
        }
        return userActiveKey;
    }

    public UserActiveRecordDao getUserActiveRecordDao() {

        return userActiveRecordDao;
    }

    public void setUserActiveRecordDao(UserActiveRecordDao userActiveRecordDao) {

        this.userActiveRecordDao = userActiveRecordDao;
    }
}
