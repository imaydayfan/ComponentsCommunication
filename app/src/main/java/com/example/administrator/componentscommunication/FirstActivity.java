package com.example.administrator.componentscommunication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        putFragment1();
    }

    public void communication(){
        //首先创造一个Bundle对象
        Bundle bundle = new Bundle();
        bundle.putString("data_string","数据");
        bundle.putInt("data_int",10);
        bundle.putChar("data_char",'a');

        //然后创建一个Intent对象
        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //点击按钮事件
    public void SecondActivity(View v){
        communication();
    }

    public void sbt(View v){
        Intent intent=new Intent(FirstActivity.this,ServiceBindActivity.class);
        startActivity(intent);
    }

    public void putFragment1(){
        Fragment1 fragment1=new Fragment1();
        Bundle bundle=new Bundle();
        bundle.putString("data","数据传递成功");
        fragment1.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment1);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //做想要做的数据操作和通信，如给其他Fragment发送数据
    }


    }
