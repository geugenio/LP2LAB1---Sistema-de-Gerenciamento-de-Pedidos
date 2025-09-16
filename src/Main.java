import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+==============================================+");
        System.out.println("|    BEM-VINDO AO SISTEMA DE GERENCIAMENTO     |");
        System.out.println("|    DE PRODUTOS DO RESTAURANTE JAVA'S FOOD    |");
        System.out.println("+==============================================+");

        boolean ativo = true;
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        do{
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Remover pedido");
            System.out.println("3 - Listar pedidos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            int opc = sc.nextInt();
            sc.nextLine();
            switch (opc){
                case 1:
                    System.out.print("Insira o nome do cliente: ");
                    String nome_cliente = sc.nextLine();
                    System.out.print("Insira a quantidade de itens que quer adicionar ao pedido: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    ArrayList<Item> itens = new ArrayList<Item>();
                    for (int i = 0; i < qtd; i++) {
                        Item item = new Item();
                        System.out.print("Insira o nome do item " + (i + 1) + ": ");
                        item.setNome(sc.nextLine());
                        System.out.print("Insira o preço do item " + (i + 1) + ": ");
                        item.setPreco(sc.nextDouble());
                        sc.nextLine();
                        itens.add(item);
                    }

                    Pedido pedido = new Pedido(nome_cliente, itens);
                    pedidos.add(pedido);
                    System.out.println("\n========================================");
                    System.out.println("|  Restaurante Java's Food              | ");
                    System.out.println("========================================");
                    System.out.println("Pedido N°: " + pedido.getId());
                    System.out.println("Cliente: " + nome_cliente);
                    System.out.println("----------------------------------------");
                    System.out.println("Itens:");
                    for (Item item : itens) {
                        System.out.println("- " + item.getNome() + " R$ " + item.getPreco());
                    }

                    System.out.println("----------------------------------------");
                    System.out.println("Total: R$ " + pedido.calcularValorTotal());
                    System.out.println("========================================");
                    System.out.println(" Obrigado pela preferência! :) ");
                    System.out.println("========================================\n");

                    break;

                case 2:
                    if(pedidos.isEmpty()){
                        System.out.println("Nenhum pedido registrado.");
                        break;
                    }
                    System.out.print("Insira o numero de identificação do pedido que deseja remover: ");
                    int id = sc.nextInt();
                    boolean encontrado = false;

                    for (int i = 0; i < pedidos.size(); i++) {
                        if (pedidos.get(i).getId() == id) {
                            pedidos.remove(i);
                            System.out.println("Pedido removido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Pedido não encontrado.");
                    }

                    break;
                case 3:
                    for (int i = 0; i < pedidos.size(); i++){
                        Pedido p = pedidos.get(i);
                        System.out.println("Número do pedido: " + p.getId());
                        System.out.println("Nome do cliente: " + p.getNome_cliente());
                        System.out.println("Lista de itens:");
                        ArrayList<Item> itensPedido = p.getItens();
                        for (int j = 0; j < itensPedido.size(); j++) {
                            Item item = itensPedido.get(j);
                            System.out.println("  - " + item.getNome() + ": R$ " + item.getPreco());
                        }
                        System.out.printf("Total do pedido: R$ %.2f%n", p.calcularValorTotal());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    ativo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(ativo);



        sc.close();
    }
}

