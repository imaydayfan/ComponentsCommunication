package com.example.administrator.componentscommunication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceBindActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt0,bt1;

    private Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_bind);

        intent = new Intent(this, MyService.class);

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt0:

                //开启服务并且传递数据
                intent.putExtra("data_stirng","string数据");
                startActivity(intent);

                break;

            case R.id.bt1:

                //结束服务
                stopService(intent);

                break;

        }

    }
}
