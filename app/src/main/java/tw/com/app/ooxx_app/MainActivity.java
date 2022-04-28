package tw.com.app.ooxx_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<Button>();
    private int OX_start=0;
    private int[] toio ={0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons.add(findViewById(R.id.button0));
        buttons.add(findViewById(R.id.button1));
        buttons.add(findViewById(R.id.button2));
        buttons.add(findViewById(R.id.button3));
        buttons.add(findViewById(R.id.button4));
        buttons.add(findViewById(R.id.button5));
        buttons.add(findViewById(R.id.button6));
        buttons.add(findViewById(R.id.button7));
        buttons.add(findViewById(R.id.button8));
        setButtons();
    }

    /*
    設定按鈕的觸發事件
     */
    public void setButtons() {
        int buttonNumber=0;
        for(Button button:buttons){
            int finalButtonNumber = buttonNumber;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    push(button, finalButtonNumber);
                }});
            buttonNumber++;
        }
    }


    /*
    設定按鈕觸事件的判斷
     */
    public void push(Button b,int i){
        String no = getString(R.string.no);
        if (b.getText().equals(no)){
            if (OX_start == 0){
                b.setText(R.string.o);
                toio[i]=1;
                OX_start=1;
                show();
            }else if(OX_start == 1){
                b.setText(R.string.x);
                toio[i]=4;
                OX_start=0;
                show();
            }
        }else {
            Toast.makeText(MainActivity.this,getText(R.string.repeat),Toast.LENGTH_SHORT).show();
        }
    }

    /*
    判斷是否獲勝
     */
    public void show(){
        if (
            toio[0]+toio[1]+toio[2] == 3 || toio[3]+toio[4]+toio[5] == 3 ||
            toio[6]+toio[7]+toio[8] == 3 || toio[0]+toio[3]+toio[6] == 3 ||
            toio[1]+toio[4]+toio[7] == 3 || toio[2]+toio[5]+toio[8] == 3 ||
            toio[0]+toio[4]+toio[8] == 3 || toio[2]+toio[4]+toio[6] == 3) {
            Toast.makeText(MainActivity.this,getText(R.string.O_win),Toast.LENGTH_LONG).show();
            reset();
        }else if(toio[0]+toio[1]+toio[2] == 12 || toio[3]+toio[4]+toio[5] == 12 ||
                toio[6]+toio[7]+toio[8] == 12 || toio[0]+toio[3]+toio[6] == 12 ||
                toio[1]+toio[4]+toio[7] == 12 || toio[2]+toio[5]+toio[8] == 12 ||
                toio[0]+toio[4]+toio[8] == 12 || toio[2]+toio[4]+toio[6] == 12 ){
            Toast.makeText(MainActivity.this,getText(R.string.X_win),Toast.LENGTH_LONG).show();
            reset();
        }
    }

    /*
    重新清理畫面
     */
    public void reset(){
        int i=0;
        for(Button b:buttons){
            b.setText(R.string.no);
            toio[i]=0;
            i++;
        }
        OX_start=0;
    }

    public void reset(View view){
        reset();
    }
}