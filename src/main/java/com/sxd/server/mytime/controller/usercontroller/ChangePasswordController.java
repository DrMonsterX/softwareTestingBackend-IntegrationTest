package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.service.userservice.PasswordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePasswordController {
    private final PasswordService passwordService;
    private static final int MISSING_INFORMATION = -1;

    public ChangePasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    //通过id，新密码来修改用户密码，返回结果。0失败，1成功，2用户不存在。
    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public int changePassword(Integer userId, String password) {
        if (password == null) {
            return MISSING_INFORMATION;
        }
        return passwordService.changePassword(userId, password);
    }
}
