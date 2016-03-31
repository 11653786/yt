package com.yt.service.mybatis.impl;

import com.yt.core.dao.impl.BaseDaoImpl;
import com.yt.entity.mybatis.Employee;
import com.yt.service.mybatis.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl extends BaseDaoImpl<Employee> implements EmployeeService {
}
