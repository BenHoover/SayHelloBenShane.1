package com.example.benjaminhoover.sayhellobenshane;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class SayHelloBenShane extends Activity  {
    public int red;
    public int green;
    public int blue;

    public void setRed(int i){
        if( i <= 255 && i >= 0){
            red = i;
        }
    }
    public void setGreen(int i){
        if( i <= 255 && i >= 0){
            green = i;
        }
    }
    public void setBlue(int i){
        if( i <= 255 && i >= 0){
            blue = i;
        }
    }
    public int getRed(){
        return red;
    }
    public int getGreen(){
        return green;
    }
    public int getBlue(){
        return blue;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello_ben_shane);
        //Implement seekbar listeners
        SeekBar redSeek =(SeekBar) findViewById(R.id.rdSlider);
        SeekBar greenSeek =(SeekBar) findViewById(R.id.gnSlider);
        SeekBar blueSeek =(SeekBar) findViewById(R.id.blSlider);

        Button redButton = (Button) findViewById(R.id.redDisplay);
        Button greenButton = (Button) findViewById(R.id.greenDisplay);
        Button blueButton = (Button) findViewById(R.id.blueDisplay);

        redButton.setBackgroundColor(Color.argb(255, 255, 0, 0));
        greenButton.setBackgroundColor(Color.argb(255, 0, 255, 0));
        blueButton.setBackgroundColor(Color.argb(255, 0, 0, 255));

        final EditText textUserEnter = (EditText) findViewById(R.id.editText2);

        red = green = blue = 0;

        textUserEnter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView textToScale = (TextView) findViewById(R.id.exampleText);
                if(textUserEnter.getText().toString().equals("")){
                    return;
                }
                double temp = Double.parseDouble(textUserEnter.getText().toString());
                textToScale.setTextSize((float)temp);
            }
        });

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                Button redButton = (Button) findViewById(R.id.redDisplay);
                setRed(progress);
                bg.setBackgroundColor(Color.argb(255, getRed(), getGreen(), getBlue()));
//                redButton.setBackgroundColor(Color.argb(255, getRed(), 0, 0));
                redButton.setText(""+getRed());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                Button greenButton = (Button) findViewById(R.id.greenDisplay);
                setGreen(progress);
                bg.setBackgroundColor(Color.argb(255, getRed(), getGreen(), getBlue()));
//                greenButton.setBackgroundColor(Color.argb(255, 0, getGreen(), 0));
                greenButton.setText(""+getGreen());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                Button blueButton = (Button) findViewById(R.id.blueDisplay);
                setBlue(progress);
                bg.setBackgroundColor(Color.argb(255, getRed(), getGreen(), getBlue()));
//                blueButton.setBackgroundColor(Color.argb(255, 0, 0, getBlue()));
                blueButton.setText(""+getBlue());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        EditText textUserEnter = (EditText) findViewById(R.id.editText2);
        String name = text.getText().toString();
        name = "Hello " + name;
        Intent intent = new Intent(this, NotMainActivity.class);
        intent.putExtra("text", name);
        int[] colors = {getRed(),getGreen(),getBlue()};
        intent.putExtra("colors", colors);
        if(textUserEnter.getText().toString().equals("")){
            return;
        }
        double textSize = Double.parseDouble(textUserEnter.getText().toString());
        intent.putExtra("textSize", (float)textSize);
        startActivity(intent);
    }
}
