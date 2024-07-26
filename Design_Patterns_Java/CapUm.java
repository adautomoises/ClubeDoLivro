// ENTENDENDO PADRÕES DE PROJETO
public class CapUm {
  public static void main(String[] args){
    Financeiro financeiro = new Financeiro();

    financeiro.realizarVenda(new Gerente());
    financeiro.realizarVenda(new Funcionario());
  }
}

class Gerente implements Vendedor {
  @Override
  public void realizarVenda() {
    System.out.println("Gerente vendeu");
  }
}

class Funcionario implements Vendedor {
  @Override
  public void realizarVenda() {
    System.out.println("Funcionario vendeu");
  }
}

class Financeiro {
  public void realizarVenda(Vendedor vendedor) {
    vendedor.realizarVenda();
  }
}

interface Vendedor {
  void realizarVenda();
}

