package com.example.a20161005.viewpagerfragmentdemo.lazyloadfragment;

import android.util.Log;

import com.example.a20161005.viewpagerfragmentdemo.R;

/**
 * Created by ML on 2017/4/11.
 */

public class LazyFragment1 extends LazyLoadFragment {

    @Override
    protected void lazyLoad() {
        String message = "Fragment1" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_one;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }
}
