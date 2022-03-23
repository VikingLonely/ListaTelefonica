/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Adrya
 */
public class Linkedlist extends Register {

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @param s
     * @return
     */
    public static Linkedlist criarLinkedlist(Scanner s) {
        Linkedlist ll = new Linkedlist();

        System.out.println("->Digite o nome do Usuário: ");
        ll.setNome(s.nextLine());

        System.out.println("\n->Digite o ID do Usuário: ");
        ll.setID(s.nextInt());
        s.nextLine();

        System.out.println("\n->Digite o numero do Usuário: ");
        ll.setNumero(s.nextInt());
        s.nextLine();

        System.out.println("\n|------Numero cadastrado com sucesso!------|\n\n");

        return ll;
    }

    public static void inserirLinkedlist(Linkedlist ll, LinkedList<Linkedlist> linkedlist) {
        linkedlist.addLast(ll);
    }

    public static Linkedlist buscarLinkedlist(Scanner s, LinkedList<Linkedlist> linkedlist) {
        int id;
        System.out.println("-> Digite o ID do usuario a ser buscado: ");
        id = s.nextInt();

        for (int i = 0; i < linkedlist.size(); i++) {
            if (linkedlist.get(i).getID() == id) {
                return linkedlist.get(i);
            }
        }

        return null;
    }

    public static int buscarLinkedlist(int id, LinkedList<Linkedlist> linkedlist) {

        for (int i = 0; i < linkedlist.size(); i++) {
            if (linkedlist.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public static void excluirLinkedlist(Scanner s, LinkedList<Linkedlist> linkedlist) {
        int id;
        System.out.println("-> Digite o id do numero a ser excluido: \n");
        id = s.nextInt();
        s.nextLine();
        int i = buscarLinkedlist(id, linkedlist);
        if (i != -1) {
            linkedlist.remove(i);
            System.out.println("\n|------Numero excluido com sucesso!------|\n");
        } else {
            System.out.println("\n|------Numero não existe no sistema!------|\n");
        }

    }

    public static void excluirLLinkedlist(LinkedList<Linkedlist> linkedlist) {
        if (linkedlist.size() >= 1) {
            for (int i = 0; i < linkedlist.size(); i++) {
                linkedlist.remove(i);
            }
        } else {
            System.out.println("|------Lista de numeros vazia!-------|");
        }
    }

    public static void alterarLinkedlist(Scanner s, LinkedList<Linkedlist> linkedlist) {
        String novoNome;
        int novoNumero, novoid, id;

        System.out.println("->Digite o ID do usuario a ser alterado: \n");
        id = s.nextInt();
        s.nextLine();
        int i = buscarLinkedlist(id, linkedlist);
        if (i != -1) {
            System.out.println("""
                               
                               -> Numero encontrado: 
                                   --> Nome: """ + linkedlist.get(i).getNome() + "\n"
                    + "   --> Numero: " + linkedlist.get(i).getNumero() + "\n"
                    + "   --> ID: " + linkedlist.get(i).getID() + "\n\n");

            System.out.println("""
                               Qual dado do registro voc\u00ea quer alterar?
                                  --> 1 - Nome
                                 --> 2 - Numero
                                 --> 3 - ID
                               """);
            id = s.nextInt();

            switch (id) {
                case 1 -> {
                    System.out.println("--> Digite o novo Nome do usuario");
                    novoNome = s.next();
                    linkedlist.get(i).setNome(novoNome);
                    System.out.println("\n|------Nome atualizado com sucesso!-----|\n");
                }
                case 2 -> {
                    System.out.println("--> Digite o novo Numero do usuario");
                    novoNumero = s.nextInt();
                    s.nextLine();
                    linkedlist.get(i).setNumero(novoNumero);
                    System.out.println("\n|------Numero atualizado com sucesso!-----|\n");
                }
                case 3 -> {
                    System.out.println("--> Digite o novo ID do usuario");
                    novoid = s.nextInt();
                    s.nextLine();
                    linkedlist.get(i).setID(novoid);
                    System.out.println("\n|------ID atualizado com sucesso!-----|\n");
                }
            }
        } else {
            System.out.println("\n|------Numero não encontrado!-----|\n");
        }
    }

    @Override
    public void mostrarInfoRegister() {
        System.out.println(" --> Nome: " + getNome() + "\n"
                + " --> Numero: " + getNumero() + "\n"
                + " --> ID: " + this.ID + "\n\n");
    }

    public static void imprimirLinkedlist(LinkedList<Linkedlist> linkedlist) {
        if (linkedlist.size() >= 1) {
            System.out.println("|----------Lista de Numeros/LinkedList-----------|\n");
            for (int i = 0; i < linkedlist.size(); i++) {
                linkedlist.get(i).mostrarInfoRegister();
                
            }
        } else {
            System.out.println("-->Lista de Numeros vazia!\n");
        }
        System.out.println("|-----------------------------------------------|\n");
    }
}
