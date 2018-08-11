package pers.niaonao.jdbcproject.dao;

import pers.niaonao.jdbcproject.entity.SkrUser;

import java.util.List;

/**
 * @Author: niaonao
 * @Date: Created in 16:25 2018/7/29
 * @Desprition: 用户持久层接口类
 */
public interface SkrUserDao {
    /**
     * 多条件查询获取实体信息
     * @param SkrUser
     * @return
     */
    SkrUser selectByParams(SkrUser SkrUser);

    /**
     * 获取全部用户
     * @param SkrUser
     * @return
     */
    List<SkrUser> getList(SkrUser SkrUser);

    /**
     * 更新用户信息(如果字段不为空更新)
     * @param SkrUser
     * @return
     */
    int updateByIdSelective(SkrUser SkrUser);

    /**
     * 根据id删除实体信息
     * @param SkrUser
     * @return
     */
    int deleteById(SkrUser SkrUser);

    /**
     * 插入用户记录
     * @param SkrUser
     * @return
     */
    int insert(SkrUser SkrUser);

    /**
     * 根据不为空的参数插入用户记录
     * @param SkrUser
     * @return
     */
    int insertBySelective(SkrUser SkrUser);
}
