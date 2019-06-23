package com.ameen.samplesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnsave,btndelete;
    TextView textView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext);
        btnsave=findViewById(R.id.btnsave);btndelete=findViewById(R.id.btndlt);
        textView=findViewById(R.id.textview);
        dbHandler=new MyDBHandler(this,null,null,1);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products products=new Products(editText.getText().toString());
                dbHandler.addProduct(products);
                PrintDataBase();

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext=editText.getText().toString();
                dbHandler.deleteProdtuct(inputtext);
                PrintDataBase();

            }
        });

    }




    public void PrintDataBase()
    {
        String dbstring=dbHandler.dataBaseTOstring();
        textView.setText(dbstring);
        editText.setText("");
    }

}
