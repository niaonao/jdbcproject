package pers.niaonao.jdbcproject.entity;

/**
 * @Author: niaonao
 * @Date: Created in 16:24 2018/7/29
 * @Desprition: 用户实体类
 */
public class SkrUser {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户注册昵称
     */
    private String userNickName;
    /**
     * 用户真实名称
     */
    private String userRealName;
    /**
     * 用户手机号码
     */
    private String userPhone;
    /**
     * 用户登录密码
     */
    private String userPassword;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户身份证号
     */
    private String userCard;
    /**
     * 用户性别
     * 0/1 - 男/女
     */
    private int userGender = -1;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserNickName() { return userNickName; }

    public void setUserNickName(String userNickName) { this.userNickName = userNickName; }

    public String getUserRealName() { return userRealName; }

    public void setUserRealName(String userRealName) { this.userRealName = userRealName; }

    public String getUserPhone() { return userPhone; }

    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public String getUserCard() { return userCard; }

    public void setUserCard(String userCard) { this.userCard = userCard; }

    public int getUserGender() { return userGender; }

    public void setUserGender(int userGender) { this.userGender = userGender; }
}
