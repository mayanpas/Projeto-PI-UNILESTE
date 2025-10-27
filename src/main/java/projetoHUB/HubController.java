package projetoHUB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class HubController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("mensagem", "Bem-vindo ao Projeto HUB! 🚀");
        response.put("endpoint_demo", "/demo");
        response.put("descricao", "Sistema de Reserva de Ambientes");
        return response;
    }

    @GetMapping("/demo")
    public Map<String, Object> demonstracao() {
        Map<String, Object> resultado = new LinkedHashMap<>();

        try {
            Ambiente ambiente1 = new Ambiente("AMB001", "Sala de Reuniões A", 20, "Sala de Reunião");
            Ambiente ambiente2 = new Ambiente("AMB002", "Auditório Principal", 100, "Auditório");

            DataHora dataHora1 = DataHora.reservaSala("26/10/2025", "09:00", "11:00");
            DataHora dataHora2 = DataHora.reservaSala("27/10/2025", "14:00", "16:00");

            PessoaFisica pessoaFisica1 = new PessoaFisica(1, "João Silva", "joao@email.com", "11-98765-4321", "Rua A, 123", 1990);
            PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Maria Santos", "maria@email.com", "11-91234-5678", "Rua B, 456", 1985);

            PessoaJuridica pessoaJuridica1 = new PessoaJuridica(3, "Tech Solutions Ltda", "tech@empresa.com", "11-3000-0000", "Av. Paulista, 1000", "12.345.678/0001-99", "Tecnologia");
            PessoaJuridica pessoaJuridica2 = new PessoaJuridica(4, "Inovação Corp", "inovacao@empresa.com", "11-3000-1111", "Av. Faria Lima, 2000", "98.765.432/0001-11", "Inovação");

            Administrador admin1 = new Administrador(5, "Carlos Admin", "carlos@hub.com", "11-99999-9999", "Rua Admin, 1", "FULL_ACCESS");
            Administrador admin2 = new Administrador(6, "Ana Gestora", "ana@hub.com", "11-88888-8888", "Rua Gestão, 2", "MANAGER");

            Reserva reserva1 = new Reserva("RES001", ambiente1, pessoaFisica1, dataHora1, 15, "Reunião de planejamento estratégico"
            );

            Reserva reserva2 = new Reserva("RES002", ambiente2, pessoaJuridica1, dataHora2, 80, "Palestra sobre inovação tecnológica"
            );

            Status status1 = reserva1.getStatus();
            Status status2 = reserva2.getStatus();

            resultado.put("Concluído", "✅ Demonstração de todas as classes do Projeto HUB");

            Map<String, Object> ambientes = new LinkedHashMap<>();
            ambientes.put("ambiente1", criarMapAmbiente(ambiente1));
            ambientes.put("ambiente2", criarMapAmbiente(ambiente2));
            resultado.put("ambientes", ambientes);

            Map<String, Object> datas = new LinkedHashMap<>();
            datas.put("dataHora1", criarMapDataHora(dataHora1));
            datas.put("dataHora2", criarMapDataHora(dataHora2));
            resultado.put("datasHoras", datas);

            Map<String, Object> pessoasFisicas = new LinkedHashMap<>();
            pessoasFisicas.put("pessoa1", criarMapPessoaFisica(pessoaFisica1));
            pessoasFisicas.put("pessoa2", criarMapPessoaFisica(pessoaFisica2));
            resultado.put("pessoasFisicas", pessoasFisicas);

            Map<String, Object> pessoasJuridicas = new LinkedHashMap<>();
            pessoasJuridicas.put("empresa1", criarMapPessoaJuridica(pessoaJuridica1));
            pessoasJuridicas.put("empresa2", criarMapPessoaJuridica(pessoaJuridica2));
            resultado.put("pessoasJuridicas", pessoasJuridicas);

            Map<String, Object> administradores = new LinkedHashMap<>();
            administradores.put("admin1", criarMapAdministrador(admin1));
            administradores.put("admin2", criarMapAdministrador(admin2));
            resultado.put("administradores", administradores);

            Map<String, Object> reservas = new LinkedHashMap<>();
            reservas.put("reserva1", criarMapReserva(reserva1));
            reservas.put("reserva2", criarMapReserva(reserva2));
            resultado.put("reservas", reservas);

            Map<String, Object> statuses = new LinkedHashMap<>();
            statuses.put("status1", criarMapStatus(status1));
            statuses.put("status2", criarMapStatus(status2));
            resultado.put("statusReservas", statuses);

        } catch (Exception e) {
            resultado.put("erro", "⚠️ Erro ao criar demonstração: " + e.getMessage());
            resultado.put("detalhes", e.getClass().getSimpleName());
        }

        return resultado;
    }

    private Map<String, Object> criarMapAmbiente(Ambiente ambiente) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "Ambiente");
        map.put("id", ambiente.getId());
        map.put("nome", ambiente.getNome());
        map.put("capacidade", ambiente.getOcupacaoMaxima());
        map.put("tipoAmbiente", ambiente.getTipo());
        return map;
    }

    private Map<String, Object> criarMapDataHora(DataHora dataHora) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "DataHora");
        map.put("data", dataHora.getData().toString());
        map.put("horaEntrada", dataHora.getHoraEntrada().toString());
        map.put("horaSaida", dataHora.getHoraSaida().toString());
        return map;
    }

    private Map<String, Object> criarMapPessoaFisica(PessoaFisica pessoa) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "PessoaFisica");
        map.put("id", pessoa.getId());
        map.put("nome", pessoa.getNome());
        map.put("email", pessoa.getEmail());
        map.put("telefone", pessoa.getTelefone());
        map.put("endereco", pessoa.getEndereco());
        map.put("dataNascimento", pessoa.getDataNascimento());
        return map;
    }

    private Map<String, Object> criarMapPessoaJuridica(PessoaJuridica empresa) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "PessoaJuridica");
        map.put("id", empresa.getId());
        map.put("nome", empresa.getNome());
        map.put("email", empresa.getEmail());
        map.put("telefone", empresa.getTelefone());
        map.put("endereco", empresa.getEndereco());
        map.put("cnpj", empresa.getCnpj());
        map.put("areaAtuacao", empresa.getAreaAtuacao());
        return map;
    }

    private Map<String, Object> criarMapAdministrador(Administrador admin) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "Administrador");
        map.put("id", admin.getId());
        map.put("nome", admin.getNome());
        map.put("email", admin.getEmail());
        map.put("telefone", admin.getTelefone());
        map.put("endereco", admin.getEndereco());
        map.put("permissions", admin.getPermissions());
        return map;
    }

    private Map<String, Object> criarMapReserva(Reserva reserva) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "Reserva");
        map.put("id", reserva.getId());
        map.put("ambiente", reserva.getAmbiente().getNome());
        map.put("usuario", reserva.getUsuario().getNome());
        map.put("quantidadePessoas", reserva.getQuantidadePessoas());
        map.put("finalidade", reserva.getFinalidade());
        map.put("status", reserva.getStatus().getStatusAprovacao());
        return map;
    }

    private Map<String, Object> criarMapStatus(Status status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("tipo", "Status");
        map.put("statusAprovacao", status.getStatusAprovacao());
        return map;
    }
}