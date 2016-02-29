package com.yt.mybatis.impl;

import com.core.mybatis.base.impl.BaseDaoImpl;
import com.yt.mybatis.AuthService;
import com.yt.mybatis.entity.Auth;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthServiceImpl extends BaseDaoImpl<Auth> implements AuthService {
}
