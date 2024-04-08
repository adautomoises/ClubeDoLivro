// ENTENDENDO PADRÕES DE PROJETO
public class Main {
  public void main(String[] args){
    Financeiro financeiro = new Financeiro();

    financeiro.realizarVenda(new Gerente());
    financeiro.realizarVenda(new Funcionario());
  }

  public class Gerente implements Vendedor {
    @Override
    public void realizarVenda() {
      System.out.println("Gerente vendeu");
    }
  }

  public class Funcionario implements Vendedor {
    @Override
    public void realizarVenda() {
      System.out.println("Funcionario vendeu");
    }
  }

  public class Financeiro {
    public void realizarVenda(Vendedor vendedor) {
      vendedor.realizarVenda();
    }
  }

  public interface Vendedor {
    void realizarVenda();
  }
}

