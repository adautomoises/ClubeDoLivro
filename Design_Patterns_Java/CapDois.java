import java.math.BigDecimal;

public class CapDois {
    public static void main(String[] args) {
        ClasseSecundaria classeSecundaria = new ClasseSecundaria();
        classeSecundaria.metodoGacho();

        ClasseAbstrata c = new ClasseConcreta();
        c.metodoTemplate();
    }
}

// Padrão Null Object
class Carrinho {
    BigDecimal valor;
    Integer tamanho;
    String nomeUsuario;
}

class CarrinhoNulo extends Carrinho {
    public double getValor() {
        return 0.0;
    }

    public int getTamanho() {
        return 0;
    }

    public String getNomeUsuario() {
        return "<a	href=login.jsp>Login</a>";
    }
}

// Esse padrão me deixou um pouco confuso... pesquisando encontrei outro exemplo, porém,
// usando interface, então me questionei se era pra ser implementação ou extensão da classe
// e em um artigo dizia que a intenção do padrão é fornecer uma alternativa ao objeto original,
// seja implementando a mesma interface ou estendendo a mesma classe.

// Hook Methods
abstract class ClassePrincipal {
    public abstract void metodoGacho();

    public void metodoPrincipal() {
        // Execução antes do gancho
        metodoGacho();
        // Execução depois do gancho
    }
}

class ClasseSecundaria extends ClassePrincipal {
    @Override
    public void metodoPrincipal() {
        super.metodoPrincipal();
    }

    @Override
    public void metodoGacho() {
        System.out.println("classe secundaria");
    }
}


// Padrão Template Method
// O padrão Template Method aproveita-se dos hook methods, com partes do algoritmo
// sendo fixas e outras partes variáveis.

abstract class ClasseAbstrata {
    public abstract void metodoTemplate();
}

class ClasseConcreta extends ClasseAbstrata {
    @Override
    public void metodoTemplate() {
        // hook method
        System.out.println("Método Template");
    }
}

// Serializando	propriedades em	arquivos

// Com o Template Method, uma classe que possui um método que invoca outros métodos abstratos,
// definimos um algoritmo base a ser seguido nesse método, deixando os métodos abstratos para
// serem implementados nas subclasses, permitindo a extensão do algoritmo base.


// Padrão Factory Method