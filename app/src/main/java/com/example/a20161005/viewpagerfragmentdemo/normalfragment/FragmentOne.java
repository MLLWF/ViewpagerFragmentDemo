package com.example.a20161005.viewpagerfragmentdemo.normalfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20161005.viewpagerfragmentdemo.R;
import com.example.xutil.LogUtil.L;

/**
 * Created by ML on 2017/3/15.
 */

public class FragmentOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        L.e("onCreateView>>>>>>>One");
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        L.e("onResume>>>>>>>One");
    }

    @Override
    public void onPause() {
        super.onPause();
        L.e("onPause>>>>>>>One");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.e("onDestroy>>>>>>>One");
    }
}
