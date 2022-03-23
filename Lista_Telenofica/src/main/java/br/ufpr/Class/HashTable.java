/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Adrya
 */
public class HashTable extends Register{
    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static HashTable criarHashtable(Scanner s) {
        HashTable ht = new HashTable();

        System.out.println("->Digite o nome do Usuário: ");
        ht.setNome(s.nextLine());

        System.out.println("\n->Digite a Key do Usuário: ");
        ht.setKey(s.nextInt());
        s.nextLine();

        System.out.println("\n->Digite o numero do Usuário: ");
        ht.setNumero(s.nextInt());
        s.nextLine();

        System.out.println("\n|------Numero cadastrado com sucesso!------|\n\n");
        return ht;
    }

    public static void inserirHashtable(HashTable ht, Hashtable<Integer, HashTable> hashtable) {
        hashtable.put(ht.getKey(), ht);
    }

    public static HashTable buscarHashTable(Scanner s, Hashtable<Integer, HashTable> hashtable) {
        int key = 0;
        System.out.println("-> Digite a Key do usuario a ser buscado: ");
        key = s.nextInt();
        s.nextLine();

        if (hashtable.containsKey(key)) {
            return hashtable.get(key);
        } else {
            
            return null;
        }
    }

    public static int buscarHashTable(int i, Hashtable<Integer, HashTable> hashtable) {
        if (hashtable.containsKey(i)) {
            System.out.println("--> Key encontrada! \n");
            return i;
        } else {
            System.out.println("--> Key nao encontrada! \n");
            return -1;
        }
    }

    public static void excluirHashTable(Scanner s, Hashtable<Integer, HashTable> hashtable) {
        int key;
        System.out.println("-> Digite a key do numero a ser excluido: \n");
        key = s.nextInt();
        s.nextLine();
        int i = buscarHashTable(key, hashtable);

        if (i != -1) {
            hashtable.remove(i);
            System.out.println("\n|------Numero excluido com sucesso!------|\n");
        }
    }

    public static void excluirHashTable(Hashtable<Integer, HashTable> hashtable) {
        if (hashtable.size() >= 1) {
            for (int i : hashtable.keySet()) {
                hashtable.remove(i);
            }
        } else {
            System.out.println("|------Lista de numeros vazia!-------|");
        }
    }
    
    public static void alterarHashTable(Scanner s, Hashtable<Integer, HashTable> hashtable) {
        String novoNome;
        int novoNumero, id;

        System.out.println("->Digite a key do usuario a ser alterado: \n");
        id = s.nextInt();
        //s.nextLine();
        int i = HashTable.buscarHashTable(id, hashtable);
        if (i != -1) {
            if (hashtable.containsKey(i)) {
                hashtable.get(i).mostrarInfoRegister();
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
                    s.nextLine();
                    hashtable.get(i).setNome(novoNome);
                    System.out.println("\n|------Nome atualizado com sucesso!-----|\n");
                }
                case 2 -> {
                    System.out.println("--> Digite o novo Numero do usuario");
                    novoNumero = s.nextInt();
                    s.nextLine();
                    hashtable.get(i).setNumero(novoNumero);
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
                + "--> Numero: " + getNumero() + "\n\n");

    }
    
    public static void imprimirHashmap(Hashtable<Integer, HashTable> hashtable){
        System.out.println("|-----------Lista de Numeros/Hashtable----------|\n");
        if(hashtable.size() >= 1){
            for(int i : hashtable.keySet()){
            hashtable.get(i).mostrarInfoRegister();
            }
        }
        else{
            System.out.println("-->Lista de Numeros vazia!\n");
        }
        System.out.println("|-----------------------------------------------|\n");
    }
}
