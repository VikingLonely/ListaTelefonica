/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.Class;

/**
 *
 * @author Adrya
 */
public abstract class Register {

    private String nome;
    private int numero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void mostrarInfoRegister() {
        System.out.println(" --> Nome: " + getNome() + "\n"
                + " --> Numero: " + getNumero() + "\n\n");
    }
}
