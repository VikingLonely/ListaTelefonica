/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.System;

import br.ufpr.Class.Arraylist;
import br.ufpr.Class.HashTable;
import br.ufpr.Class.Hashmap;
import br.ufpr.Class.Hashset;
import br.ufpr.Class.Linkedlist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Adrya
 */
public class Control_Switch {

    Scanner s = new Scanner(System.in);
    ArrayList<Arraylist> arraylist = new ArrayList();
    LinkedList<Linkedlist> linkedlist = new LinkedList();
    HashMap<Integer, Hashmap> hashmap = new HashMap();
    Hashtable<Integer, HashTable> hashtable = new Hashtable();
    Set<Hashset> hashset = new HashSet();

    public void imprimirMenu() {
        System.out.println("""
                           |--------------------Menu-------------------|
                           
                           |        1 - Gerenciar Arraylist            |
                           |        2 - Gerenciar Linkedlist           |
                           |        3 - Gerenciar HashMap              |
                           |        4 - Gerenciar HashTable            |
                           |        5 - Gerenciar HashSet              |
                           |        6 - Imprimir Lista Telefonica      |
                           |        7 - Excluir Lista Telefonica       |
                           |        8 - Sair                           |
                           
                           |-------------------------------------------|
                           
                           Digite um dos n\u00fameros para acessar a respectiva op\u00e7\u00e3o do menu: 
                           -->""");
    }

