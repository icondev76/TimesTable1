package com.icondev76.timestable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int timestable;
    SeekBar mySeekBar;
    ListView myListView;
    ArrayList<String> arrayList;
    ArrayAdapter<String>arrayAdapter;

    public void createArray(){
        arrayList.clear();
        for(int i=0; i<10; i++){
            int calc= timestable*(i+1);
            arrayList.add(i,timestable+" X "+(i+1)+" = "+calc);
        }
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySeekBar= (SeekBar)findViewById(R.id.mySeekBar);
        myListView=(ListView)findViewById(R.id.myListView);
        arrayList= new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);

        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);
        timestable=10;
        createArray();
        
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress<1){
                    mySeekBar.setProgress(1);
                    timestable=1;
                }else{
                    timestable=progress;
                }
                createArray();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
