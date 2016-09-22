package org.iii.tw.mycamertest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("brad",""+resultCode);
        if(resultCode == RESULT_OK){
            afterTakePic1(data);
        }else if(requestCode == RESULT_CANCELED){

        }
    }

    private void afterTakePic1(Intent data){
        Bitmap bmp = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(bmp);
    }

    public void test1(View v){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it,1);
    }
    public void test2(View v){

    }
}
