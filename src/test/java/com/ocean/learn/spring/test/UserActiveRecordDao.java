
package com.dayee.wintalent.report.user.dao;

import java.util.Date;

public interface UserActiveRecordDao {

    public void insertRecord(Integer userId,
                             String sessionId,
                             Date date,
                             int lastActiveType);

    public void updateLastActiveTime(Integer userId,
                                     String sessionId,
                                     Date date,
                                     int lastActiveType);
}
