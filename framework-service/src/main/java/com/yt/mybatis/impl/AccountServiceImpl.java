package com.yt.mybatis.impl;

import com.core.mybatis.base.impl.BaseDaoImpl;
import com.yt.mybatis.AccountService;
import com.yt.mybatis.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl extends BaseDaoImpl<Account> implements AccountService {
}
