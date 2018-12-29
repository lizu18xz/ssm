package com.fayayo.dao;

import com.fayayo.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleDao {

    public List<UserRole> findUserRolesByUserId(@Param("userId") Long userId);

    public Integer insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    public Integer deleteUserRoleByUserId(@Param("userId") Long userId);
}
