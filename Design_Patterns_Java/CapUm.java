//  ENTENDENDO PADRÕES DE PROJETO
public class CapUm {
    public static void main(String[] args) {
        Financeiro financeiro = new Financeiro();

        financeiro.realizarVenda(new Gerente());
        financeiro.realizarVenda(new Funcionario());
    }
}

// # Classes e Objetos
// Classe é um conjunto de características (atributos e métodos) que representam algo.
// Enquanto um objeto é a atribuição dessas características, com valores e comportamentos.
// Por exemplo, uma classe Pessoa com atributos de nome e idade,
// e um método "contarPiada()". Um objeto instanciado dessa classe seria
// Pessoa pessoa = new Pessoa("Adauto", 22);
// E o método contarPiada(), seria:
// public String contarPiada(){
//   System.out.println("Piu");
// }


// # Herança
// Da mesma forma que existe uma classe Pessoa, podemos criar a classe Cachorro.
// Então para abstrair mais, criar uma classe SerVivo, assim a classe Pessoa/Cachorro herda
// atributos e comportamentos da classe SerVivo.


// # Encapsulamento
// Graças a isso, é possível eu manter uma separação entre "uso" e "funcionamento".
// Hoje eu posso usar um método que retorne x valores e em 10 anos esse mesmo método
// retornar os mesmos valores mesmo que a implementação/consulta/tecnologia tenha sofrido
// alterações ao longo dos anos.

// INTERFACE OU CLASSE ABSTRATA?
// "Quando a abstração que precisar ser criada for um conceito –
// ou seja, algo que possa ser refinado e especializado –, deve-se
// utilizar uma classe abstrata. Quando a abstração é um
// comportamento – algo que uma classe deve saber fazer –,
// então a melhor solução é a criação de uma interface."


// # Polimorfismo
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

