package com.example.ldh.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tview1, tview2, tview3, tview4, tview5, tview6;
    EditText editText1, editText2, editText3;
    LinearLayout ll1, ll2, ll3, ll4;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton rb1, rb2;
    ImageView iView;
    String menu1, menu2, menu3;
    double total;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        tview1 = (TextView)findViewById(R.id.textView1);
        tview2 = (TextView)findViewById(R.id.textView2);
        tview3 = (TextView)findViewById(R.id.textView3);
        tview4 = (TextView)findViewById(R.id.textView4);
        tview5 = (TextView)findViewById(R.id.textView5);
        tview6 = (TextView)findViewById(R.id.textView6);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        ll1 = (LinearLayout)findViewById(R.id.LL1);
        ll2 = (LinearLayout)findViewById(R.id.LL2);
        ll3 = (LinearLayout)findViewById(R.id.LL3);
        ll4 = (LinearLayout)findViewById(R.id.LL4);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        radioGroup = (RadioGroup)findViewById(R.id.rg);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        iView = (ImageView)findViewById(R.id.imageView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu1 = editText1.getText().toString();
                menu2 = editText2.getText().toString();
                menu3 = editText3.getText().toString();
                count = Integer.parseInt(menu1) + Integer.parseInt(menu2) + Integer.parseInt(menu3);
                total = Integer.parseInt(menu1)*16000 + Integer.parseInt(menu2)*11000 + Integer.parseInt(menu3)*4000;
                if(checkBox.isChecked()==true){
                    total = total * 0.93;
                    total = total - total%10;
                    total =(int) total;
                }
                tview4.setText("주문 개수 : "+count);
                tview5.setText("주문 금액 : "+total);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getId()==R.id.rg){
                    switch (checkedId){
                    case R.id.radioButton1 :
                        iView.setImageResource(R.drawable.pikeul);
                        iView.setVisibility(View.VISIBLE);
                        tview6.setText("피클을 선택하셨습니다.");
                        break;
                    case  R.id.radioButton2 :
                            iView.setImageResource(R.drawable.gallig);
                        iView.setVisibility(View.VISIBLE);
                        tview6.setText("소스를 선택하셨습니다.");
                    }
                }
            }
        });

    }
}

