package com.fayayo.service;

import com.fayayo.pojo.Role;
import com.fayayo.vo.PageData;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
public interface RoleService {

    public Role getRole(Long id);

    public PageData<Role> findRoles(String roleName, int pageNum, int pageSize);

    public int insertRole(Role role);

    public int updateRole(Role role);

    public Role deleteRole(Long id);

}
