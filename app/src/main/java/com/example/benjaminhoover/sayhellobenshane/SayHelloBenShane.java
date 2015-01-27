package com.example.benjaminhoover.sayhellobenshane;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SayHelloBenShane extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello_ben_shane);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_say_hello_ben_shane, menu);
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

    public void onButtonPush (View view) {
        TextView text = (TextView) findViewById(R.id.editText);
        String name = text.getText().toString();
        name = "Hello " + name;
        Intent intent = new Intent(this, NotMainActivity.class);
        intent.putExtra("text", name);
        startActivity(intent);
        RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
        bg.setBackgroundColor(Color.argb(255, 123, 222, 111));
    }
}
