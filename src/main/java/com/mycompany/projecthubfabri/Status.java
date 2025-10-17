/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecthubfabri;

public class Status {
    private String idStatus;
    private String reservaId;
    private String administratorId;
    private String statusAprovacao; // "APROVADO", "PENDENTE", "REJEITADO"

    public Status(String statusAprovacao, Reserva reserva) {
        this.idStatus = "STATUS_" + reserva.getId();
        this.reservaId = reserva.getId();
        this.statusAprovacao = statusAprovacao;
    }

    public void aprovar(Administrador administrador) {
        this.statusAprovacao = "APROVADO";
        this.administratorId = String.valueOf(administrador.getId());
    }

    public void rejeitar(Administrador administrador) {
        this.statusAprovacao = "REJEITADO";
        this.administratorId = String.valueOf(administrador.getId());
    }

    // Getters
    public String getIdStatus() { return idStatus; }
    public String getReservaId() { return reservaId; }
    public String getAdministratorId() { return administratorId; }
    public String getStatusAprovacao() { return statusAprovacao; }

    public Reserva reservar() {
        // Este método parece estar no diagrama mas a lógica está na classe Reserva
        System.out.println("Método reservar - implementação na classe Reserva");
        return null;
    }
}
