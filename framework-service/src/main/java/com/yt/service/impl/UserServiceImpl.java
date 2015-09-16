package com.yt.service.impl;

import com.yt.dao.base.impl.BaseDaoImpl;
import com.yt.entity.User;
import com.yt.service.UserService;
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
