package org.iii.tw.mycamertest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private File sdroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        sdroot = Environment.getExternalStorageDirectory();
    }

    public void test1(View v){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri outputFile = Uri.fromFile(new File(sdroot,"brad.jpg"));
        it.putExtra(MediaStore.EXTRA_OUTPUT, outputFile);

        startActivityForResult(it,1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("brad",""+resultCode);
        if(resultCode == RESULT_OK){
//            afterTakePic1(data);
            afterTakePic2(data);
        }else if(requestCode == RESULT_CANCELED){

        }
    }

    private void afterTakePic1(Intent data){
        Bitmap bmp = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(bmp);
    }

    private void afterTakePic2(Intent data){
        Bitmap bmp = BitmapFactory.decodeFile(sdroot.getAbsolutePath() + "/brad.jpg");
        img.setImageBitmap(bmp);
    }

    public void test2(View v){

    }
}
