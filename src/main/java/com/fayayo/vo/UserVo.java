package com.fayayo.vo;


import com.fayayo.pojo.SexEnum;
import com.fayayo.pojo.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserVo implements Serializable {

    public static final Long serialVersionUID = -8571855463791276093L;
    private Long id;
    private String userName;
    private int sexCode;
    private String sexName;
    private String note;
    private String roleIds;

    public static UserVo of(User user) {
        UserVo vo = new UserVo();
        vo.setId(user.getId());
        vo.setUserName(user.getUserName());
        vo.setSexCode(user.getSex().getCode());
        vo.setSexName(user.getSex().getName());
        vo.setNote(user.getNote());
        return vo;
    }

    public static List<UserVo> of(List<User> userList) {
        List<UserVo> voList = new ArrayList<>();
        if (userList == null || userList.isEmpty()) {
            return voList;
        }
        for (User user : userList) {
            UserVo vo = of(user);
            voList.add(vo);
        }
        return voList;
    }

    public static PageData<UserVo> of(PageData<User> userPage) {
        List<UserVo> voList = of(userPage.getRows());
        PageData<UserVo> pageVo = new PageData<>(
                userPage.getTotal(), userPage.getPageSize(), userPage.getCurrentPage(), voList);
        return pageVo;
    }

    public User toPo() {
        User user = new User();
        user.setId(this.getId());
        user.setUserName(this.getUserName());
        user.setNote(this.getNote());
        user.setSex(SexEnum.getSexByCode(this.getSexCode()));
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSexCode() {
        return sexCode;
    }

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}
