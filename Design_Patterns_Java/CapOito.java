import java.util.List;
import java.util.Map;
import java.util.Set;

// ADICIONANDO OPERAÇÕES
public class CapOito {
    public static void main(String[] args) {

    }
}

// Padrão Command
// Uma Operação como uma Classe. Muito recomendado para adicionar novas operações ao software.

interface ComandoCarrinho {
    Object executar();
}

interface CienteDosProdutos {
    void setListaProdutos(List<Produto> produtos);
}

interface CienteDoUsuario {
    void setUsuario(Usuario usuario);
}

class Produto {
    private boolean digital;
    private double tamanho;

    protected double getTamanhoDownload() {
        return this.tamanho;
    }

    protected boolean isDigital() {
        return this.digital;
    }
}

class Usuario {
}

class ComandoNaoEncontradoException extends Exception {
    public ComandoNaoEncontradoException() {
        super();
    }
}

class CarrinhoCompras {
    private Map<String, ComandoCarrinho> comandos;
    private List<Produto> produtos;
    private Usuario usuario;

    public Object executaComando(String nomeComando) throws ComandoNaoEncontradoException {
        ComandoCarrinho c = comandos.get(nomeComando);
        if (c == null) throw new ComandoNaoEncontradoException();
        if (c instanceof CienteDosProdutos) ((CienteDosProdutos) c).setListaProdutos(produtos);
        if (c instanceof CienteDoUsuario) ((CienteDoUsuario) c).setUsuario(usuario);
        return c.executar();
    }

    public Set<String> getComandosDisponiveis() {
        return comandos.keySet();
    }
}

class TamanhoParaDownload implements ComandoCarrinho, CienteDosProdutos {
    private List<Produto> produtos;

    public void setListaProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Object executar() {
        double tamanho = 0;
        for (Produto p : produtos) {
            if (p.isDigital()) {
                tamanho += p.getTamanhoDownload();
            }
        }
        return tamanho;
    }
}


// Padrão Double Dispatch
// A classe despachante passa a si mesmo na chamada de retorno do método recebido no parâmetro.
// Recomendado quando deseja-se acrescentar novas operações em uma classe de forma dinâmica.


// Padrão Visitor
// Utiliza-se do Double Dispatch como parte da sua solução. Ambos usam o recurso de delegar a sua
// execução, ou parte dela, para o objeto passado como parâmetro. Difícil de explicar.
// Quando há um problema de muitos para muitos, por exemplo, gerações de diferentes relatórios
// para diferentes formatos arquivo. É possível implementar uma interface Visitante responsável
// pelos métodos do relatório (getTitulo, getFooter...) a serem implementados, e outra interface
// fica responsável por cada formato aceitar um visitante. Facilitando gerar um novo relatório,
// bastando implementar os métodos, porém, cada formato novo deve ser adicionado aos visitantes.
