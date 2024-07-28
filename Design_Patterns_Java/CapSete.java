import java.sql.Connection;

// MODULARIDADE
public class CapSete {
    public static void main(String[] args) {
    }
}

// Padrão Dynamic Factory
// Um padrão da categoria de criação, assim como, Builder, Static Factory... Usando um arquivo de
// configuração é possível criar instâncias de uma classe dinamicamente, com o Dynamic Factory.

// Reflexão é a capacidade de um sistema executar computações a respeito de si mesmo.
// Obter informações, acessar e modificar suas próprias classes.


// Padrão Dependency Injection
// Visa tornar a classe mais reutilizável, desacoplando a classe de suas dependências.
// Há várias formas de injeção de dependências, usando um "Setter" ou o construtor, mais indicado
// quando a dependência é obrigatória ou essencial para a classe.


class AcessarDados {
    private Connection connection;

    public AcessarDados(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

// Exemplo de injeção por interface, caso implemente a interface a dependência é injetada.
//interface CadastroUsuario {
//    void recebeUsuario(Usuario u);
//}
//
//class Usuario {
//}
//
//class CadastrarUsuario implements Executor {
//    private Executor executor;
//    private Usuario usuario;
//
//    public CadastrarUsuario(Executor e, Usuario u) {
//        this.executor = e;
//        this.usuario = u;
//    }
//
//    @Override
//    public void execute(Runnable command) {
//        if (command instanceof CadastroUsuario) {
//            ((CadastroUsuario) command).recebeUsuario(usuario);
//        }
//        executor.execute(command);
//    }
//}

// Padrão Service Locator
// Alternativa ao Dependency Injection. As próprias classes são
// responsáveis por buscar as suas dependências utilizando outra classe que localiza a
// implementação a ser utilizada de acordo com sua interface. Uma classe presta "serviço" a outra.

// Exemplo utilizando o ServiceLoader para injetar as dependências
//class AcessarDadosComServiceLoader {
//    private ConnectionComposto connection;
//
//    public AcessarDadosComServiceLoader() {
//        ServiceLoader<Connection> serviceLoader = ServiceLoader.loadInstalled(Connection.class);
//        Iterator<Connection> iterator = serviceLoader.iterator();
//        List<Connection> connectionList = new ArrayList<>();
//
//        while (iterator.hasNext()) {
//            connectionList.add(iterator.next());
//        }
//        if(connectionList.size() == 1) {
//            connection = (ConnectionComposto) connectionList.get(0);
//        } else if (connectionList.size() > 1) {
//            connection = new ConnectionComposto(connectionList);
//        }
//    }
//}
//
//class ConnectionComposto {
//    private List<Connection> connectionList;
//
//    public ConnectionComposto(List<Connection> connectionList) {
//        this.connectionList = connectionList;
//    }
//}