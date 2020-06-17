package com.example.user.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ImageView imageView;
    TextView textView;
    ListView listView;
    String str[]={"Your Protectors","Send SMS to get Location","Track Me"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView)this.findViewById(R.id.imageView2);
        textView=(TextView)this.findViewById(R.id.textView2);
        listView=(ListView)this.findViewById(R.id.lv);
        String  tv=this.getIntent().getExtras().getString("path");
        textView.setText(tv);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.textview,R.id.textView3,str);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position+1)
        {
            case 1: {
                Intent intent = new Intent(this, Main3Activity.class);
                this.startActivity(intent);
            }
            }

        }

    }

