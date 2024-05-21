package view;
import model.Pilha;

import java.util.Scanner;

public class MenuPilha1 {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        Scanner sc = new Scanner(System.in);

        int dado, opcao;
        Pilha.Retorno retorno = new Pilha.Retorno();

        p.Init();

        do {
            System.out.println("""
                    1 - Push
                    2 - Pop
                    3 - Top
                    4 - View
                    0 - Sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: // Push
                    System.out.print("Digite o elemento que deseja inserir na pilha: ");
                    dado = sc.nextInt(); //tratar erro InputMismatchException
                    p.Push(dado);
                    System.out.println("Elemento inserido com sucesso!");
                    break;

                case 2: // Pop
                    retorno = p.Pop();
                    if (retorno.isOk()) {
                        System.out.println("Elemento retirado: " + retorno.getDado());
                    } else {
                        System.out.println("Erro: Pilha vazia!"); // criar tratamento para este erro
                    }
                    break;

                case 3: // Top
                    retorno = p.Top();
                    if (retorno.isOk()) {
                        System.out.println("Topo da pilha: " + retorno.getDado());
                    } else {
                        System.out.println("Erro: Pilha vazia!"); // criar tratamento para este erro
                    }
                    break;

                case 4: // View
                    p.View();
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
