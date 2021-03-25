package amudcorp.dev.mywallet.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import amudcorp.dev.mywallet.R;

public class Cadastro extends AppCompatActivity {
    private Spinner spinner;
    private EditText nome;
    private EditText numero;
    private EditText data;
    private EditText cvv;
    private RadioGroup grupo_bandeira;
    private RadioGroup grupo_tipo;
    private CheckBox cartao_nacional;
    private CheckBox cartao_internacional;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        spinner = findViewById(R.id.spinner2);
        nome = findViewById(R.id.nome_cartao);
        numero = findViewById(R.id.numero_cartao);
        data = findViewById(R.id.cartao_expiracao);
        cvv = findViewById(R.id.cartao_cvv);
        grupo_bandeira = findViewById(R.id.grupo_bandeira);
        grupo_tipo = findViewById(R.id.grupo_tipo);
        cartao_nacional = findViewById(R.id.nacional);
        cartao_internacional = findViewById(R.id.internacional);

        popularSpinner();

    }

    public void popularSpinner() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("");
        lista.add("Brasil");
        lista.add("Bradesco");
        lista.add("Itau");
        lista.add("Neon");
        lista.add("Nubank");
        lista.add("Next");
        lista.add("Cooperativa");
        lista.add("Caixa");
        lista.add("C3");
        lista.add("Crefisa");
        lista.add("Sicred");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        spinner.setAdapter(adapter);

    }

    public void limpar(View view) {

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_menu_salvar:


                Intent intent = getIntent();


                String nome_selecionado, numero_selecionado, banco = "", funcao = "", data_selecionado, cvv_selecionado, msg, erro;
                nome_selecionado = nome.getText().toString();
                numero_selecionado = numero.getText().toString();
                data_selecionado = data.getText().toString();
                cvv_selecionado = cvv.getText().toString();
                msg = "SEU CVV É " + cvv_selecionado;
                erro = "preencha este campo, ele nao pode ficar em branco";


                if (nome_selecionado.equalsIgnoreCase("")) {
                    nome.requestFocus();
                    Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
                } else if (numero_selecionado.equalsIgnoreCase("")) {
                    numero.requestFocus();
                    Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
                } else if (data_selecionado.equalsIgnoreCase("")) {
                    data.requestFocus();
                    Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
                } else if (cvv_selecionado.equalsIgnoreCase("")) {
                    cvv.requestFocus();
                    Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
                } else if (spinner.getSelectedItem().toString().equalsIgnoreCase("") || spinner.getSelectedItem() == null) {
                    String text = "Por Favor Selecione o Banco do seu Cartao!";

                    Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                } else {
                    switch (grupo_bandeira.getCheckedRadioButtonId()) {
                        case R.id.btn_america:

                            break;
                        case R.id.btn_visa:
                            break;
                        case R.id.btn_master:

                            break;
                        case R.id.btn_elo:
                            break;
                        default:
                            String text = "Por Favor Selecione ao menos uma opção das bandeiras";
                            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                    }
                    switch (grupo_tipo.getCheckedRadioButtonId()) {
                        case R.id.btn_debito:
                            funcao = "DEBITO";

                            break;
                        case R.id.btn_credito:
                            funcao = "CREDITO";
                            break;
                        default:
                            String text = "Por Favor Selecione se seu cartao e de debito ou credito!";
                            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                    }
                }

                    banco = spinner.getSelectedItem().toString();
                    check();

                    String tmp_nome = nome_selecionado, temp_numero = numero_selecionado;
                    intent.putExtra(Home.NOME, tmp_nome);
                    intent.putExtra(Home.BANCO, banco);
                    intent.putExtra(Home.FUNCAO, funcao);
                    intent.putExtra(Home.NUMERO, temp_numero);
                    setResult(Activity.RESULT_OK, intent);
                    finish();

                break;
            case R.id.id_menu_limpar:
                 msg = "Todos os campos foram limpos";
                nome.setText("");
                numero.setText("");
                data.setText("");
                cvv.setText("");
                grupo_bandeira.clearCheck();
                grupo_tipo.clearCheck();
                cartao_nacional.setChecked(false);
                cartao_internacional.setChecked(false);
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void check() {
        if (!cartao_nacional.isChecked()) {
            String text = "Por Favor Selecione se seu cartao é internaciona ou nacional ou os dois";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        if (!cartao_internacional.isChecked()) {
            String text = "Por Favor Selecione se seu cartao é internaciona ou nacional ou os dois";
        }
    }

}