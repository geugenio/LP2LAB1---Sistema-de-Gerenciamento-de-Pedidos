import java.util.ArrayList;

public class Pedido {
    private int id;
    private String nome_cliente;
    private ArrayList<Item> itens;

    private static int contador = 0;

    public Pedido(String nome_cliente, ArrayList<Item> itens) {
        this.nome_cliente = nome_cliente;
        this.itens = itens;
        this.id = ++contador;
    }

    public double calcularValorTotal(){
        double total = 0;
        for (Item item: itens){
            total += item.getPreco();
        }
        return total;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
