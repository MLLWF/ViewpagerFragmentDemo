package com.example.a20161005.viewpagerfragmentdemo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.widget.TextView;

import com.example.a20161005.viewpagerfragmentdemo.lazyloadfragment.LazyFragment1;
import com.example.a20161005.viewpagerfragmentdemo.lazyloadfragment.LazyFragment2;
import com.example.a20161005.viewpagerfragmentdemo.lazyloadfragment.LazyFragment3;

/**
 * Created by ML on 2017/3/15.
 */

public class ViewPagerFragmentActivity extends BaseViewPagerFragmentActivity {

    private Fragment mFragmentOne;
    private Fragment mFragmentTwo;
    private Fragment mFragmentThree;

    private LazyFragment1 mLazyFragment1;
    private LazyFragment2 mLazyFragment2;
    private LazyFragment3 mLazyFragment3;

    private TextView mTextViewOne;
    private TextView mTextViewTwo;
    private TextView mTextViewThree;

    @Override
    public void initFragmentList() {
//        mFragmentOne = new FragmentOne();
        //        mFragmentTwo = new FragmentTwo();
        //        mFragmentThree = new FragmentThree();

        mLazyFragment1 = new LazyFragment1();
        mLazyFragment2 = new LazyFragment2();
        mLazyFragment3 = new LazyFragment3();

        mFragmentList.add(mLazyFragment1);
        mFragmentList.add(mLazyFragment2);
        mFragmentList.add(mLazyFragment3);
    }

    @Override
    public void initTabTitleOrCustormTabItemViewList() {
        //        mTitleList.add("商品");
        //        mTitleList.add("详情");
        //        mTitleList.add("评论");
        mTextViewOne = new TextView(this);
        mTextViewThree = new TextView(this);
        mTextViewTwo = new TextView(this);
        mCustomTabItemViewList.add(mTextViewOne);
        mCustomTabItemViewList.add(mTextViewTwo);
        mCustomTabItemViewList.add(mTextViewThree);
    }

    @Override
    public void initTabIconList() {

    }

    @Override
    public void initTabLayoutStyleList() {
        mTabLayout.getTabAt(1).select();
    }

    @Override
    public void initCustormTabItemView() {
        mTextViewOne.setText("商品");
        mTextViewTwo.setText("详情");
        mTextViewThree.setText("评论");
        mTextViewOne.setTextSize(15);
        mTextViewTwo.setTextSize(15);
        mTextViewThree.setTextSize(15);
        mTextViewOne.setGravity(Gravity.CENTER);
        mTextViewTwo.setGravity(Gravity.CENTER);
        mTextViewThree.setGravity(Gravity.CENTER);

    }

    @Override
    public void configSelectedCustormTabItemViewStyle(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                mTextViewOne.setTextSize(18);
                mTextViewOne.setTextColor(Color.RED);
                break;
            case 1:
                mTextViewTwo.setTextSize(18);
                mTextViewTwo.setTextColor(Color.RED);
                break;
            case 2:
                mTextViewThree.setTextSize(18);
                mTextViewThree.setTextColor(Color.RED);
                break;
            default:
                break;
        }

    }

    @Override
    public void configNoSelectedCustormTabItemViewStyle(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                mTextViewOne.setTextSize(15);
                mTextViewOne.setTextColor(Color.BLACK);
                break;
            case 1:
                mTextViewTwo.setTextSize(15);
                mTextViewTwo.setTextColor(Color.BLACK);
                break;
            case 2:
                mTextViewThree.setTextSize(15);
                mTextViewThree.setTextColor(Color.BLACK);
                break;
            default:
                break;
        }
    }
}
