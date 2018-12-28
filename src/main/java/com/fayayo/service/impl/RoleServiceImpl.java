package com.fayayo.service.impl;

import com.fayayo.dao.RoleDao;
import com.fayayo.pojo.Role;
import com.fayayo.service.RoleService;
import com.fayayo.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public PageData<Role> findRoles(String roleName, int pageNum, int pageSize) {

        //计算开始记录下标
        int start = (pageNum - 1) * pageSize;

        //查询当前页
        List<Role> roleList = roleDao.findRoles(roleName, start, pageSize);

        //查询总数
        int total = roleDao.countRoles(roleName);

        //生成分页信息
        PageData<Role> pageData = new PageData<>(total, pageSize, pageNum, roleList);

        return pageData;
    }

    @Override
    public int insertRole(Role role) {

        int result = roleDao.insertRole(role);

        return result;
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Role deleteRole(Long id) {

        Role role = roleDao.getRole(id);
        int result = roleDao.deleteRole(id);
        return result > 0 ? role : null;
    }

}
