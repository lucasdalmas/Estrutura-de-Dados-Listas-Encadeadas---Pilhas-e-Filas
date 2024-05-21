package view;



import model.Fila;

import java.util.Scanner;

public class MenuFila {
    public static void main(String[] args) {
        Fila f = new Fila();
        Scanner sc = new Scanner(System.in);
        Fila.Resposta res;
        int dado, opcao;



        do {
            System.out.println("""
                    1 - Enqueue
                    2 - Dequeue
                    3 - First
                    4 - View
                    0 - Sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: // Enqueue
                    System.out.print("Digite o elemento que deseja inserir na fila: ");
                    dado = sc.nextInt(); //tratar erro InputMismatchException
                    f.enqueue(dado);
                    System.out.println("Elemento inserido com sucesso!");
                    break;
                case 2: // Dequeue
                    res = f.dequeue();
                    if (res.isOk()) {
                        System.out.println("Elemento retirado: " + res.getItem());
                    } else {
                        System.out.println("Erro: Pilha vazia!"); // criar tratamento para este erro
                    }
                    break;

                case 3: // First
                    res = f.first();
                    if (res.isOk()) {
                        System.out.println("Topo da pilha: " + res.getItem());
                    } else {
                        System.out.println("Erro: Pilha vazia!"); // criar tratamento para este erro
                    }
                    break;

                case 4: // View
                    f.view();
                    break;

                case 0: // Sair
                    System.out.print("Fechando programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 0);

        sc.close(); // fechar scanner
    }
}
