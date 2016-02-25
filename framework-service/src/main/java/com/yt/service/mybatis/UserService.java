package com.yt.service.mybatis;

import com.yt.dao.base.mybatis.BaseDao;
import com.yt.entity.base.User;

/**
 * Created by user on 2015/8/11.
 */
public interface UserService extends BaseDao<User>{

    public void init();

}
