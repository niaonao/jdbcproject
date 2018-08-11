package pers.niaonao.jdbcproject.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pers.niaonao.jdbcproject.dao.SkrUserDao;
import pers.niaonao.jdbcproject.entity.SkrUser;
import pers.niaonao.jdbcproject.util.MD5Util;

import java.util.List;

/**
 * @Author: niaonao
 * @Date: Created in 16:29 2018/7/29
 * @Desprition: 用户持久层接口实现类
 */
@Repository
public class SkrUserDaoImpl implements SkrUserDao  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SkrUser selectByParams(SkrUser skrUser) {

        //拼接多条件查询语句，支持模糊查询
        String sql = " select user_id, user_nick_name, user_password, user_real_name," +
                " user_gender, user_card, user_phone, user_address from skr_user WHERE ";
        if (skrUser.getUserId() != null){
            sql = sql + " user_id = '" + skrUser.getUserId() + "' AND ";
        }
        if (skrUser.getUserRealName() != null) {
            sql = sql + " user_real_name = '" + skrUser.getUserRealName() + "' AND ";
        }
        if (skrUser.getUserNickName() != null){
            sql = sql + " user_nick_name = '" + skrUser.getUserNickName() + "' AND ";
        }
        if (skrUser.getUserPassword() != null){
            sql = sql + " user_password = '" + MD5Util.getMD5(skrUser.getUserPassword()) + "' AND ";
        }
        if (skrUser.getUserPassword() != null){
            sql = sql + " user_phone = '" + skrUser.getUserPhone() + "' AND ";
        }
        if (skrUser.getUserPassword() != null){
            sql = sql + " user_gender = '" + skrUser.getUserGender() + "' AND ";
        }
        if (skrUser.getUserPassword() != null){
            sql = sql + " user_address = '" + skrUser.getUserAddress() + "' AND ";
        }

        //截取SQl语句多余后缀
        if (sql.endsWith("AND ")){
            sql = sql.substring(0,sql.length() - 4);
        }

