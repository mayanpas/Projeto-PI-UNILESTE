package projetoHUB;


public class PessoaJuridica extends Usuario {
    private String cnpj;
    private String areaAtuacao;

    public PessoaJuridica(int id, String nome, String email, String telefone, String endereco, String cnpj, String areaAtuacao) {
        super(id, nome, email, telefone, endereco);
        this.cnpj = cnpj;
        this.areaAtuacao = areaAtuacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public boolean pessoaJuridica() {
        return true;
    }

    @Override
    public boolean admin() {
        return false;
    }

    @Override
    public void infoCadastro() {
        System.out.println("=== Pessoa Jurídica ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Área de Atuação: " + areaAtuacao);
        System.out.println("Endereço: " + endereco);
    }
}
