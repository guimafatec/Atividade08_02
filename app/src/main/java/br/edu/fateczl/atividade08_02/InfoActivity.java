package br.edu.fateczl.atividade08_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atividade08_02.model.Pessoa;

public class InfoActivity extends AppCompatActivity {
    /*
     *@author: Gustavo Guimarães de Oliveira
     */
    private TextView tvNome;
    private TextView tvCpf;
    private TextView tvRegiao;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tvNome = findViewById(R.id.tvNome);
        tvCpf = findViewById(R.id.tvCpf);
        tvRegiao = findViewById(R.id.tvRegiao);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(op -> back());
        show();
    }

    private void back() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void show() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String[] regioes = {
                "Rio Grande do Sul",
                "Distrito Federal, Goias, Mato Grosso, Mato Grosso do Sul e Tocantins",
                "Para, Amazonas, Acre, Amapa, Rondonia e Roraima",
                "Ceara, Maranhao e Piaui",
                "Pernambuco, Rio Grande do Norte, Paraiba e Alagoas",
                "Bahia e Sergipe",
                "Minas Gerais",
                "Rio de Janeiro e Espirito Santo",
                "Sao Paulo",
                "Parana e Santa Catarina"
        };

        String nome = bundle.getString("nome");
        String cpf = bundle.getString("cpf");
        Pessoa pessoa = new Pessoa(nome, cpf);


        String regiao = "";
        try {
            regiao = pessoa.getRegiao(regioes);
        } catch (Exception e) {
            regiao = "Região inexistente, CPF inválido";
        }

        tvNome.setText(String.format("Nome: %s", nome));
        tvCpf.setText(String.format("CPF: %s", cpf));
        tvRegiao.setText(String.format("Região: %s", regiao));
    }
}