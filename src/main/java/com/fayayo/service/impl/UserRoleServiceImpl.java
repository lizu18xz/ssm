package com.fayayo.service.impl;

import com.fayayo.dao.UserRoleDao;
import com.fayayo.pojo.UserRole;
import com.fayayo.service.UserRoleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService, ApplicationContextAware {

    @Autowired
    private UserRoleDao userRoleDao = null;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<UserRole> findUserRolesByUserId(Long userId) {
        return userRoleDao.findUserRolesByUserId(userId);
    }

    private UserRoleService proxyService = null;

    // 实现ApplicationContextAware接口的setApplicationContext 注入IoC容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 从Spring IoC容器中获取代理对象
        proxyService = applicationContext.getBean(UserRoleService.class);
    }

    @Override
    // 每次产生新的事务运行子方法，隔离级别为不可重复读
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Integer insertUserRole(Long userId, Long roleId) {
        return userRoleDao.insertUserRole(userId, roleId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Integer insertUserRoles(Long userId, Long[] roleIds) {
        int count = 0;
        for (Long roleId : roleIds) {
            count += this.insertUserRole(userId, roleId);
        }
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Integer deleteUserRoleByUserId(Long userId) {
        return userRoleDao.deleteUserRoleByUserId(userId);
    }

}
