package amudcorp.dev.mywallet.View;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import amudcorp.dev.mywallet.Model.Cartao;
import amudcorp.dev.mywallet.R;


public class CartaoAdapter extends RecyclerView.Adapter<CartaoAdapter.MyViewHolder> {

    private List<Cartao> lista;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_nome;
        private TextView txt_banco;
        private TextView txt_funcao;
        private TextView txt_numero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_nome = itemView.findViewById(R.id.item_nome);
            txt_banco = itemView.findViewById(R.id.item_banco);
            txt_funcao = itemView.findViewById(R.id.item_funcao);
            txt_numero = itemView.findViewById(R.id.item_numero);
        }
    }

    public CartaoAdapter(List<Cartao> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.modelo_cartao,
                        viewGroup,
                        false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Cartao cartao = lista.get(i);

        myViewHolder.txt_nome.setText(cartao.getCard_name());
        myViewHolder.txt_banco.setText(cartao.getCard_bank());
        myViewHolder.txt_funcao.setText(cartao.getCard_function());
        myViewHolder.txt_numero.setText(cartao.getCard_number());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}