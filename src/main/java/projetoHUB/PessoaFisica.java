package projetoHUB;


public class PessoaFisica extends Usuario {
    private int dataNascimento;

    public PessoaFisica(int id, String nome, String email, String telefone, String endereco, int dataNascimento) {
        super(id, nome, email, telefone, endereco);
        this.dataNascimento = dataNascimento;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean pessoaJuridica() {
        return false;
    }

    @Override
    public boolean admin() {
        return false;
    }

    @Override
    public void infoCadastro() {
        System.out.println("=== Pessoa Física ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Endereço: " + endereco);
    }
}
