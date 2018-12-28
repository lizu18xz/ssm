package com.fayayo.controller;

import com.fayayo.pojo.SexEnum;
import com.fayayo.pojo.User;
import com.fayayo.service.UserService;
import com.fayayo.vo.PageData;
import com.fayayo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 获取用户信息
    @GetMapping("/user/{id}")
    @ResponseBody
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return UserVo.of(user);
    }



    // 查询
    @PostMapping("/users")
    @ResponseBody
    public PageData<UserVo> findUsers(@RequestParam(required=false) String userName,
                                      @RequestParam(required=false) Integer sexCode,
                                      @RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize) {
        SexEnum sex = null;
        if (sexCode != null) {
            sex = SexEnum.getSexByCode(sexCode);
        }
        PageData<User> pageUser = userService.findUsers(userName, sex, pageNum, pageSize);
        return UserVo.of(pageUser);
    }

}
