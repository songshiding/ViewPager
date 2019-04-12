package com.example.administrator.viewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View>viewList;
    //private List<String>titlelist;
    private String[] titlelist;

    MyPagerAdapter(List<View> viewList,String[]titlelist){
        this.viewList=viewList;
        this.titlelist=titlelist;
    }

    //返回卡页的数量
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

//判断View是否来自于对象
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }


    //实例化一个页卡
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
//销毁一个卡页
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
       container.removeView(viewList.get(position));
    }

    //返回页卡标题信息，为能实现 在布局文件里一定要有pagertabstrip
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        //return super.getPageTitle(position);
//if (position==5)
//{
//    position=1;
//}else if (position==0){
//    position=4;
//}
//
//
//        return titlelist[position];
//    }
}
