/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Adrya
 */
public class Hashset extends Register {

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static Hashset criarHashset(Scanner s) {
        Hashset hs = new Hashset();

        System.out.println("->Digite o nome do Usuário: ");
        hs.setNome(s.nextLine());

        System.out.println("\n->Digite o ID do Usuário: ");
        hs.setID(s.nextInt());
        s.nextLine();

        System.out.println("\n->Digite o numero do Usuário: ");
        hs.setNumero(s.nextInt());
        s.nextLine();

        System.out.println("|------Numero cadastrado com sucesso!------|");

        return hs;
    }

    public static void inserirHashset(Hashset hs, Set<Hashset> hashset) {
        hashset.add(hs);
    }

    public static Hashset buscarHashset(Scanner s, Set<Hashset> hashset) {
        int id;
        System.out.println("-> Digite o ID do usuario a ser buscado: ");
        id = s.nextInt();

        for (Hashset hs : hashset) {
            if (hs.getID() == id) {
                return hs;
            }
        }

        return null;
    }

    public static Hashset buscarHashset(int id, Set<Hashset> hashset) {

        for (Hashset hs : hashset) {
            if (hs.getID() == id) {
                return hs;
            }
        }

        return null;
    }

    public static void excluirHashset(Scanner s, Set<Hashset> hashset) {
        int id;

        System.out.println("-> Digite o id do numero a ser excluido: \n");
        id = s.nextInt();
        s.nextLine();
        Hashset i = buscarHashset(id, hashset);
        if (i != null) {
            hashset.remove(i);
            System.out.println("\n|------Numero excluido com sucesso!------|\n");
        } else {
            System.out.println("\n|------Numero não existe no sistema!------|\n");
        }

    }

    public static void excluirHashset(Set<Hashset> hashset) {
        if (hashset.size() >= 1) {
            for (Hashset hs : hashset) {
                hashset.remove(hs);
            }
        } else {
            System.out.println("|------Lista de numeros vazia!-------|");
        }
    }

    public static void alterarHashmap(Scanner s, Set<Hashset> hashset) {
        int novoNumero, id;
        Hashset hs = new Hashset();
        System.out.println("->Digite o ID do usuario a ser alterado: \n");
        id = s.nextInt();
        s.nextLine();
        Hashset i = Hashset.buscarHashset(id, hashset);

        if (i != null) {
            System.out.println("""
                               -> Numero encontrado: 
                              --> ID: """ + i.getID() + "\n"
                    + "   --> Nome: " + i.getNome() + "\n"
                    + "   --> Numero: " + i.getNumero() + "\n\n");
            System.out.println("""
                               Qual dado do registro voc\u00ea quer alterar?
                                 --> 1 - Nome
                                 --> 2 - Numero
                               """);
            id = s.nextInt();

            switch (id) {
                case 1 -> {
                    
                    System.out.println("--> Digite o novo Nome do usuario");
                    s.next();
                    hs.setNome(s.nextLine());
                    hs.setID(i.getID());
                    hs.setNumero(i.getNumero());
                    hashset.add(hs);
                    System.out.println("\n|------Nome atualizado com sucesso!-----|\n");
                }
                case 2 -> {
                    
                    System.out.println("--> Digite o novo Numero do usuario");
                    novoNumero = s.nextInt();
                    s.nextLine();
                    hs.setNome(i.getNome());
                    hs.setID(i.getID());
                    hs.setNumero(novoNumero);
                    hashset.add(hs);
                    System.out.println("\n|------Numero atualizado com sucesso!-----|\n");
                }
            }
        } else {
            System.out.println("\n|------Numero não encontrado!-----|\n");
        }
        hashset.remove(i);

    }
    
    @Override
    public void mostrarInfoRegister(){
        System.out.println(" --> Nome: " + getNome() + "\n"
                + " --> Numero: " + getNumero() + "\n"
                + " --> ID: " + this.ID + "\n\n");
    }
    
    public static void imprimirHashset(Set<Hashset> hashset){
        if (hashset.size() >= 1) {
            System.out.println("|------------Lista de Numeros/Hashset------------|\n");
            for (Hashset hs : hashset) {
               hs.mostrarInfoRegister();
                
            }
        } else {
            System.out.println("-->Lista de Numeros vazia!\n");
        }
        System.out.println("|-----------------------------------------------|\n");
    }
}
