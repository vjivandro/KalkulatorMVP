package com.example.ivandro.kalkulator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ivandro.kalkulator.Model.MainModel;
import com.example.ivandro.kalkulator.Presenter.MainPresenter;
import com.example.ivandro.kalkulator.View.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    private int panjang;
    private int lebar;
    private EditText inputPanjang;
    private EditText inputLebar;
    private Button reset;
    private MainPresenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renderTampilan();
        presenter = new MainPresenter(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panjang = Integer.valueOf(inputPanjang.getText().toString());
                lebar = Integer.valueOf(inputLebar.getText().toString());

                presenter.hitungLuas(MainActivity.this.panjang, MainActivity.this.lebar);
            }
        });
    }

    private void renderTampilan() {
        inputPanjang = (EditText) findViewById(R.id.edit_text_panjang);
        inputLebar = (EditText) findViewById(R.id.edit_text_lebar);
        reset = (Button) findViewById(R.id.button_hitung);
    }

    @Override
    public void tampilkanLuas(MainModel model) {
        new AlertDialog.Builder(MainActivity.this).setTitle("Luas").setMessage(String.valueOf(model.getLuas())).show();
    }
}
