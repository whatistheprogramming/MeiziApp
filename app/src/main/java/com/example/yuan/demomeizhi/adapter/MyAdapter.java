package com.example.yuan.demomeizhi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuan.demomeizhi.R;
import com.example.yuan.demomeizhi.bean.DataBean;

import java.util.List;

/**
 * Created by yuan on 2017/12/8.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<DataBean> dataBeanList;

    public MyAdapter(List<DataBean> dataBeanList)
    {
        this.dataBeanList = dataBeanList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position)
    {
        holder.textView.setText(dataBeanList.get(position).getStr());

    }

    @Override
    public int getItemCount()
    {
        return dataBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
