package com.study.yang.fiveandsixstyleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by zouqianyu on 2017/9/3.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

    private final Context context;
    private OnRvClickListener listener;

    public RvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.rv_list_layout, null);
        return new RvViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
//            RvViewHolder viewHolder = (RvViewHolder) holder;
//            viewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {
        public RvViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Toast.makeText(context, "点击了" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void setOnRvClickListener(OnRvClickListener listener) {
        this.listener = listener;
    }

    public interface OnRvClickListener {
        void click(int position);
    }

}
