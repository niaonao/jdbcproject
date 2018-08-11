package pers.niaonao.jdbcproject.entity;

import java.io.Serializable;

/**
 * @Author: niaonao
 * @Date: Created in 16:36 2018/7/29
 * @Desprition: 请求参数封装类
 */
public class RequestEntity implements Serializable {
    private static final long serialVersionUID = 3401781428101852075L;

    /**
     * 请求响应数据
     */
    private String treasureData;

    public String getTreasureData() {
        return treasureData;
    }

    public void setTreasureData(String treasureData) {
        this.treasureData = treasureData;
    }

}
