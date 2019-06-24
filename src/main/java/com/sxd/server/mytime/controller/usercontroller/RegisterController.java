package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.entity.User;
import com.sxd.server.mytime.service.userservice.RegisterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final RegisterService registerService;
    private static final int MESSING_INFORMATION = -1;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //用户注册
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public int register(String name, Integer iconId, String password) {
        User user = new User();
        if (name == null) {
            return MESSING_INFORMATION;
        }
        user.setName(name);
        if (iconId == null) {
            return MESSING_INFORMATION;
        }
        user.setIconId(iconId);
        if (password == null) {
            return MESSING_INFORMATION;
        }
        user.setPassword(password);
        return registerService.register(user);
    }
}
