/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecthubfabri;

/**
 *
 * @author Precision
 */
public class Administrador extends Usuario {
    private String permissions;

    public Administrador(int id, String nome, String email, String telefone, String endereco, String permissions) {
        super(id, nome, email, telefone, endereco);
        this.permissions = permissions;
    }

    public String getPermissions() { return permissions; }
    public void setPermissions(String permissions) { this.permissions = permissions; }

    public void permissao() {
        System.out.println("Administrador " + nome + " possui permissões: " + permissions);
    }

    @Override
    public boolean pessoaJuridica() {
        return false;
    }

    @Override
    public boolean admin() {
        return true;
    }

    @Override
    public void infoCadastro() {
        System.out.println("=== Administrador ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Permissões: " + permissions);
        System.out.println("Endereço: " + endereco);
    }
}
