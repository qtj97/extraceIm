package com.lw.extraceim.app;

/**
 * @Author : liwei
 * @Email : 1759840027@qq.com
 * @Description : 常量类，记录所需要的常量
 * @Date : 2019/4/11 10:40
 */
public class AppConstants {

    /*网络*/
    public static final String HOST_SERVER = "http://192.168.137.1:8080/TestCxfHibernate";
    public static final String MISC_SERVICE = HOST_SERVER + "/REST/Misc/";
    public static final String DOMAIN_SERVICE = HOST_SERVER + "/REST/Domain/";
    /*请求方式*/
//    public static final String GET = "get";
//    public static final String GET_FORM = "get_form";
//    public static final String POST_JSON = "post_json";
//    public static final String POST = "post";
//    public static final String POST_FILE = "post_file";
//    public static final String POST_FORM = "post_form";



    //返回的response的Entity值的起始字符串
    public static final String DELETED_ENTITY_HEAD= "D_";
    public static final String SAVE_ENTITY_HEAD = "R_";
    //部分response的Entity值
    public static final String ADD_ES_HEAD = "id";

    public static final String DELETED = "Deleted";



}
