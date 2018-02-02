package com.example.ben.drawanote;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class DrawingActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button mSaveButton, mPenButton, mEraserButton,
            mLoadButton;
    private DrawingView mDrawingView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        initializeUI();
        setListeners();
    }

    private void setListeners() {
        mSaveButton.setOnClickListener(this);
        mPenButton.setOnClickListener(this);
        mEraserButton.setOnClickListener(this);

    }

    private void initializeUI() {
        mDrawingView = (DrawingView) findViewById(R.id.scratch_pad);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mPenButton = (Button) findViewById(R.id.pen_button);
        mEraserButton = (Button) findViewById(R.id.eraser_button);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                mDrawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "image",
                        Bitmap.CompressFormat.PNG, 100);
                break;

            case R.id.pen_button:
                mDrawingView.initializePen();
                break;
            case R.id.eraser_button:
                mDrawingView.initializeEraser();
                break;

        }
    }



}
