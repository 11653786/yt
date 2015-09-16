package com.yt.service;

import com.yt.dao.base.BaseDao;
import com.yt.entity.User;

/**
 * Created by user on 2015/8/11.
 */
public interface UserService extends BaseDao<User>{

    public void init();

}
