package projetoHUB;


public class Status {
    private String idStatus;
    private String reservaId;
    private String administratorId;
    private String statusAprovacao;

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

    public String getIdStatus() { return idStatus; }
    public String getReservaId() { return reservaId; }
    public String getAdministratorId() { return administratorId; }
    public String getStatusAprovacao() { return statusAprovacao; }

    public Reserva reservar() {
        System.out.println("Método reservar - implementação na classe Reserva");
        return null;
    }
}
