package com.aaron.testhelloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.app.HelloWorldManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TestHelloWorld";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hidlTest(View view){
        try {
            HelloWorldManager hwm = (HelloWorldManager)this.getSystemService("hello");
            if(hwm == null) {
                Log.e(TAG, "hello world manager is null....");
                return;
            }
            Log.i(TAG, "start to test hello world service");

            hwm.printHello();

            Log.i(TAG, "finish test hello world service");
        }catch(Exception e) {
            Log.e(TAG, "invoke hello world service method failed" + e.getMessage());
            e.printStackTrace();
        }
    }
}