package com.fayayo.dao;

import com.fayayo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
@Mapper
public interface RoleDao {


    /**
     *  插入角色，并且更新POJO主键
     * @param role 角色信息
     * @return 影响记录数
     */
    public int insertRole(Role role);

    /**
     *  更新角色
     * @param role 角色信息
     * @return 影响记录数
     */
    public int updateRole(Role role);

    /**
     * 获取角色
     * @param id -- 主键
     * @return 角色信息
     */
    public Role getRole(Long id);

    /**
     * 查询角色
     * @param roleName 角色名称，支持模糊查询
     * @param start 开始行数
     * @param limit 限制至多返回条数
     * @return 角色信息列表
     */
    public List<Role> findRoles(@Param("roleName") String roleName,
                                @Param("start") int start, @Param("limit") int limit);

    /**
     * 统计符合条件的角色总数
     * @param roleName 角色名称，支持模糊查询
     * @return 总数
     */
    public Integer countRoles(@Param("roleName") String roleName);

    /**
     * 删除角色
     * @param id -- 主键
     * @return 影响记录数
     */
    public Integer deleteRole(@Param("id") Long id);


}
