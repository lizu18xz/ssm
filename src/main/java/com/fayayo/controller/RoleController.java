package com.fayayo.controller;

import com.fayayo.pojo.Role;
import com.fayayo.service.RoleService;
import com.fayayo.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
@Controller
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping("/role/{id}")
    @ResponseBody
    public Role getRole(@PathVariable("id") Long id) {
        return roleService.getRole(id);
    }


    @PostMapping("/roles")
    @ResponseBody
    public PageData<Role> findRoles(String roleName, @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {

        return this.roleService.findRoles(roleName, pageNum, pageSize);
    }

    /**
     * 新增或者更新角色信息
     * @param role 角色，客户端需要用json提交
     * @param type
     * @return
     */
    @PostMapping("/role/{type}")
    @ResponseBody
    public Role saveOrUpdate(@RequestBody Role role, @PathVariable("type") String type) {
        int result = 0;
        if ( "add".equals(type)) {
            result = this.roleService.insertRole(role);
        } else {
            if (0 == this.roleService.updateRole(role)) {
                throw new RuntimeException("新增或者修改角色失败了，请联系管理员。");
            } else {
                result = 1;
            }
        }
        return result > 0 ? role : null;
    }

    // 删除角色，使用@DeleteMapping
    @DeleteMapping("/role/{id}")
    @ResponseBody
    public Role deleteRole(@PathVariable("id") Long id) {
        Role role = this.roleService.deleteRole(id);
        if (role == null) {
            throw new RuntimeException("删除角色失败了，请联系管理员。");
        }
        return role;
    }


}
