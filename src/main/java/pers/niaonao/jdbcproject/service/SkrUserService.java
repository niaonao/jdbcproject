package pers.niaonao.jdbcproject.service;

import pers.niaonao.jdbcproject.entity.RequestEntity;
import pers.niaonao.jdbcproject.entity.ResultEntity;

/**
 * @Author: niaonao
 * @Date: Created in 16:26 2018/7/29
 * @Desprition: 用户业务接口
 */
public interface SkrUserService {
    /**
     * 多条件获取用户
     * @param requestEntity
     * @return
     */
    ResultEntity getSkrUser(RequestEntity requestEntity);

    /**
     * 获取全部用户
     * @param requestEntity
     * @return
     */
    ResultEntity getSkrUserList(RequestEntity requestEntity);

    /**
     * 更新用户信息(如果字段不为空更新)
     * @param requestEntity
     * @return
     */
    ResultEntity updateSkrUser(RequestEntity requestEntity);

    /**
     * 根据id删除用户信息
     * @param requestEntity
     * @return
     */
    ResultEntity deleteSkrUser(RequestEntity requestEntity);

    /**
     * 注册用户
     * @param requestEntity
     * @return
     */
    ResultEntity addSkrUser(RequestEntity requestEntity);
}
