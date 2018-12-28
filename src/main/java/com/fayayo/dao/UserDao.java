package com.fayayo.dao;


import com.fayayo.pojo.SexEnum;
import com.fayayo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper // MyBatis映射器
public interface UserDao {

    /**
     * 获取用户信息
     * @param id 用户编号
     * @return 用户信息
     */
    public User getUser(Long id);

    /**
     * 查询符合条件的用户
     * @param userName 用户名称，支持模糊查询
     * @param sex 性别
     * @param start 开始行（用于分页）
     * @param limit 限制记录条数
     * @return 符合条件的用户列表
     */
    public List<User> findUsers(@Param("userName") String userName,
                                @Param("sex") SexEnum sex,
                                @Param("start") int start, @Param("limit") int limit);

    /**
     * 统计符合条件的用户记录数
     * @param userName 用户名称，支持模糊查询
     * @param sex 性别
     * @return 符合条件的用户列表
     */
    public int countUsers(@Param("userName") String userName, @Param("sex") SexEnum sex);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 大于0表示成功，否则失败
     */
    public Integer insertUser(User user);

    /**
     * 更新用户
     * @param user 用户信息
     * @return 大于0表示成功，否则失败
     */
    public Integer updateUser(User user);


    /**
     * 删除用户
     * @param id 用户编号
     * @return 大于0表示成功，否则失败
     */
    public Integer deleteUser(@Param("id") Long id);
}
