package com.dian.mycleandemo.data.source.local;

import com.dian.mycleandemo.data.entity.User;
import com.dian.mycleandemo.data.source.local.db.DBM;

/**
 * Created by Dian on 2018/12/23
 * 本地数据请求
 */
public class LocalSource implements ILocalRequest{
    @Override
    public void saveUserInfo(User user) {
        DBM.getUserDao().insertOrReplace(user);
    }
}
