package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView jenisTxt, namaTxt;
    EditText jumlahEditText;
    Button okBtn;
    public static final String OK_EXTRA = "OK_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        jenisTxt = findViewById(R.id.jenis);
        namaTxt = findViewById(R.id.nama_makanan);
        jumlahEditText = findViewById(R.id.input_jumlah);
        okBtn = findViewById(R.id.ok_btn);

        Intent intent = getIntent();
        String txt1 = intent.getStringExtra(MainActivity.MENU_EXTRA);
        namaTxt.setText(txt1);
        String txt2 = intent.getStringExtra(MainActivity.JENIS_EXTRA);
        jenisTxt.setText(txt2);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String jmlh = jumlahEditText.getText().toString();
                intent.putExtra(OK_EXTRA, jmlh);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}