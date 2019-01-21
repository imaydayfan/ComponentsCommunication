package com.example.administrator.componentscommunication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public int data=0;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new Binder();
    }

    public class Binder extends android.os.Binder{
        public void sendData(int data){
            MyService.this.data=data;
            Log.e("dataValue",String.valueOf(MyService.this.data));
        }
    }
}
