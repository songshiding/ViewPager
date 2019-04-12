package com.example.administrator.viewpager;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<View>viewList;
   // private List<String> titlelist;
    private String[] titlelist;
    private PagerTabStrip tabStrip;
    private int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        tabStrip=(PagerTabStrip)findViewById(R.id.pagertabstrip);
        viewList=new ArrayList<>();
        titlelist=new String[6];
        titlelist[1]="中国";
        titlelist[2]="美国";
        titlelist[3]="加拿大";
        titlelist[4]="非洲";


        View view0=View.inflate(this,R.layout.item,null);
        viewList.add(view0);

        View view1=View.inflate(this,R.layout.item,null);
        ((ImageView)view1.findViewById(R.id.item_image)).setImageResource(R.drawable.ic_launcher_background);
        viewList.add(view1);
        View view2=View.inflate(this,R.layout.item,null);
        viewList.add(view2);
        View view3=View.inflate(this,R.layout.item,null);
        viewList.add(view3);
        View view4=View.inflate(this,R.layout.item,null);
        viewList.add(view4);

        View view5=View.inflate(this,R.layout.item,null);
        ((ImageView)view5.findViewById(R.id.item_image)).setImageResource(R.drawable.ic_launcher_background);
        viewList.add(view5);


//        titlelist.add("美国");
//        titlelist.add("中国");
//        titlelist.add("加拿大");
//        titlelist.add("非洲");


        //修改tabStrip 样式
        tabStrip.setBackgroundColor(Color.BLUE);
        tabStrip.setTextColor(Color.BLACK);
        tabStrip.setTabIndicatorColor(Color.RED);

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(viewList,titlelist);

        viewPager.setAdapter(myPagerAdapter);
        viewPager.setCurrentItem(5000);
        viewPager.setOffscreenPageLimit(6);
        //给viewpager设置监听器onpagerchangelistener
        viewPager.addOnPageChangeListener(this);




    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
//        if (i==5){
//            p=i=1;
//        }else if (i==0){
//            p=i=4;
//        }else {
//            p=i;
//        }
//        Toast.makeText(this,"当前选着的是"+(i+1),Toast.LENGTH_SHORT).show();
    }

    //当前被选择的卡页
    @Override
    public void onPageSelected(int i) {
        if (i==5){
            p=i=1;
        }else if (i==0){
            p=i=4;
        }else {
            p=i;
        }
        Toast.makeText(this,"当前选着的是"+(i+1),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int i) {
//        switch (state) {
//            case ViewPager.SCROLL_STATE_IDLE:// 空闲状态，没有任何滚动正在进行（表明完成滚动）
//                if (isAutoLoop) {
//                    if ( == 0) {
//                        setCurrentItem(pagerAdapter.getRealPageEndPos(), false);
//                    } else if (getCurrentItem() == pagerAdapter.getCount() - 1) {
//                        setCurrentItem(pagerAdapter.getRealPageStartPos(), false);
//                    }
//                }
//                break;
//            case ViewPager.SCROLL_STATE_DRAGGING:// 正在拖动page状态
//                break;
//            case ViewPager.SCROLL_STATE_SETTLING:// 手指已离开屏幕，自动完成剩余的动画效果
//                break;




       if (ViewPager.SCROLL_STATE_IDLE==i)
        {
            viewPager.setCurrentItem(p);
        }

    }
}
