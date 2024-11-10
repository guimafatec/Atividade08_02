package br.edu.fateczl.atividade08_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Gustavo Guimarães de Oliveira
     */
    private EditText etNome;
    private EditText etCpf;
    private Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(op -> registrar());
    }

    private void registrar() {
        String nome = etNome.getText().toString();
        String cpf = etCpf.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("cpf", cpf);
        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();
    }
}