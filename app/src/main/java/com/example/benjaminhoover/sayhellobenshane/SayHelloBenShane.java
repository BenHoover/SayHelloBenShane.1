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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class SayHelloBenShane extends Activity  {
    public int red;
    public int green;
    public int blue;
    public int alpha;

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
    public void setAlpha(int i){
        if( i <= 255 && i >= 0){
            alpha = i;
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
    public int getAlpha(){
        return alpha;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello_ben_shane);
        //Implement seekbar listeners
        SeekBar redSeek =(SeekBar) findViewById(R.id.rdSlider);
        SeekBar greenSeek =(SeekBar) findViewById(R.id.gnSlider);
        SeekBar blueSeek =(SeekBar) findViewById(R.id.blSlider);
        SeekBar alphaSeek = (SeekBar) findViewById(R.id.alphaSlider);

        Button redButton = (Button) findViewById(R.id.redDisplay);
        Button greenButton = (Button) findViewById(R.id.greenDisplay);
        Button blueButton = (Button) findViewById(R.id.blueDisplay);

        redButton.setBackgroundColor(Color.argb(255, 255, 0, 0));
        greenButton.setBackgroundColor(Color.argb(255, 0, 255, 0));
        blueButton.setBackgroundColor(Color.argb(255, 0, 0, 255));

        final EditText textUserEnter = (EditText) findViewById(R.id.editText2);

        Spinner colourOptions = (Spinner) findViewById(R.id.spinner);

        red = green = blue = 0;
        alpha = 255;

        colourOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                switch(position){
                    case 1:
                        setAlpha(255);
                        setRed(255);
                        setGreen(196);
                        setBlue(12);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    case 2:
                        setAlpha(255);
                        setRed(0);
                        setGreen(191);
                        setBlue(255);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    case 3:
                        setAlpha(255);
                        setRed(179);
                        setGreen(27);
                        setBlue(27);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    case 4:
                        setAlpha(255);
                        setRed(185);
                        setGreen(242);
                        setBlue(255);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    case 5:
                        setAlpha(255);
                        setRed(204);
                        setGreen(102);
                        setBlue(102);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    case 6:
                        setAlpha(255);
                        setRed(253);
                        setGreen(217);
                        setBlue(181);
                        bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
                        setButtons(getRed(), getGreen(), getBlue());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                double size = 0;
                if(textUserEnter.getText().toString().equals("")){
                    size = 0;
                }else{
                    size = Double.parseDouble(textUserEnter.getText().toString());
                }
                textToScale.setTextSize((float)size);
            }
        });

        alphaSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                setAlpha(progress);
                bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RelativeLayout bg = (RelativeLayout) findViewById(R.id.bg);
                Button redButton = (Button) findViewById(R.id.redDisplay);
                setRed(progress);
                bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
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
                bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
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
                bg.setBackgroundColor(Color.argb(getAlpha(), getRed(), getGreen(), getBlue()));
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
    public void setButtons(int r, int g, int b){
        Button redButton = (Button) findViewById(R.id.redDisplay);
        Button greenButton = (Button) findViewById(R.id.greenDisplay);
        Button blueButton = (Button) findViewById(R.id.blueDisplay);
        redButton.setText(""+r);
        greenButton.setText(""+g);
        blueButton.setText(""+b);
        SeekBar redSeek =(SeekBar) findViewById(R.id.rdSlider);
        SeekBar greenSeek =(SeekBar) findViewById(R.id.gnSlider);
        SeekBar blueSeek =(SeekBar) findViewById(R.id.blSlider);
        SeekBar alphaSeek = (SeekBar) findViewById(R.id.alphaSlider);
        redSeek.setProgress(r);
        greenSeek.setProgress(g);
        blueSeek.setProgress(b);
        alphaSeek.setProgress(255);
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
        int[] colors = {getAlpha(), getRed(),getGreen(),getBlue()};
        intent.putExtra("colors", colors);
        double textSize = 0;
        if(textUserEnter.getText().toString().equals("")){
            textSize = 0;
        }else{
            textSize = Double.parseDouble(textUserEnter.getText().toString());
        }
        intent.putExtra("textSize", (float)textSize);
        startActivity(intent);
    }
}
