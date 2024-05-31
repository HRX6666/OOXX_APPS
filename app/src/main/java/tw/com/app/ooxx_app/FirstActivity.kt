package tw.com.app.ooxx_app;

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class FirstActivity :AppCompatActivity() {
    private val timeOut = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //設定APP視窗的大小
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_first)
        //設定延時處理
        Handler().postDelayed({
            //轉跳頁面
            startActivity(Intent(this@FirstActivity, GameActivity::class.java))
            finish() //銷毀頁面
        }, timeOut.toLong())
    }
}