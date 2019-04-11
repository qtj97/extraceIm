package com.lw.extraceim.ui.activity.base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.lw.extraceim.app.ExtraceApplication;
import com.lw.extraceim.net.IDataAdapter;
import com.lw.extraceim.ui.activity.LoginActivity;

/**
 * @Author : liwei
 * @Email : 1759840027@qq.com
 * @Description : 自定义的Activity类
 * @Date : 2019/4/11 10:58
 */
public abstract class BaseActivity extends AppCompatActivity {

    private long exitTime = 0; //两次点击返回键的间隔时间
    protected ExtraceApplication application; // 全局application
    public boolean isLoginOrRegist = false; //判断是否登录或者注册界面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (ExtraceApplication) getApplication();
        application.addActivity(this);
        checkLogin(); //检查用户是否登录
        initView();//初始化界面组件
        initData();//初始化数据
        initEvent();//初始化当前界面的事件
        refreshUI();//刷新界面
    }

    /**
     * 初始化界面
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 刷新界面
     */
    public abstract void refreshUI();

    /**
     * 初始化时间
     */
    public abstract void initEvent();

    /**
     * 检查用户是否登录 如果未登录则跳转到登录界面
     * 登录和注册界面不用检查
     */
    public void checkLogin(){
        if(application.getUserInfo() == null && !isLoginOrRegist){
            Toast.makeText(this,"你还未登录！",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void finish() {
        super.finish();
        application.removeActivity(this);
    }

    /**'
     * 退出按钮退出app，并finish所有activity
     */
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            application.exitApp(); //退出app
            System.exit(0);
        }
    }

}
