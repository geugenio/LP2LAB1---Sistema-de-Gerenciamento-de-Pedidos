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
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Registrar pedido");
                    break;
                case 2:
                    System.out.println("Remover pedido");
                    break;
                case 3:
                    System.out.println("Listar pedidos");
                    break;
                case 4:
                    System.out.println("Sair");
                    ativo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(ativo);
    }
}