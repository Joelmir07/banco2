package com.usjt.banco;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.usjt.banco.SERVICO";

    String servico = null;
    String executaSaque = "saque";
    String executaTransferencia = "traferencia";
    String executaExtrato = "extrato";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void executa() {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra(EXTRA_MESSAGE, servico);
        startActivity(intent);

        System.out.println("Solicitação emitida em Driver: " + servico);
    }
    public void Sacar(View view) {
        servico = executaSaque;
        executa();
    }
    public void Transferir(View view) {
        servico = executaTransferencia;
        executa();
    }
    public void Extrato(View view) {
        servico = executaExtrato;
        executa();
    }

}
