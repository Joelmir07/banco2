package com.usjt.banco;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
String chave = null, chaveSaque = "saque", chaveTraferencia = "traferencia",
            chaveExtrato = "extrato";
    String nomeDgt = null, senhaDgt = null;

    //Registrados para login:
    String nome = "grupo3", senha = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        String codigoAcesso = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        chave = codigoAcesso;
        System.out.println("Solicitação recebida em login:"+ chave);
    }

    public void direciona(View view) {
        EditText nomeCx = (EditText) findViewById(R.id.cxNome);
        String nomeDigitado = nomeCx.getText().toString();
        senhaDgt = nomeDigitado;

        EditText senhaCx = (EditText) findViewById(R.id.cxSenha);
        String senhaDigitada = senhaCx.getText().toString();
        nomeDgt = senhaDigitada;
        System.out.println("\nNome digitado:" + nomeDgt + "\nSenha digitada:" + senhaDgt);

        if (nomeDigitado.equals(nome) && senhaDigitada.equals(senha)) {
            if (chaveSaque.equals(chave)) {
                Intent intent = new Intent(this, com.usjt.banco.Saque.class);
                startActivity(intent);
            } else if (chaveTraferencia.equals(chave)) {
                Intent intent = new Intent(this, Transfere.class);
                startActivity(intent);
            } else if (chaveExtrato.equals(chave)) {
                Intent intent = new Intent(this, Extrato.class);
                startActivity(intent);
            }
        } else {
            System.out.println("\nRequisição:" + chave + " \nERRO: 'Dados Incorretos'" +
                    "\nNome digitado: " + nomeDgt + " SenhaDigitada: " + senhaDgt +
                    "\nRegistrados para login: Nome: " + nome + " Senha: " + senha);

            Context context = getApplicationContext();
            CharSequence exibeMsg = "Dados incorretos";
            int tempo = Toast.LENGTH_SHORT;
            Toast mensagem = Toast.makeText(context, exibeMsg, tempo);
            mensagem.show();
        }
    }
}
