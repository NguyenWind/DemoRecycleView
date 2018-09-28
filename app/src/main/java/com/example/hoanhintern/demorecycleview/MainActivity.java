package com.example.hoanhintern.demorecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerView recyclerView;
    EditText edt1,edt2,edt3;
    Button bt;
    OnClickItemListener onClickItemListener;
    DataApdater dataApdater;
    Data dataCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt= (Button)findViewById(R.id.bt);
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        edt3=(EditText)findViewById(R.id.edt3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });




        List<Data> data = new ArrayList<>();
        data.add(new Data("NGUYEN HIEU HOA", 23, "08078134906", true));
        data.add(new Data("NGUYEN HIEU HOA", 24, "08078134906", false));
        data.add(new Data("NGUYEN HIEU HOA", 25, "08078134906", true));
        data.add(new Data("NGUYEN HIEU HOA", 26, "08078134906", false));
        data.add(new Data("NGUYEN HIEU HOA", 27, "08078134906", true));
        data.add(new Data("NGUYEN HIEU HOA", 28, "08078134906", false));

        dataApdater = new DataApdater(data,MainActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_data);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),linearLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setHasFixedSize(true);
        onClickItemListener = new OnClickItemListener() {
            @Override
            public void OnClick(Data data) {
                edt1.setText(data.getName());
                edt2.setText(data.getAge()+"");
                edt3.setText(data.getPhoneNumber());
                dataCurrent = data;
            }
        };
        dataApdater.onClickItemListener = onClickItemListener;
        recyclerView.setAdapter(dataApdater);


    }

    public void update(){
        String name = edt1.getText().toString();
        String age = edt2.getText().toString();
        String phone = edt3.getText().toString();
        dataCurrent.setName(name);
        dataCurrent.setAge(Integer.parseInt(age));
        dataCurrent.setPhoneNumber(phone);
        dataApdater.notifyDataSetChanged();
    }
}