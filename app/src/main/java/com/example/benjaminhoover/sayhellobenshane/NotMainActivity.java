package com.example.benjaminhoover.sayhellobenshane;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NotMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_main);
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        TextView textTwo = (TextView) findViewById(R.id.momsSp);
        textTwo.setText(text);
        int[] colors = intent.getIntArrayExtra("colors");
        RelativeLayout bgt = (RelativeLayout) findViewById(R.id.bgt);
        bgt.setBackgroundColor(Color.argb(255, colors[0], colors[1], colors[2]));
        float textSize = intent.getFloatExtra("textSize", 30);
        textTwo.setTextSize(textSize);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_not_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
