package com.oklib.demo.permission;

import android.Manifest;
import android.widget.Toast;

import com.oklib.demo.R;
import com.oklib.demo.base.BaseAppActivity;
import com.oklib.util.permission.PermissionFail;
import com.oklib.util.permission.PermissionGen;
import com.oklib.util.permission.PermissionSuccess;

/**
 * 时间：2017/8/2
 * 作者：黄伟才
 * 简书：http://www.jianshu.com/p/87e7392a16ff
 * github：https://github.com/huangweicai/oklib
 * 描述：6.0动态权限统一封装框架使用演示
 */

public class PermissionActivity extends BaseAppActivity {
    @Override
    protected int initLayoutId() {
        return R.layout.activity_permission;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initNet() {
        //具体参考：http://www.jianshu.com/p/7236bb0d91ea
        PermissionGen.with(PermissionActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_CONTACTS
                )
                .request();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void openCamera() {
        //请求码100，请求成功
        Toast.makeText(context, "权限请求成功", Toast.LENGTH_LONG).show();
    }

    @PermissionFail(requestCode = 100)
    public void failOpenCamera(boolean isCompletelyFail) {
        //请求码100，请求失败
        Toast.makeText(context, "权限请求失败", Toast.LENGTH_LONG).show();
    }
}