package amudcorp.dev.mywallet.Model;


public class Cartao {
    String owner_name;
    String card_type;
    String card_flag;
    String card_name;
    String card_bank;
    String card_function;
    String card_number;
    int card_exp;
    int cvv2;

    public Cartao(String card_name, String card_bank, String card_function, String card_number) {
        this.card_name = card_name;
        this.card_bank = card_bank;
        this.card_function = card_function;
        this.card_number = card_number;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_bank() {
        return card_bank;
    }

    public void setCard_bank(String card_bank) {
        this.card_bank = card_bank;
    }

    public String getCard_function() {
        return card_function;
    }

    public void setCard_function(String card_function) {
        this.card_function = card_function;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        String aux = "Apelido do Cartão: " + getCard_name() + "\nNumero do Cartão: " + getCard_number() + "\nCartão do Banco:  " + getCard_bank() + "\nFunção do Cartão: " +
                getCard_function();
        return aux;
    }
}
