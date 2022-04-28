package tw.com.app.ooxx_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Load extends AppCompatActivity {
    private int timeOut = 2000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定APP視窗的大小
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_load);
        //設定延時處理
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //轉跳頁面
                startActivity(new Intent(Load.this,MainActivity.class));
                finish();//銷毀頁面
            }
        },timeOut);
    }
}