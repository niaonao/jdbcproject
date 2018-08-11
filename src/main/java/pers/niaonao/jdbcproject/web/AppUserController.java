package pers.niaonao.jdbcproject.web;

import org.springframework.web.bind.annotation.*;
import pers.niaonao.jdbcproject.entity.RequestEntity;
import pers.niaonao.jdbcproject.entity.ResultEntity;
import pers.niaonao.jdbcproject.service.SkrUserService;

import javax.annotation.Resource;

/**
 * @Author: niaonao
 * @Date: Created in 16:27 2018/7/29
 * @Desprition: 前端访问接口的控制类
 */
@RestController
@RequestMapping(value = "/app")
public class AppUserController {

    @Resource
    private SkrUserService skrUserService;

    /**
     * 获取用户信息列表
     * 多条件模糊查询
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user/getAllSkrUser", produces ="application/json;charset=UTF-8" )
    public ResultEntity getSkrUserList(@RequestBody RequestEntity requestEntity) {
        return skrUserService.getSkrUserList(requestEntity);
    }

    /**
     * 获取用户
     * @param requestEntity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user/getSkrUser", produces ="application/json;charset=UTF-8" )
    public ResultEntity getSkrUser(@RequestBody RequestEntity requestEntity) {
        return skrUserService.getSkrUser(requestEntity);
    }

    /**
     * 更新用户
     * @param requestEntity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user/updateSkrUser", produces ="application/json;charset=UTF-8" )
    public ResultEntity updateSkrUser(@RequestBody RequestEntity requestEntity) {
        return skrUserService.updateSkrUser(requestEntity);
    }

    /**
     * 注册用户
     * @param requestEntity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user/registerSkrUser", produces ="application/json;charset=UTF-8" )
    public ResultEntity addSkrUser(@RequestBody RequestEntity requestEntity) {
        return skrUserService.addSkrUser(requestEntity);
    }


    /**
     * 删除用户
     * @param requestEntity
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/user/deleteSkrUser", produces ="application/json;charset=UTF-8" )
    public ResultEntity deleteSkrUser(@RequestBody RequestEntity requestEntity) {
        return skrUserService.deleteSkrUser(requestEntity);
    }

}
