package com.ifs.app;

import jdk.internal.util.xml.impl.Input;

import java.util.Arrays;
import java.util.Scanner;

public class teste {
        public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            int qtd1 = 0;
            int v1[] = new int[50];
            int v2[] = new int[50];
            int vd[] = new int[50];
            int vu[] = new int[50];
            int vi[] = new int[50];
            int inter = 0;
            byte num = 0;

            int qtd2 = 0;
            int qtd3 = 0;
            int diferente = 0;
            int uniao = 0;
            boolean iguais;
            do{
                System.out.println("####################");
                System.out.println("        MENU        ");
                System.out.println("####################");
                System.out.println("1: INSERIR DOIS VETORES! \n"
                        +"2: LISTAR DOIS VETORES! \n"
                        +"3: UNIÃO DE VETORES! \n"
                        +"4: INTERCEÇÃO DE VETORES! \n"
                        +"5: INTERCALAR VETORES! \n"
                        +"6: PARA SAIR DO PROGRAMA DIGITE! \n"
                        +"ENTRE COM A OPÇÃO DESEJADA!");
                num = ler.nextByte();

                if(num == 1){
                    do {
                        System.out.println("Entre com a quantidade de numeros do vetor1 menor ou igual a 50:");
                        qtd1 = ler.nextInt();

                    }while (qtd1 < 0 | qtd1 > 50);
                    for (int i = 0;i < qtd1;i++){
                        do {
                            System.out.print("Entre com o " + i + "º numero do vetor1: obs:o vetor não aceitará numeros repetidos!");
                            int numero = ler.nextInt();
                            iguais = false;
                            for (int j =0;j < i;j++){
                                if(v1[j] == numero){
                                    iguais = true;
                                }
                            }
                            if (!iguais){
                                v1[i] = numero;
                            }
                        } while (iguais);
                    }
                    do {
                        System.out.println("Entre com a quantidade de numeros do vetor2 menor ou igual a 50:");
                        qtd2 = ler.nextInt();
                         int a = 2;
                        qtd3 = qtd1 + qtd2;
                    }while (qtd2 < 0 | qtd2 > 50);
                    for (int i = 0;i < qtd2;i++){
                        do {
                            System.out.print("Entre com o " + i + "º numero do vetor2: obs:o vetor não aceitará numeros repetidos!");
                            int numero2 = ler.nextInt();
                            iguais = false;
                            for (int j =0;j < i;j++){
                                if(v2[j] == numero2){
                                    iguais = true;

                                }
                            }
                            if (!iguais){
                                v2[i] = numero2;
                            }
                        } while (iguais);
                    }
                }
                if (num == 2){
                    System.out.println("##### VETOR 1 #####");
                    for (int i = 0;i < qtd1;i++){
                        System.out.print(v1[i] + " / ");
                    }
                    System.out.println();
                    System.out.println("##### VETOR 2 #####:");
                    for (int j = 0;j < qtd2;j++){
                        System.out.print(v2[j] + " / ");
                    }
                }
                System.out.println();
                if(num == 3){
                    for (int p =0;p < qtd1;p++){
                        vu[uniao] = v1[p];
                        uniao++;
                    }
                    for (int o =0;o < qtd2;o++){
                        vu[uniao] = v2[o];
                        uniao++;
                    }
                    int[] res = Arrays.stream(vu).distinct().toArray();
                    System.out.println("VETOR UNIAO:");
                    for (int p =0;p < res.length;p++){
                        System.out.print(res[p] + " / ");
                    }
                }
                if (num == 4){
                    for (int i =0;i < qtd1;i++){
                        for (int j =0;j < qtd2;j++){
                            if (v1[i] != v2[j]){
                                vd[diferente] = v1[i];
                            }
                        }
                        if (vd[diferente] > 0){
                            diferente++;
                        }
                    }
                    System.out.println();
                    System.out.println("VETOR INTERCEÇÃO");
                    for (int p =0;p < diferente;p++){
                        System.out.print(vd[p] + " / ");
                    }
                }
                if(num == 5){

                    for (int i =0;i < (qtd2 + qtd1);i++){
                        System.out.println(qtd2);
                        vi[inter] = v1[i];
                        inter++;
                        vi[inter] = v2[i];
                        inter++;
                    }
                    System.out.println("VETOR INTERCALADO:");
                    for (int p =0;p < inter;p++){
                        System.out.print(vi[p] + " / ");
                    }
                }
                System.out.println();
            }while (num != 6);
            System.out.print("FIM DO PROGRAMA.");
        }
    }


