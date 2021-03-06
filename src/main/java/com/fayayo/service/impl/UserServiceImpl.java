package com.fayayo.service.impl;

import com.fayayo.dao.UserDao;
import com.fayayo.pojo.SexEnum;
import com.fayayo.pojo.User;
import com.fayayo.service.UserRoleService;
import com.fayayo.service.UserService;
import com.fayayo.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public PageData<User> findUsers(String userName, SexEnum sex, int pageNum, int pageSize) {
        // 计算开始行
        int start =(pageNum -1) * pageSize;
        // 查询
        List<User> userList = userDao.findUsers(userName, sex, start, pageSize);
        // 总数
        int total = userDao.countUsers(userName, sex);
        // 构建分页
        PageData<User> userPageData =  new PageData<>(total, pageSize, pageNum, userList);
        return userPageData;
    }

    @Override
    public Integer insertUser(User user, Long[] roleIds) {
        int result = userDao.insertUser(user);

        return result;
    }

    @Override
    public Integer updateUser(User user, Long[] roleIds) {
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User deleteUser(Long id) {
        User user = userDao.getUser(id);
        int result = userDao.deleteUser(id);
        // 调用用户角色删除，子方法调用从而产生传播行为
        userRoleService.deleteUserRoleByUserId(id);
        return result > 0 ? user : null;
    }
}
