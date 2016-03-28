package com.yt.service.mybatis.impl;

import com.core.mybatis.base.impl.BaseDaoImpl;
import com.yt.mybatis.entity.Employee;
import com.yt.service.mybatis.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl extends BaseDaoImpl<Employee> implements AccountService {
}
