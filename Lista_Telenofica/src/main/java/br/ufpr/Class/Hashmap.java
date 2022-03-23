/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Adrya
 */
public class Hashmap extends Register {

    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static Hashmap criarHashmap(Scanner s) {
        Hashmap hm = new Hashmap();

        System.out.println("->Digite o nome do Usuário: ");
        
        hm.setNome(s.nextLine());

        System.out.println("\n->Digite a Key do Usuário: ");
        hm.setKey(s.nextInt());
        s.nextLine();

        System.out.println("\n->Digite o numero do Usuário: ");
        hm.setNumero(s.nextInt());
        s.nextLine();

        System.out.println("\n|------Numero cadastrado com sucesso!------|\n\n");
        return hm;
    }

    public static void inserirHashMap(Hashmap hm, HashMap<Integer, Hashmap> hashmap) {
        hashmap.put(hm.getKey(), hm);
    }

    public static Hashmap buscarHashMap(Scanner s, HashMap<Integer, Hashmap> hashmap) {
        int key = 0;
        System.out.println("-> Digite a Key do usuario a ser buscado: ");
        key = s.nextInt();
        s.nextLine();

        if (hashmap.containsKey(key)) {
            
            return hashmap.get(key);
        } else {
            
            return null;
        }
    }

    public static int buscarHashMap(int i, HashMap<Integer, Hashmap> hashmap) {
        if (hashmap.containsKey(i)) {
            System.out.println("--> Key encontrada! \n");
            return i;
        } else {
            System.out.println("--> Key nao encontrada! \n");
            return -1;
        }
    }

    public static void excluirHashMap(Scanner s, HashMap<Integer, Hashmap> hashmap) {
        int key;
        System.out.println("-> Digite a Key do numero a ser excluido: \n");
        key = s.nextInt();
        s.nextLine();
        int i = buscarHashMap(key, hashmap);

        if (i != -1) {
            hashmap.remove(i);
            System.out.println("\n|------Numero excluido com sucesso!------|\n");
        }
    }

    public static void excluirArraylist(HashMap<Integer, Hashmap> hashmap) {
        if (hashmap.size() >= 1) {
            for (int i : hashmap.keySet()) {
                hashmap.remove(i);
            }
        } else {
            System.out.println("|------Lista de numeros vazia!-------|");
        }
    }

    public static void alterarHashmap(Scanner s, HashMap<Integer, Hashmap> hashmap) {
        String novoNome;
        int novoNumero, id;

        System.out.println("->Digite o ID do usuario a ser alterado: \n");
        id = s.nextInt();
        s.nextLine();
        int i = Hashmap.buscarHashMap(id, hashmap);
        if (i != -1) {
            if (hashmap.containsKey(i)) {
                hashmap.get(i).mostrarInfoRegister();
            }
            System.out.println("""
                               Qual dado do registro voc\u00ea quer alterar?
                                  --> 1 - Nome
                                 --> 2 - Numero
                               """);
            id = s.nextInt();

            switch (id) {
                case 1 -> {
                    System.out.println("--> Digite o novo Nome do usuario");
                    
                    novoNome = s.nextLine();
                    s.next();
                            
                    hashmap.get(i).setNome(novoNome);
                    System.out.println("\n|------Nome atualizado com sucesso!-----|\n");
                }
                case 2 -> {
                    System.out.println("--> Digite o novo Numero do usuario");
                    novoNumero = s.nextInt();
                    s.nextLine();
                    hashmap.get(i).setNumero(novoNumero);
                    System.out.println("\n|------Numero atualizado com sucesso!-----|\n");
                }
            }
        } else {
            System.out.println("\n|------Numero não encontrado!-----|\n");
        }
    }

    @Override
    public void mostrarInfoRegister() {
        System.out.println("--> Key: " + getKey() + "\n"
                + "--> Nome: " + getNome() + "\n"
                + " --> Numero: " + getNumero() + "\n\n");

    }

    public static void imprimirHashmap(HashMap<Integer, Hashmap> hashmap) {
        System.out.println("|-----------Lista de Numeros/Hashtable----------|\n");
        if(hashmap.size() >= 1){
            for(int i : hashmap.keySet()){
            hashmap.get(i).mostrarInfoRegister();
            }
        }
        else{
            System.out.println("-->Lista de Numeros vazia!\n");
        }
        System.out.println("|-----------------------------------------------|\n");
    }
}
