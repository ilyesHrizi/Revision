package com.example.revision;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Email , Password;
    Button Submit ;
    TextView affich;
    RecyclerView recyclerView ;
    ArrayList<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.EditTextEmail);
        Password = findViewById(R.id.EditTextPassword);
        Submit = findViewById(R.id.btnSubmit);
        affich = findViewById(R.id.textView);
        /// kif melah fil t3aaaaaaaaaaaaaaaaam
        recyclerView = findViewById(R.id.Recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //////////////////////////////////
        list = new ArrayList<User>();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = Email.getText().toString();
                String password = Password.getText().toString();
                User user = new User(mail , password);
                list.add(user);
                list = new ArrayList<User>();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("E", mail);
                intent.putExtra("P",password);
                startActivityForResult(intent,1 );


            }
        });
        MyAdapter adapter = new MyAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                affich.setText("Valider");
            }
            else
            {
                affich.setText("Non Valider");

            }
        }
    }
}