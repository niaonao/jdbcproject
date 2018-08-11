package pers.niaonao.jdbcproject.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: niaonao
 * @Date: Created in 15:21 2018/7/29
 * @Desprition: 实体类ID 生成工具类
 */
public class GenerateIdUtil {

    /** 默认用户分表位 */
    private static final String DEFAULT_USER_PARTITION  = "1";

    /** 默认替代位 */
    private static final String DEFAULT_REPLACE = "0";

    /** 默认横线 */
    private static final String DEFAULT_LINE = "-";

    /**
     * 生成 id 方法
     * 一般项目会有多个实体类(数据表)
     * 此处生成id 添加四位标记码可以区分不同的数据表，且能够降低出现重复的id
     * @param tableBizCode 数据表标记码
     * @return
     */
    public static String generateId(String tableBizCode){
        //获取当前日期字符串
        String dateString = getPartition(new Date());
        //获取随机生成十四位数字
        String ranString = String.valueOf(new Random().nextLong()).substring(0,6);
        //如果当前随机数第一位是-,则用0代替
        if (ranString.contains(DEFAULT_LINE)){
            ranString = ranString.replace(DEFAULT_LINE,DEFAULT_REPLACE);
        }
        //iD规则:当前日期字符串 +       1 +         数据表标记码 + 6位随机数字符串
        return dateString + DEFAULT_USER_PARTITION + tableBizCode + ranString;
    }

    /**
     * 日期转换
     * @param date   当前时间
     * @return       日期字符串
     */
    public static String getPartition(Date date) {
        //前8位yyyyMMdd格式
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    public static void main(String args[]){
        //生成数据格式：2018072910221899540
        System.out.println(generateId("0221"));
    }
}
