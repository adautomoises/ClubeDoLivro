// ESTRATÉGIAS DE CRIAÇÃO DE OBJETOS
public class CapSeis {
    public static void main(String[] args) {
        Configuracao configuracao = Configuracao.getInstancia();
    }
}

// Static Factory Method
// Técnica para viabilizar a criação de diferentes instâncias com os mesmos parâmetros passados.

abstract class Cadastro {
    public static final String PESSOA = "PESSOA";
    public static final String ANIMAL = "ANIMAL";

    public static String cadastrarPessoa(String nome) {
        Pessoa pessoa = new Pessoa(nome);
        return pessoa.getNome();
    }

    public static String cadastrarAnimal(String nome) {
        Animal animal = new Animal(nome);
        return animal.getNome();
    }

    public static String cadastrar(String nome, String tipo) throws Exception {
        if (tipo.equals(Cadastro.PESSOA)) {
            return new Pessoa(nome).getNome();
        } else if (tipo.equals(Cadastro.ANIMAL)) {
            return new Animal(nome).getNome();
        }
        throw new Exception();
    }
}

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}


// Padrão Singleton
// Só possui uma única instância de uma classe específica.
// Tem que ter muito cuidado ao usar esse padrão para não se tornar estorvo.

class Configuracao {
    private static Configuracao instancia;

    public static Configuracao getInstancia() {
        if (instancia == null) instancia = new Configuracao();
        return instancia;
    }

    private Configuracao() {
    }
}


// Padrão Builder
// O uso do Builder é mais recomendado quando é a criação do objeto é complexo e exige a
// configuração de diversos parâmetros. Seus métodos devem retornar a instância da própria classe,
// para ser possível encadear os métodos. O uso de "Interface Fluente" é interessante para o Builder.
// Também pode ser útil ao utilizar com Proxy, Decorator, Template Method e Composite.

// Padrão Abstract Factory
// Existe uma família de objetos relacionados e possui métodos para criação de cada um dos
// tipos de objetos da família.