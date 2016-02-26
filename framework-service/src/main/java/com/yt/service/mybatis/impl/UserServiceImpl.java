package com.yt.service.mybatis.impl;

import com.core.mybatis.base.impl.BaseDaoImpl;
import com.yt.service.mybatis.entity.User;
import com.yt.service.mybatis.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/8/11.
 */
@Service
@Transactional
public class UserServiceImpl  extends BaseDaoImpl<User> implements UserService{
}
