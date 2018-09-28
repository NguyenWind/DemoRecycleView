package com.example.hoanhintern.demorecycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class DataApdater extends RecyclerView.Adapter<DataApdater.DataViewHolder> {
    private List<Data> data;
    private Context context;
    OnClickItemListener onClickItemListener;

    public DataApdater(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        switch (viewType) {
            case 1:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
                break;
            case 2:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_2, parent, false);
                break;
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
                break;

        }




        return new DataViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position).isMale()) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        final Data dt = data.get(position);

        String name = dt.getName();
        int age = dt.getAge();
        String phone = dt.getPhoneNumber();


        holder.txName.setText(name);
        holder.txAge.setText(age + "");
        holder.txPhone.setText(phone);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItemListener.OnClick(dt);
            }
        });


    }



    @Override
    public int getItemCount() {


        return data.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView txName;
        private TextView txAge;
        private TextView txPhone;
        private RelativeLayout relativeLayout;

        public DataViewHolder(View itemView) {
            super(itemView);
            txName = (TextView) itemView.findViewById(R.id.txName);
            txAge = (TextView) itemView.findViewById(R.id.txAge);
            txPhone = (TextView) itemView.findViewById(R.id.txPhone);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.item);
        }
    }
}
