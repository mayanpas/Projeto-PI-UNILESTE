package projetoHUB;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataHora {
    private LocalDate dataReserva;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public DataHora(LocalDate dataReserva, LocalTime horaEntrada, LocalTime horaSaida) {
        this.dataReserva = dataReserva;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public static DataHora reservaSala(String dataStr, String horaEntradaStr, String horaSaidaStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate data = LocalDate.parse(dataStr, dateFormatter);
        LocalTime entrada = LocalTime.parse(horaEntradaStr, timeFormatter);
        LocalTime saida = LocalTime.parse(horaSaidaStr, timeFormatter);

        return new DataHora(data, entrada, saida);
    }

    // Getters
    public LocalDate getData() {
        return dataReserva;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    @Override
    public String toString() {
        return "Data: " + dataReserva + ", Horário: " + horaEntrada + " - " + horaSaida;
    }
}
