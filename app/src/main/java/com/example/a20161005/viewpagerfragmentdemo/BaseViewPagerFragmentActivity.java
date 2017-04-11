package com.example.a20161005.viewpagerfragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.xutil.ConvertUtils;
import com.example.xutil.StrUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ML on 2017/3/15.
 */

public abstract class BaseViewPagerFragmentActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    protected TabLayout mTabLayout;
    private ViewPager mPager;
    private ViewPagerAdapter mAdapter;

    protected List<Fragment> mFragmentList = new ArrayList<>();
    protected List<String> mTitleList = new ArrayList<>();
    protected List<Integer> mIconList = new ArrayList<>();
    protected List<View> mCustomTabItemViewList = new ArrayList<>();
    protected int tabTextColor = Color.BLACK;
    protected int tabSelectedTextColor = Color.BLUE;
    protected int tabSelectedIndicatorColor = Color.BLUE;
    protected int tabSelectedIndicatorHeight = 2;
    protected int tabGravity;

    private List<TabLayout.Tab> mTabList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_viewpager_fragment_view);
        initFragmentList();
        initTabTitleOrCustormTabItemViewList();
        initTabIconList();
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        relationTabAndPager();
        initTabItem();
        initTabLayoutStyleList();
        initTabItemStyle();
    }

    private void relationTabAndPager() {
        ////TODO: 关联Tab和Pager
                mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mTabLayout.getTabAt(position).select();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        mPager.findViewWithTag(mTabLayout);
        mTabLayout.addOnTabSelectedListener(this);
    }

    private void initTabItemStyle() {
        //TODO: 配置TabItem的样式
        mTabLayout.setTabTextColors(tabTextColor, tabSelectedTextColor);
        mTabLayout.setSelectedTabIndicatorColor(tabSelectedIndicatorColor);
        mTabLayout.setSelectedTabIndicatorHeight(ConvertUtils.dip2px(this, tabSelectedIndicatorHeight));
        mTabLayout.setTabGravity(tabGravity);
        if (StrUtils.listNotNull(mTitleList) && mTitleList.size() > 4) {
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }

    private void initTabItem() {
        //TODO: 配置TabItem数据
        if (mCustomTabItemViewList.size() > 0) {
            getTabList(mCustomTabItemViewList.size());
            for (int i = 0; i < mCustomTabItemViewList.size(); i++) {
                mTabList.get(i).setCustomView(mCustomTabItemViewList.get(i));
            }
            initCustormTabItemView();
        } else {
            int count = mTitleList.size() > mIconList.size() ? mTitleList.size() : mIconList.size(); //取两个集合的最小值，防止数组越界
            if (count != 0) {
                getTabList(count);
                setTabText();
                setTabIcon();
            }
        }
        configTabItem();
    }

    private void configTabItem() {
        if (mTabList.size() > 0) {
            for (TabLayout.Tab tab : mTabList) {
                mTabLayout.addTab(tab);
            }
        }
    }

    private void setTabIcon() {
        if (StrUtils.listNotNull(mIconList)) {
            for (int i = 0; i < mIconList.size(); i++) {
                mTabList.get(i).setIcon(mIconList.get(i));
            }
        }
    }

    private void setTabText() {
        if (StrUtils.listNotNull(mTitleList)) {
            for (int i = 0; i < mTitleList.size(); i++) {
                mTabList.get(i).setText(mTitleList.get(i));
            }
        }
    }

    private void getTabList(int count) {
        for (int i = 0; i < count; i++) {
            mTabList.add(mTabLayout.newTab());
        }
    }


    private void initViewPager() {
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mPager.setAdapter(mAdapter);
    }

    // TODO: 初始化ragment集合
    public abstract void initFragmentList();

    // TODO: 初始化TabItem的标题或者自定义TabItem的布局，两者只能选其一，否则优先去自定义布局。
    public abstract void initTabTitleOrCustormTabItemViewList();

    // TODO: 初始化TabItem的图标
    public abstract void initTabIconList();

    // TODO: 配置TabLayout的样式
    public abstract void initTabLayoutStyleList();

    //TODO:  初始化自定义的TabItem布局
    public abstract void initCustormTabItemView();

    //TODO:  配置被选中自定义的TabItem布局的样式
    public abstract void configSelectedCustormTabItemViewStyle(TabLayout.Tab tab);

    //TODO:  配置没有被选中被选中自定义的TabItem布局的样式
    public abstract void configNoSelectedCustormTabItemViewStyle(TabLayout.Tab tab);

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //选中了tab的逻辑
        mPager.setCurrentItem(tab.getPosition());
        if (mCustomTabItemViewList.size() > 0) {
            configSelectedCustormTabItemViewStyle(tab);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        //未选中tab的逻辑
        if (mCustomTabItemViewList.size() > 0) {
            configNoSelectedCustormTabItemViewStyle(tab);
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        //再次选中tab的逻辑
    }
}
