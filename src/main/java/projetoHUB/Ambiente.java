package projetoHUB;


import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String id;
    private String nome;
    private int ocupacaoMaxima;
    private String tipo;
    private boolean disponibilidade;
    private List<Reserva> reservas;

    public Ambiente(String id, String nome, int ocupacaoMaxima, String tipo) {
        this.id = id;
        this.nome = nome;
        this.ocupacaoMaxima = ocupacaoMaxima;
        this.tipo = tipo;
        this.disponibilidade = true;
        this.reservas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOcupacaoMaxima() {
        return ocupacaoMaxima;
    }

    public void setOcupacaoMaxima(int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public boolean verificarDisponibilidade(DataHora dataHora) {
        for (Reserva reserva : reservas) {
            if (reserva.getDataReserva().getData().equals(dataHora.getData()) &&
                    reserva.conflitoHorario(dataHora.getHoraEntrada(), dataHora.getHoraSaida())) {
                return false;
            }
        }
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + ", capacidade=" + ocupacaoMaxima +
                ", tipo='" + tipo + '\'' + ", disponível=" + disponibilidade + '}';
    }
}
