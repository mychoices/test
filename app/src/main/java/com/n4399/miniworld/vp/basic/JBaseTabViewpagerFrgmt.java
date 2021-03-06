package com.n4399.miniworld.vp.basic;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.blueprint.adapter.frgmt.BaseFrgmtFractory;
import com.blueprint.adapter.frgmt.TabAdapter;
import com.blueprint.basic.JBasePresenter;
import com.blueprint.helper.UIhelper;
import com.n4399.miniworld.R;

import april.yun.JPagerSlidingTabStrip;
import april.yun.other.JTabStyleDelegate;
import butterknife.BindView;
import butterknife.ButterKnife;
import jonas.jlayout.MultiStateLayout;

import static com.blueprint.LibApp.findColor;

/**
 * @author 江祖赟.
 * @date 2017/6/7
 * @des [具体内容由viewpager的fragment展示 此fragment只做容器装tabstrip + viewpager]
 */
public abstract class JBaseTabViewpagerFrgmt extends JBaseTitleFrgmt {


    @BindView(R.id.jbase_tab_strip) public JPagerSlidingTabStrip mSecTabStrip;
    @BindView(R.id.jbase_viewpager) public ViewPager mSecViewpager;


    @Override
    protected void onCreateContent(LayoutInflater inflater, RelativeLayout fmContent){
        View rootView = inflater.inflate(R.layout.basic_tab_vp_layout, fmContent);
        ButterKnife.bind(this, rootView);
        initTabStrip();
        setupAdapter();
    }

    private void setupAdapter(){
        // http://blog.csdn.net/a1274624994/article/details/53575976
        //getFragmentManager()有问题 浪费好多时间：getChildFragmentManager  T_T
        mSecViewpager.setAdapter(new TabAdapter(getChildFragmentManager(), setTabTitles(), setFrgmtProvider()));
        //        mBaseViewpager.setAdapter(new TabAdapter(getFragmentManager(), setTabTitles(), setFrgmtProvider()));
        mSecViewpager.setOffscreenPageLimit(setTabTitles().length);
        //不需要加载数据 直接显示内容
        mMultiStateLayout.showStateLayout(MultiStateLayout.LayoutState.STATE_EXCEPT);
        if(mSecViewpager.getAdapter() instanceof TabAdapter) {
            //在onsizechange之后设置导致indicator不显示
            mSecTabStrip.bindViewPager(mSecViewpager);
        }else {
            mSecTabStrip.setVisibility(View.GONE);
        }
    }

    private void initTabStrip(){
        //        //        2，拿TabStyleDelegate
        //        JTabStyleDelegate tabStyleDelegate = mSecTabStrip.getTabStyleDelegate();
        //        //        3, 用TabStyleDelegate设置属性
        //        tabStyleDelegate.setShouldExpand(false)
        //                //也可以直接传字符串的颜色，第一个颜色表示checked状态的颜色第二个表示normal状态
        //                .setTextColor(findColor(R.color.colorPrimary), findColor(R.color.gray999))
        //                .setTabTextSize(findDimens(R.dimen.tab_top_textsize)).setTabPadding(findDimens(R.dimen.tab_pading))
        //                .setDividerPadding(0)//tab之间分割线 的上下pading
        //                .setTabPadding(0).setUnderlineHeight(0)//底部横线的高度
        //                .setIndicatorHeight(findDimens(R.dimen.tab_indicator_height))
        //                .setUnderlineHeight(findDimens(R.dimen.tab_underline_height))
        //                .setUnderlineColor(Color.parseColor("#e6e6e6")).setIndicatorColor(findColor(R.color.colorPrimary));
        reConfigTabStrip(UIhelper.initTabStrip(mSecTabStrip.getTabStyleDelegate()));
    }

    protected void reConfigTabStrip(JTabStyleDelegate tabStyleDelegate){

    }

    protected abstract BaseFrgmtFractory setFrgmtProvider();

    protected abstract String[] setTabTitles();

    @Override
    protected JBasePresenter initPresenter(){
        return null;
    }
}
