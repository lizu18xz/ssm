package com.fayayo.service;

import com.fayayo.pojo.SexEnum;
import com.fayayo.pojo.User;
import com.fayayo.vo.PageData;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
public interface UserService {

    /**
     *  按用户id查询用户
     * @param id 用户编号
     * @return 用户
     */
    public User getUser(Long id);

    /**
     * 查询用户信息
     * @param userName 用户名称
     * @param sex 性别
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return 分页数据和信息
     */
    public PageData<User> findUsers(String userName, SexEnum sex, int pageNum, int pageSize);

    /**
     * 插入用户和用户角色关系
     * @param user 用户信息
     * @param roleIds 关联角色信息
     * @return 插入用户记录数
     */
    public Integer insertUser(User user, Long[] roleIds);

    /**
     * 更新角色信息
     * @param user 用户信息
     * @param roleIds 角色信息
     * @return 更新用户记录数
     */
    public Integer updateUser(User user, Long[] roleIds);

    /**
     * 删除用户信息
     * @param id 用户编号
     * @return 用户信息
     */
    public User deleteUser(Long id);

}
