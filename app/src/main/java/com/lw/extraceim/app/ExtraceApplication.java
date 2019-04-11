package com.lw.extraceim.app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.lw.extraceim.model.UserInfo;

import java.util.LinkedList;
import java.util.List;


public class ExtraceApplication  extends Application {
    private static final String TAG = "ExtraceApplication";
    private static final String PREFS_NAME = "ExTrace.cfg";//app配置文件
    private List<Activity> activityList; //存放正在运行的activity
    private UserInfo userInfo; //当前登录的用户信息
    private ExtraceCfg extraceCfg; //app的配置类


    @Override
    public void onCreate() {
        super.onCreate();
        activityList = new LinkedList<>();

    }

    public void onTerminate() {
        super.onTerminate();

        //save data of the map
    }


    public ExtraceCfg getExtraceCfg() {
        return extraceCfg;
    }

    public void saveExtraceCfg(){

    }
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * 添加Activity
     * @param activity
     */
    public void addActivity(Activity activity){
        if(!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    /**
     * 移出activity
     * @param activity
     */
    public void removeActivity(Activity activity){
        if(activityList.contains(activity)){
            activityList.remove(activity);
        }
    }

    /**
     * 退出app，并销毁所有Activity
     */
    public void exitApp(){
        Log.d(TAG, "容器中的Activity列表如下：");
        for(Activity activity : activityList){
            Log.d(TAG, activity.getLocalClassName());
        }
        Log.d(TAG, "逐步退出容器内所有Activity");
        for(Activity activity : activityList){
            activity.finish();
        }
    }
}