    public void escolherOpcaoPrincipal() {
        boolean quit = false;
        while (!quit) {
            imprimirMenu();
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 ->
                    this.escolherOpcaoArraylist();
                case 2 ->
                    this.escolherOpcaoLinkedlist();
                case 3 ->
                    this.escolherOpcaoHashmap();
                case 4 ->
                    this.escolherOpcaoHashTable();
                case 5 ->
                    this.escolherOpcaoHashset();
                case 6 ->
                    this.imprimirListaTelefonica();
                case 7 ->
                    this.excluirListaTelefonica();
                case 8 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->1\n");
            }
        }

    }

    public void imprimirSubMenu(String c) {
        System.out.println("|----------Gerenciar " + c + "--------------|\n"
                + "|                                           |\n"
                + "|        1 - Incluir registro               |\n"
                + "|        2 - Buscar registro                |\n"
                + "|        3 - Excluir registro               |\n"
                + "|        4 - Atualizar registro             |\n"
                + "|        5 - Impirmir lista telefonica      |\n"
                + "|        6 - Excluir lista telefonica       |\n"
                + "|        7 - Voltar para menu principal.    |\n"
                + "|                                           |\n"
                + "|-------------------------------------------|\n"
                + "Digite um dos n\u00fameros para acessar a respectiva op\u00e7\u00e3o do menu.\n"
                + "-->");
    }

    public void escolherOpcaoArraylist() {
        boolean quit = false;
        while (!quit) {
            imprimirSubMenu("Arraylist");
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 -> {
                    String conf = "";
                    do{
                        Arraylist.inserirArraylist(Arraylist.criarArrayList(s), arraylist);
                        System.out.println(("sim".equals(conf)) ? "-->Inserir outro usuario: "  : "-->Inserir outro usuario: ");
                        conf = efetuarLeituraString(s);
                    } while("sim".equals(conf));
                    Arraylist.imprimirArraylist(arraylist);
                }

                case 2 -> {
                    Arraylist al;
                    do {
                        al = Arraylist.buscarArraylist(s, arraylist);

                        System.out.println((al == null) ? "--> Registro não encontrado." : "--> Registro encontrado: ");
                    } while (al == null);

                    al.mostrarInfoRegister();
                }
                case 3 ->
                    Arraylist.excluirArraylist(s, arraylist);
                case 4 ->
                    Arraylist.alterarArraylist(s, arraylist);
                case 5 ->
                    Arraylist.imprimirArraylist(arraylist);
                case 6 ->
                    Arraylist.excluirArraylist(arraylist);
                case 7 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->\n");
            }
        }
    }

    public void escolherOpcaoLinkedlist() {
        boolean quit = false;
        while (!quit) {
            imprimirSubMenu("Linkedlist");
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 ->{
                    String conf = "";
                    do{
                       Linkedlist.inserirLinkedlist(Linkedlist.criarLinkedlist(s), linkedlist);
                        System.out.println(("sim".equals(conf)) ? "-->Inserir outro usuario: "  : "-->Inserir outro usuario: ");
                        conf = efetuarLeituraString(s);
                    } while("sim".equals(conf));
                    Linkedlist.imprimirLinkedlist(linkedlist);
                }
                case 2 -> {
                    Linkedlist ll;
                    do {
                        ll = Linkedlist.buscarLinkedlist(s, linkedlist);

                        System.out.println((ll == null) ? "--> Registro não encontrado." : "--> Registro encontrado: ");
                    } while (ll == null);

                    ll.mostrarInfoRegister();
                }
                case 3 ->
                    Linkedlist.excluirLinkedlist(s, linkedlist);
                case 4 ->
                    Linkedlist.alterarLinkedlist(s, linkedlist);
                case 5 ->
                    Linkedlist.imprimirLinkedlist(linkedlist);
                case 6 ->
                    Linkedlist.excluirLLinkedlist(linkedlist);
                case 7 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->\n");
            }
        }
    }

    public void escolherOpcaoHashmap() {
        boolean quit = false;
        while (!quit) {
            imprimirSubMenu("Hashmap");
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 ->{
                    String conf = "";
                    do{
                        Hashmap.inserirHashMap(Hashmap.criarHashmap(s), hashmap);
                        System.out.println(("sim".equals(conf)) ? "-->Inserir outro usuario: "  : "-->Inserir outro usuario: ");
                        conf = efetuarLeituraString(s);
                    } while("sim".equals(conf));
                    Hashmap.imprimirHashmap(hashmap);
                }
                    
                case 2 -> {
                    Hashmap hm;
                    do {
                        hm = Hashmap.buscarHashMap(s, hashmap);

                        System.out.println((hm == null) ? "--> Registro não encontrado." : "--> Registro encontrado: ");
                    } while (hm == null);

                    hm.mostrarInfoRegister();
                }
                case 3 ->
                    Hashmap.excluirHashMap(s, hashmap);
                case 4 ->
                    Hashmap.alterarHashmap(s, hashmap);
                case 5 ->
                    Hashmap.imprimirHashmap(hashmap);
                case 6 ->
                    Hashmap.excluirArraylist(hashmap);
                case 7 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->\n");
            }
        }
    }

    public void escolherOpcaoHashTable() {
        boolean quit = false;
        while (!quit) {
            imprimirSubMenu("HashTable");
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 ->{
                    String conf = "";
                    do{
                        HashTable.inserirHashtable(HashTable.criarHashtable(s), hashtable);
                        System.out.println(("sim".equals(conf)) ? "-->Inserir outro usuario: "  : "-->Inserir outro usuario: ");
                        conf = efetuarLeituraString(s);
                    } while("sim".equals(conf));
                    HashTable.imprimirHashmap(hashtable);
                }
                    
                case 2 -> {
                    HashTable ht;
                    do {
                        ht = HashTable.buscarHashTable(s, hashtable);

                        System.out.println((ht == null) ? "--> Registro não encontrado." : "--> Registro encontrado: ");
                    } while (ht == null);

                    ht.mostrarInfoRegister();
                }
                case 3 ->
                    HashTable.excluirHashTable(s, hashtable);
                case 4 ->
                    HashTable.alterarHashTable(s, hashtable);
                case 5 ->
                    HashTable.imprimirHashmap(hashtable);
                case 6 ->
                    HashTable.excluirHashTable(hashtable);
                case 7 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->\n");
            }
        }
    }

    public void escolherOpcaoHashset() {
        boolean quit = false;
        while (!quit) {
            imprimirSubMenu("HashSet");
            int choice;
            choice = efetuarLeituraInteiro(s);
            switch (choice) {
                case 1 ->{
                    String conf = "";
                    do{
                       Hashset.inserirHashset(Hashset.criarHashset(s), hashset);
                        System.out.println(("sim".equals(conf)) ? "-->Inserir outro usuario: "  : "-->Inserir outro usuario: ");
                        conf = efetuarLeituraString(s);
                    } while("sim".equals(conf));
                    Hashset.imprimirHashset(hashset);
                }
                    
                case 2 -> {
                    Hashset hs;
                    do {
                        hs = Hashset.buscarHashset(s, hashset);

                        System.out.println((hs == null) ? "--> Registro não encontrado." : "--> Registro encontrado: ");
                    } while (hs == null);

                    hs.mostrarInfoRegister();
                }
                case 3 ->
                    Hashset.excluirHashset(s, hashset);
                case 4 ->
                    Hashset.alterarHashmap(s, hashset);
                case 5 ->
                    Hashset.imprimirHashset(hashset);
                case 6 ->
                    Hashset.excluirHashset(hashset);
                case 7 ->
                    quit = true;
                default ->
                    System.out.println("\n<-----Opção invalida! Tente novamente----->\n");
            }
        }
    }

    public void imprimirListaTelefonica() {
        Arraylist.imprimirArraylist(arraylist);
        Linkedlist.imprimirLinkedlist(linkedlist);
        Hashmap.imprimirHashmap(hashmap);
        HashTable.imprimirHashmap(hashtable);
        Hashset.imprimirHashset(hashset);
    }

    public void excluirListaTelefonica() {
        Arraylist.excluirArraylist(arraylist);
        Linkedlist.excluirLLinkedlist(linkedlist);
        Hashmap.excluirArraylist(hashmap);
        HashTable.excluirHashTable(hashtable);
        Hashset.excluirHashset(hashset);
    }

    public String efetuarLeituraString(Scanner s) {
        return s.nextLine();
    }

    public int efetuarLeituraInteiro(Scanner s) {
        int a = s.nextInt();
        s.nextLine();
        return a;

    }

    public void finalizarScanner(Scanner s) {
        s.close();
    }

}
