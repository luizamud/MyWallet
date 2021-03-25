package amudcorp.dev.mywallet.Controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import amudcorp.dev.mywallet.Model.Cartao;
import amudcorp.dev.mywallet.Utils.RecyclerTouchListener;
import amudcorp.dev.mywallet.View.CartaoAdapter;
import amudcorp.dev.mywallet.R;


public class Home extends AppCompatActivity {
    public static final String NOME = "NOME";
    public static final String BANCO = "BANCO";
    public static final String FUNCAO = "FUNCAO";
    public static final String NUMERO = "NUMERO";
    private ArrayList<Cartao> cartoes;
    private CartaoAdapter cartaoAdapter;
    private RecyclerView recyclerView;
    private static int POSITION = 1;
    private ActionMode actionMode;

   public ActionMode.Callback callback = new ActionMode.Callback() {
       @Override
       public boolean onCreateActionMode(ActionMode mode, Menu menu) {
           return false;
       }

       @Override
       public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
           return false;
       }

       @Override
       public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
           return false;
       }

       @Override
       public void onDestroyActionMode(ActionMode mode) {

       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        recyclerView = findViewById(R.id.id_list_view);
        registerForContextMenu(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                LinearLayout.VERTICAL));

        cartoes = new ArrayList<>();
        cartaoAdapter = new CartaoAdapter(cartoes);
        recyclerView.setAdapter(cartaoAdapter);




        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public boolean onLongClick(View view, int position) {
                POSITION = position;
                if(actionMode != null){
                    return false;
                }
                actionMode= startSupportActionMode(callback);
                return true;
            }
        }));


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {

            Bundle bundle = data.getExtras();

            if (bundle != null && resultCode == RESULT_OK) {
                String nome = bundle.getString("NOME", "Nome");
                String banco = bundle.getString("BANCO", "error");
                String funcao = bundle.getString("FUNCAO", "error");
                String numero = bundle.getString("NUMERO", "error");
                cartoes.add(new Cartao(nome, banco, funcao, numero));
                cartaoAdapter.notifyDataSetChanged();

            }else if(bundle != null && resultCode == 3){
                String nome = bundle.getString("NOME", "Nome");
                String banco = bundle.getString("BANCO", "error");
                String funcao = bundle.getString("FUNCAO", "error");
                String numero = bundle.getString("NUMERO", "error");
                cartoes.remove(POSITION);
                cartoes.add(new Cartao(nome, banco, funcao, numero));
                cartaoAdapter.notifyDataSetChanged();
            }

        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contexto_home,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_menu_adicionar:
                Intent intentx = new Intent(this, Cadastro.class);
                startActivityForResult(intentx, 1);
                //NO SENSE CODE FOR ME
            //    intentx = getIntent();
               /// Bundle bundle = intentx.getExtras();
               /// if (bundle != null) {
               //     String teste = bundle.getString("NOME", "erro");
               //     Toast.makeText(this, teste, Toast.LENGTH_LONG);

               // }
                break;
            case R.id.id_menu_autoria:
                Intent intent = new Intent(this, AppAutoria.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void excluir(){
        cartoes.remove(POSITION);
        cartaoAdapter.notifyDataSetChanged();

    }

}