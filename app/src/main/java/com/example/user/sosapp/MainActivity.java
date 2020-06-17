package com.example.user.sosapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText t1,t2,t3,t4;
    ImageView imageView;
    Uri path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)this.findViewById(R.id.button);
        t1=(EditText)this.findViewById(R.id.editText);
        t2=(EditText)this.findViewById(R.id.editText2);
        t3=(EditText)this.findViewById(R.id.editText);
        t4=(EditText)this.findViewById(R.id.editText4);
        imageView=(ImageView)this.findViewById(R.id.imageView);
        b1.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1) {
            String name = t1.getText().toString();
            String phno = t2.getText().toString();
            String bloodgp = t3.getText().toString();
            String location = t4.getText().toString();
            if (name.equals("") || phno.equals("") || bloodgp.equals("") || location.equals("")) {
                Toast.makeText(this, "Enter All Fields..", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("name", name);
                intent.putExtra("phno", phno);
                intent.putExtra("location", location);
                this.startActivity(intent);
                Toast.makeText(this, "Information Successfully Stored..", Toast.LENGTH_SHORT).show();
            }
        }
        if (v==imageView){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File f = setImageName();
            path = Uri.fromFile(f);
           intent.putExtra(MediaStore.EXTRA_OUTPUT, path);
            startActivityForResult(intent, 123);

        }
    }
    public File setImageName() {
        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "MY_PICS");
        if (!f.exists())
            f.mkdir();
        String time = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.getDefault()).format(new Date());
        File file2 = new File(f.getPath() + "/IMG" + time + "JPG");
        return file2;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Bitmap bmp=(Bitmap)MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());

            // Bitmap bmp=MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
            imageView.setImageBitmap(bmp);

            //bmp=imageView.getDrawingCache();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
