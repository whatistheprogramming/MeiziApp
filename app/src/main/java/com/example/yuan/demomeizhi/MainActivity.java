package com.example.yuan.demomeizhi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.yuan.demomeizhi.adapter.MyAdapter;
import com.example.yuan.demomeizhi.bean.DataBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Toolbar toolbar;
    private RefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    private MyAdapter madapter;


    private List<DataBean> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();
        
        getData();
        setAdapter();


    }

    private void setAdapter()
    {
        madapter = new MyAdapter(dataList);
        //StaggeredGridLayoutManager实现两列的瀑布流效果
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(madapter);

//        madapter.notifyDataSetChanged();
    }

    private void initView()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        refreshLayout = (RefreshLayout) findViewById(R.id.refresh_Layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //设置Toolbar
        setSupportActionBar(toolbar);


        //设置下拉刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        //设置上拉加载更多
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });







    }

    public void getData()
    {
        dataList = new ArrayList<>();
        for (int i = 0; i < 500; i++)
        {
            DataBean data = new DataBean();
            data.setStr("条目" + i);
            dataList.add(data);
        }

    }
}
