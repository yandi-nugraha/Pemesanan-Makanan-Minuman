package com.example.menu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText menuEditText;
    Button makananBtn, minumanBtn;
    TextView hasilJumlah;
    public static final String MENU_EXTRA = "MENU_KEY";
    public static final String JENIS_EXTRA = "JENIS_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuEditText = findViewById(R.id.menu_editText);
        makananBtn = findViewById(R.id.makanan_btn);
        minumanBtn = findViewById(R.id.minuman_btn);
        hasilJumlah = findViewById(R.id.jumlah);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    String jmlh = result.getData().getStringExtra(SecondActivity.OK_EXTRA);
                    hasilJumlah.setText(jmlh);
                }
            }
        });

        makananBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String txt1 = menuEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, txt1);
                String txt2 = "Makanan";
                intent.putExtra(JENIS_EXTRA, txt2);
                launcher.launch(intent);
            }
        });

        minumanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                String txt1 = menuEditText.getText().toString();
                intent.putExtra(MENU_EXTRA, txt1);
                String txt2 = "Minuman";
                intent.putExtra(JENIS_EXTRA, txt2);
                launcher.launch(intent);
            }
        });
    }
}