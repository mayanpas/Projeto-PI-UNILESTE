package projetoHUB;
import java.time.LocalTime;

public class Reserva {
    private String id;
    private Ambiente ambiente;
    private Usuario usuario;
    private DataHora dataReserva;
    private int quantidadePessoas;
    private String finalidade;
    private Status status;

    public Reserva(String id, Ambiente ambiente, Usuario usuario, DataHora dataReserva,
                   int quantidadePessoas, String finalidade) {
        this.id = id;
        this.ambiente = ambiente;
        this.usuario = usuario;
        this.dataReserva = dataReserva;
        this.quantidadePessoas = quantidadePessoas;
        this.finalidade = finalidade;
        this.status = new Status("PENDENTE", this);
    }

    public static Reserva reservar(String id, Ambiente ambiente, Usuario usuario, DataHora dataReserva,
                                   int quantidadePessoas, String finalidade) {
        if (!ambiente.verificarDisponibilidade(dataReserva)) {
            throw new IllegalArgumentException("Ambiente não disponível para o horário selecionado");
        }

        if (quantidadePessoas > ambiente.getOcupacaoMaxima()) {
            throw new IllegalArgumentException("Quantidade de pessoas excede a capacidade máxima do ambiente");
        }

        Reserva reserva = new Reserva(id, ambiente, usuario, dataReserva, quantidadePessoas, finalidade);
        ambiente.addReserva(reserva);
        usuario.addReserva(reserva);

        return reserva;
    }

    public boolean conflitoHorario(LocalTime inicio, LocalTime fim) {
        return !(dataReserva.getHoraSaida().isBefore(inicio) || dataReserva.getHoraEntrada().isAfter(fim));
    }

    public String getId() {
        return id;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public DataHora getDataReserva() {
        return dataReserva;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id='" + id + '\'' + ", ambiente=" + ambiente.getNome() + ", usuario=" + usuario.getNome() +
                ", dataHora=" + dataReserva + ", pessoas=" + quantidadePessoas + ", finalidade='" + finalidade +
                '\'' + ", status=" + status.getStatusAprovacao() + '}';
    }
}