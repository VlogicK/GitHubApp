package com.example.android.githubapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Search;
    EditText userid;
    static String ID="id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Search=(Button)findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userid=(EditText)findViewById(R.id.UserId);

                String idString=userid.getEditableText().toString();

                Intent intent=new Intent(MainActivity.this,UserDetails.class);
                intent.putExtra(ID,idString);
                startActivity(intent);


            }
        });


    }
}
