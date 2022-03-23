/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrya
 */
public class Arraylist extends Register {

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
    public static Arraylist criarArrayList(Scanner s) {
        
        Arraylist al = new Arraylist();
        System.out.println("->Digite o nome do Usuário: ");
        al.setNome(s.nextLine());

        System.out.println("\n->Digite o ID do Usuário: ");
        al.setID(s.nextInt());
        s.nextLine();

        System.out.println("\n->Digite o numero do Usuário: ");
        al.setNumero(s.nextInt());
        s.nextLine();

        System.out.println("\n|------Numero cadastrado com sucesso!------|\n\n");

        return al;
        
        
    }

    public static void inserirArraylist(Arraylist al, ArrayList<Arraylist> arraylist) {
        arraylist.add(al);
    }

    public static Arraylist buscarArraylist(Scanner s, ArrayList<Arraylist> arraylist) {
        int id;
        System.out.println("-> Digite o ID do usuario a ser buscado: ");
        id = s.nextInt();

        for (int i = 0; i < arraylist.size(); i++) {
            if (arraylist.get(i).getID() == id) {
                return arraylist.get(i);
            }
        }

        return null;
    }

    public static int buscarArraylist(int id, ArrayList<Arraylist> arraylist) {

        for (int i = 0; i < arraylist.size(); i++) {
            if (arraylist.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public static void excluirArraylist(Scanner s, ArrayList<Arraylist> arraylist) {
        int id;
        System.out.println("-> Digite o id do numero a ser excluido: \n");
        id = s.nextInt();
        s.nextLine();
        int i = buscarArraylist(id, arraylist);
        if (i != -1) {
            arraylist.remove(i);
            System.out.println("\n|------Numero excluido com sucesso!------|\n");
        } else {
            System.out.println("\n|------Numero não existe no sistema!------|\n");
        }

    }

    public static void excluirArraylist(ArrayList<Arraylist> arraylist) {
        if (arraylist.size() >= 1) {
            for (int i = 0; i < arraylist.size(); i++) {
                arraylist.remove(i);
            }
        } else {
            System.out.println("\n|------Lista de numeros vazia!-------|\n");
        }
    }

    public static void alterarArraylist(Scanner s, ArrayList<Arraylist> arraylist) {
        String novoNome;
        int novoNumero, novoid, id;

        System.out.println("->Digite o ID do usuario a ser alterado: \n");
        id = s.nextInt();
        s.nextLine();
        int i = buscarArraylist(id, arraylist);
        if (i != -1) {
            System.out.println("""
                               
                               -> Numero encontrado: 
                                   --> Nome: """ + arraylist.get(i).getNome() + "\n"
                    + "   --> Numero: " + arraylist.get(i).getNumero() + "\n"
                    + "   --> ID: " + arraylist.get(i).getID() + "\n\n");

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
                    novoNome = s.nextLine();
                    arraylist.get(i).setNome(novoNome);
                    System.out.println("\n|------Nome atualizado com sucesso!-----|\n");
                }
                case 2 -> {
                    System.out.println("--> Digite o novo Numero do usuario");
                    novoNumero = s.nextInt();
                    s.nextLine();
                    arraylist.get(i).setNumero(novoNumero);
                    System.out.println("\n|------Numero atualizado com sucesso!-----|\n");
                }
                case 3 -> {
                    System.out.println("--> Digite o novo ID do usuario");
                    novoid = s.nextInt();
                    s.nextLine();
                    arraylist.get(i).setID(novoid);
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

    public static void imprimirArraylist(ArrayList<Arraylist> arraylist) {
        System.out.println("|----------Lista de Numeros/ArrayList---------|\n");

        if (arraylist.size() >= 1) {
            for (int i = 0; i < arraylist.size(); i++) {
                arraylist.get(i).mostrarInfoRegister();
                
            }
        } else {
            System.out.println("-->Lista de Numeros vazia!\n");
        }
        System.out.println("|----------------------------------------------|\n");
    }
}
