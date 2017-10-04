package com.study.yang.fiveandsixstyleapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardListFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView mRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(layout);
        mRv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        RvAdaper adapter = new RvAdaper(getActivity());


        mRv.setAdapter(adapter);
    }

    public class RvAdaper extends RecyclerView.Adapter<RvAdaper.RvViewHolder> {

        private final Context context;

        public RvAdaper(Context context) {
            this.context = context;
        }

        @Override
        public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.rv_list_layout, parent, false);
            return new RvViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(RvViewHolder holder, int position) {
            holder.tvTitle.setText("新特性" + position);
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class RvViewHolder extends RecyclerView.ViewHolder {

            public TextView tvTitle;

            public RvViewHolder(View itemView) {
                super(itemView);
                initView(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        Toast.makeText(context, "点击了" + position, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Style6DetailActivity.class);
                        startActivity(intent);
                    }
                });
            }

            private void initView(View view) {
                tvTitle = (TextView) view.findViewById(R.id.tv_title);
            }

        }


    }
}
