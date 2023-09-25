package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
ListView listViewData;
ArrayAdapter adapter;
String[] array1={"eat food","walk","charge your cell","read book","call friend","go to meeting","meet a friend"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step1
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }


        listViewData=findViewById(R.id.listview_data);
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array1){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position,convertView,parent);
                if(position==0)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item1));
                }
                else if(position==1)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item2));
                }
                else if(position==2)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item3));
                }
                else if(position==3)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item4));
                }
                else if(position==4)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item5));
                }
                else if(position==5)
                {

                    view.setBackgroundColor(getResources().getColor(R.color.item6));
                }
                else
                {
                    view.setBackgroundColor(getResources().getColor(R.color.item1));
                }
                return view;
            }
        };
        listViewData.setAdapter(adapter);


        Button btn1;
        btn1=findViewById(R.id.button4);
        btn1.setOnClickListener(view -> {

            StringBuilder itemSelected= new StringBuilder("Selected Item"+"\n\n");
            StringBuilder itemUnSelected= new StringBuilder("Un Selected Item"+"\n\n");
            for(int i=0;i<listViewData.getCount();i++){
                if(listViewData.isItemChecked(i))
                {
                    itemSelected.append(listViewData.getItemAtPosition(i)).append("\n\n");
                }
                else
                {
                    itemUnSelected.append(listViewData.getItemAtPosition(i)).append("\n\n");
                }
            }
            Intent intent= new Intent(MainActivity.this,Incomplete.class);
            intent.putExtra("list", itemUnSelected.toString());
            startActivity(intent);

        });

        Button btn2;
        btn2=findViewById(R.id.button5);
        btn2.setOnClickListener(view -> {

                    StringBuilder itemSelected= new StringBuilder("Selected Item"+"\n\n");
                    for(int i=0;i<listViewData.getCount();i++){
                        if(listViewData.isItemChecked(i))
                        {
                            itemSelected.append(listViewData.getItemAtPosition(i)).append("\n\n");
                        }
                    }
                    Intent intent= new Intent(MainActivity.this,Complete.class);
                    intent.putExtra("list", itemSelected.toString());
                    startActivity(intent);

        });


    }

}