package pers.niaonao.jdbcproject.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.niaonao.jdbcproject.dao.SkrUserDao;
import pers.niaonao.jdbcproject.entity.RequestEntity;
import pers.niaonao.jdbcproject.entity.ResultEntity;
import pers.niaonao.jdbcproject.entity.SkrUser;
import pers.niaonao.jdbcproject.service.SkrUserService;
import pers.niaonao.jdbcproject.util.GenerateIdUtil;
import pers.niaonao.jdbcproject.util.MD5Util;

import java.util.List;

/**
 * @Author: niaonao
 * @Date: Created in 16:29 2018/7/29
 * @Desprition: 用户业务实现类
 */
@Service
public class SkrUserServiceImpl implements SkrUserService {

    @Autowired
    private SkrUserDao skrUserDao;

    @Override
    public ResultEntity getSkrUser(RequestEntity requestEntity) {
        //解析请求数据
        SkrUser user = JSONObject.parseObject(requestEntity.getTreasureData(), SkrUser.class);

        Boolean success = Boolean.FALSE;
        String errorMsg = "获取用户信息成功！";
        if (user == null){
            errorMsg = "请求数据不能为空！";
        } else {
            //根据请求参数查询用户信息
            user = skrUserDao.selectByParams(user);
            if (user == null){
                errorMsg = "用户信息不存在！";
            } else {
                success = Boolean.TRUE;
            }
        }

        //封装返回结果
        ResultEntity resultEntity = new ResultEntity(success,errorMsg,user);
        return resultEntity;
    }

    @Override
    public ResultEntity getSkrUserList(RequestEntity requestEntity) {
        //解析请求数据
        SkrUser user = JSONObject.parseObject(requestEntity.getTreasureData(), SkrUser.class);
        if (user == null){
            user = new SkrUser();
        }

        //获取用户信息集合
        List<SkrUser> userList = skrUserDao.getList(user);

        //初始化执行结果
        Boolean success = Boolean.TRUE;
        String errorMsg = "获取用户信息成功！";
        if (userList == null) {
            success = Boolean.FALSE;
            errorMsg = "用户信息不存在！！";
        }

        //封装返回结果
        ResultEntity resultEntity = new ResultEntity(success,errorMsg,userList);
        return resultEntity;
    }

    @Override
    public ResultEntity updateSkrUser(RequestEntity requestEntity) {
        //解析请求数据
        SkrUser user = JSONObject.parseObject(requestEntity.getTreasureData(), SkrUser.class);

        Boolean success = Boolean.FALSE;
        String errorMsg = "更新用户信息成功！";
        if (user == null){
            errorMsg = "请求数据不能为空！";
        } else if (user.getUserId() == null || user.getUserId().equals("")){
            errorMsg = "用户编号不能为空！";
        } else {
            //更新用户信息
            int resultRow = skrUserDao.updateByIdSelective(user);
            if (resultRow < 1){
                errorMsg = "更新用户失败！";
            }else {
                success = Boolean.TRUE;
            }
        }

        //封装返回结果
        ResultEntity resultEntity = new ResultEntity(success, errorMsg, null);
        return resultEntity;
    }

    @Override
    public ResultEntity deleteSkrUser(RequestEntity requestEntity) {

        //解析请求数据
        SkrUser user = JSONObject.parseObject(requestEntity.getTreasureData(), SkrUser.class);

        Boolean success = Boolean.FALSE;
        String errorMsg = "用户删除成功！";
        if (user == null){
            errorMsg = "请求数据不能为空！";
        } else if (user.getUserId() == null || user.getUserId().equals("")){
            errorMsg = "用户编号不能为空！";
        } else {
            //删除用户信息
            int resultRow = skrUserDao.deleteById(user);
            if (resultRow < 1){
                errorMsg = "删除用户失败！";
            }else {
                success = Boolean.TRUE;
            }
        }

        //封装返回结果
        ResultEntity resultEntity = new ResultEntity(success, errorMsg, null);
        return resultEntity;
    }

    @Override
    public ResultEntity addSkrUser(RequestEntity requestEntity) {

        //解析请求数据
        SkrUser user = JSONObject.parseObject(requestEntity.getTreasureData(), SkrUser.class);

        Boolean success = Boolean.FALSE;
        String errorMsg = "添加用户成功！";
        if (user == null){
            errorMsg = "请求数据不能为空！";
        } else if (user.getUserNickName() == null || user.getUserPassword() == null
                || user.getUserNickName().equals("") || user.getUserPassword().equals("")){
            errorMsg = "用户名和密码不能为空！";
        } else {
            //生成id，此处参数自定义，作为数据表标识。此处以1234 标识skr_user
            user.setUserId(GenerateIdUtil.generateId("1234"));
            //登录密码加密
            user.setUserPassword(MD5Util.getMD5(user.getUserPassword()));

            //插入用户信息
            int resultRow = skrUserDao.insertBySelective(user);
            if (resultRow < 1){
                errorMsg = "添加用户失败！";
            }else {
                success = Boolean.TRUE;
            }
        }

        //封装返回结果
        ResultEntity resultEntity = new ResultEntity(success, errorMsg, null);
        return resultEntity;
    }
}
