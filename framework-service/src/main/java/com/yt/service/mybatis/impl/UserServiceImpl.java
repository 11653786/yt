package com.yt.service.mybatis.impl;

import com.yt.dao.base.mybatis.impl.BaseDaoImpl;
import com.yt.entity.base.User;
import com.yt.service.mybatis.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/8/11.
 */
@Service
@Transactional
public class UserServiceImpl  extends BaseDaoImpl<User> implements UserService{

    public void init(){
        super.getEntityClass();
    }



}
