package view;

import model.Pilha;

import java.util.Scanner;

public class ConversorBinario {
    /*
    logica da conversão de um número decimal para binário:
    divide um numero por 2 até chegar em 1 ou 2 (resto 1 ou zero)
    inverte a saida dos dados

    ex:
    11/2 = 5 resto 1
    5/2 = 2 resto 1
    2/2 = 1 resto 0
    1/2 = 0 resto 1
     */
    public static void main(String[] args) {
        Pilha pilhaResto = new Pilha();
        Pilha.Retorno retorno;
        Scanner scanner = new Scanner(System.in);
        int num;
        StringBuilder numBinario = new StringBuilder();

        pilhaResto.Init();

        // numero que será convertido
        System.out.println("Insira um número inteiro:");
        num = scanner.nextInt();

        // conversao do numero para binario (1 e 0)
        while (num > 0){
            int resto = num % 2;
            pilhaResto.Push(resto);
            num = num / 2;
        }

        // concatena os elementos da pilha pelo StringBuilder
        do {
            retorno = pilhaResto.Pop();
            if (retorno.isOk()){
                numBinario.append(retorno.getDado());
            }
        } while (retorno.isOk());

        // Imprime o valor convertido
        System.out.println("Valor em binário:");
        System.out.println(numBinario);

        scanner.close();

    }
}
