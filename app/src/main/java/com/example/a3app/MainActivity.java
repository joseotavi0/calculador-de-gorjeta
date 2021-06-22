package com.example.a3app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.EditValor);
        textGorjeta = findViewById(R.id.textTotal);
        textPorcentagem = findViewById(R.id.textProcentagem);
        textTotal = findViewById(R.id.textGorjeta);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        // listener seekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "digite um numero",
                    Toast.LENGTH_LONG
            ).show();
        }else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //calcular a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            // exibe a gorjeta e total
            textGorjeta.setText("R$ " + Math.round(total));
            textTotal.setText("R$ " + Math.round(gorjeta));

        }

    }


}
