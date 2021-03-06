package com.yt.service.impl;

import com.yt.dao.base.impl.BaseDaoImpl;
import com.yt.entity.base.Account;
import com.yt.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/8/26.
 */
@Service
@Transactional
public class AccountServiceImpl extends BaseDaoImpl<Account> implements AccountService {

}
