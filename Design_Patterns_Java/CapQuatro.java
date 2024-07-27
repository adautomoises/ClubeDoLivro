import java.util.Objects;

// COMPOSIÇÃO RECURSIVA
public class CapQuatro {
    public static void main(String[] args) {
        System.out.println(fatorial(5) + "\n");

        TrechoSimples trechoSimples1 = new TrechoSimples("Fortaleza", "Recife", 300);
        TrechoSimples trechoSimples2 = new TrechoSimples("Recife", "Natal", 150);
        TrechoComposto trechoComposto = new TrechoComposto(trechoSimples1, trechoSimples2, 10);

        System.out.println("Ponto de partida: " + trechoComposto.getOrigem());
        System.out.println("Destino final: " + trechoComposto.getDestino());
        System.out.println("Custo total: " + trechoComposto.getPreco());
    }

    public static int fatorial(int n) {
        if (n == 1) return 1;
        return n * fatorial(n - 1);
    }
}

// Um algortimo recursivo chama a si mesma como parte da sua lógica, reduzindo o problema até
// que satisfaça a condição de parada (ponto de parada).
// O algoritmo que calcula o fatorial pode ser desenvolvido com recursão. Outro exemplo, seria
// um método que conta quantos elementos uma lista ligada possui, indo de "próximo em próximo"
// até o último elemento não ter um próximo.


// Padrão Composite
// Permite uma abstração ser utilizar tanto para uma instância simples quanto para uma composta.
// Criando uma interface que implementada por uma classe simples e também uma classe composta
// do mesmo conceito, por exemplo, um trecho aéreo simples (uma viagem de um ponto a outro),
// já o trecho aéreo composto faz conexões e deve ter seu devido tratamento especializado,
// onde suas conexões também são trechos simples ou compostos.

interface TrechoAereo {
    public String getOrigem();

    public String getDestino();

    public double getPreco();
}

class TrechoSimples implements TrechoAereo {
    private String origem;
    private String destino;
    private double preco;

    public TrechoSimples(String origem, String destino, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }
}

class TrechoComposto implements TrechoAereo {
    private TrechoAereo primeiro;
    private TrechoAereo segundo;
    private double taxaConexao;

    public TrechoComposto(TrechoAereo primeiro, TrechoAereo segundo, double taxaConexao) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.taxaConexao = taxaConexao;
        if (!Objects.equals(primeiro.getDestino(), segundo.getOrigem()))
            throw new RuntimeException("O destino do primeiro não é igual a origem do segundo");
    }

    public String getOrigem() {
        return primeiro.getOrigem();
    }

    public String getDestino() {
        return segundo.getDestino();
    }

    public double getPreco() {
        return primeiro.getPreco() + segundo.getPreco() + taxaConexao;
    }
}


// Chain of Responsibility
// Uma sequência de processamentos, utilizando de lista ligada para verificar se tem um próximo
// e então delegando a tarefa caso necessário. Ou podendo encerrar a execução com alguma exceção
// Um exemplo seria o processo de busca de um dado, primeiro verifica na memória, depois no
// banco de dados, caso não encontre, recupera no servidor remoto.