        //封装执行SQL 语句结果
        List<SkrUser> skrUserList = jdbcTemplate.query(sql ,new Object[]{}, new BeanPropertyRowMapper(SkrUser.class)) ;
        if (skrUserList == null || skrUserList.size() < 1){
            return null;
        }
        return skrUserList.get(0);
    }

    @Override
    public List<SkrUser> getList(SkrUser skrUser) {
        //拼接SQL语句
        String sql = " SELECT user_id, user_nick_name, user_password, user_real_name," +
                " user_gender, user_card, user_phone, user_address FROM skr_user WHERE ";

        if (skrUser.getUserId() != null){
            sql = sql + " user_id = '" + skrUser.getUserId() + "' AND ";
        }
        if (skrUser.getUserRealName() != null) {
            sql = sql + " user_real_name LIKE '%" + skrUser.getUserRealName() + "%' AND ";
        }
        if (skrUser.getUserNickName() != null){
            sql = sql + " user_nick_name LIKE '%" + skrUser.getUserNickName() + "%' AND ";
        }
        if (skrUser.getUserPassword() != null){
            sql = sql + " user_password LIKE '%" + MD5Util.getMD5(skrUser.getUserPassword()) + "%' AND ";
        }
        if (skrUser.getUserPhone() != null){
            sql = sql + " user_phone LIKE '%" + skrUser.getUserPhone() + "%' AND ";
        }
        if (skrUser.getUserGender() == 1 || skrUser.getUserGender() == 0){
            sql = sql + " user_gender LIKE '%" + skrUser.getUserGender() + "%' AND ";
        }
        if (skrUser.getUserAddress() != null){
            sql = sql + " user_address LIKE '%" + skrUser.getUserAddress() + "%' AND ";
        }

        //截取SQl语句多余后缀
        if (sql.endsWith("WHERE ")){
            sql = sql.substring(0,sql.length() - 6);
        }else if (sql.endsWith("AND ")){
            sql = sql.substring(0,sql.length() - 4);
        }

        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(SkrUser.class));
    }

    @Override
    public int updateByIdSelective(SkrUser skrUser) {
        //根据对象唯一ID更新
        if (skrUser.getUserId() == null){
            return 0;
        }

        //拼接SQL语句,拼接SQL语句考虑拼接的数据加单引号
        String sql = "UPDATE skr_user SET " ;
        if (skrUser.getUserRealName() != null) {
            sql = sql + " user_real_name = '" + skrUser.getUserRealName() + "' , ";
        }
        if (skrUser.getUserNickName() != null) {
            sql = sql + " user_nick_name = '" + skrUser.getUserNickName() + "' , ";
        }
        if (skrUser.getUserPassword() != null) {
            sql = sql + " user_password = '" + skrUser.getUserPassword() + "' , ";
        }
        if (skrUser.getUserAddress() != null) {
            sql = sql + " user_address = '" + skrUser.getUserAddress() + "' , ";
        }
        if (skrUser.getUserGender() == 1 || skrUser.getUserGender() == 0) {
            sql = sql + " user_gender = '" + skrUser.getUserGender() + "' , ";
        }
        if (skrUser.getUserCard() != null) {
            sql = sql + " user_card = '" + skrUser.getUserCard() + "' , ";
        }
        if (skrUser.getUserPhone() != null) {
            sql = sql + " user_phone = '" + skrUser.getUserPhone() + "' , ";
        }

        if (sql.endsWith("SET")){
            return 0;
        }

        //截取SQl语句多余后缀","并拼接WHERE条件
        if (sql.endsWith(", ")){
            sql = sql.substring(0,sql.length() - 2) + " WHERE user_id = '" + skrUser.getUserId() + "'";
        }
        return jdbcTemplate.update(sql);
    }

    @Override
    public int deleteById(SkrUser skrUser) {
        //根据对象唯一ID删除
        if (skrUser.getUserId() == null){
            return 0;
        }
        return jdbcTemplate.update("DELETE from skr_user WHERE user_id=?",skrUser.getUserId());
    }

    @Override
    public int insert(SkrUser skrUser) {

        String sql = "INSERT INTO skr_user " +
                "(user_id, user_nick_name, user_password, user_address, user_real_name, user_gender, user_card, user_phone)" +
                " VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, skrUser.getUserId(), skrUser.getUserNickName(), skrUser.getUserPassword(),
                skrUser.getUserAddress(),skrUser.getUserRealName(),skrUser.getUserGender(),skrUser.getUserCard(),skrUser.getUserPhone());
    }

    @Override
    public int insertBySelective(SkrUser skrUser) {

        skrUser.setUserRealName(skrUser.getUserRealName() == null ? "" : skrUser.getUserRealName());
        skrUser.setUserNickName(skrUser.getUserNickName() == null ? "" : skrUser.getUserNickName());
        skrUser.setUserPassword(skrUser.getUserPassword() == null ? "" : skrUser.getUserPassword());
        skrUser.setUserNickName(skrUser.getUserNickName() == null ? "" : skrUser.getUserNickName());
        skrUser.setUserAddress(skrUser.getUserAddress() == null ? "" : skrUser.getUserAddress());
        skrUser.setUserCard(skrUser.getUserCard() == null ? "" : skrUser.getUserCard());
        skrUser.setUserGender(skrUser.getUserGender());
        skrUser.setUserId(skrUser.getUserId());

        String sql = "INSERT INTO skr_user " +
                "(user_id, user_nick_name, user_password, user_address, user_real_name, user_gender, user_card, user_phone)" +
                " VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql, skrUser.getUserId(), skrUser.getUserNickName(), skrUser.getUserPassword(),
                skrUser.getUserAddress(),skrUser.getUserRealName(),skrUser.getUserGender(),skrUser.getUserCard(),skrUser.getUserPhone());
    }
}
