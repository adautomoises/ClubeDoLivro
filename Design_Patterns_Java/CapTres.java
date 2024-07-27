import java.util.ArrayList;
import java.util.List;

// DELEGANDO COMPORTAMENTO COM COMPOSIÇÃO
public class CapTres {
    public static void main(String[] args) {
        ObsUm obsUm = new ObsUm();
        ObsDois obsDois = new ObsDois();
        ClasseObservada classeObservada = new ClasseObservada();
        classeObservada.addObservador(obsUm);
        classeObservada.addObservador(obsDois);
        classeObservada.fazerAlgo("observadores");
    }
}

// Padrão Bridge
// O padrão brigde utiliza-se da Herança e a Composição para permitir o desacoplamento
// de responsabilidades, como assim? Ele cria uma "ponte" entre hieraquias com composição,
// no exemplo do livro, temos uma hieraquia de abstração e outra de implementação. Uma classe
// com algoritmo para gerar arquivo, as suas subclasses podem se especializar em gerar arquivos
// de formatos diferentes e nas implementações podemos ter um pós-processamento ou não, sem
// necessariamente definir uma implementação, graças ao Null Object e Hook Classes.

// Hook Classes
// Não é o mesmo que hook methods. Basicamente, em vez do método da classe principal ser
// especializada numa subclasse, vai existir uma relação de composição entre a classe principal
// e a classe gancho, onde as subclasses da classe gancho vão extendê-la e assim, a classe
// principal fica livre para decidir qual método utilizar trocando as instâncias


// Padrão State
// Basicamente só mantem a lógica na entidade e cada subclasse da interface terá seu comportamento
// especializado, permitindo alterar o comportamento da entidade só trocando a instância,
// alterando seu estado.


// Padrão Observer
// No padrão observer, temos classes que são observadas e classes que observam, resumidamente.
// Todos os observadores de uma classe são notificados quando ocorre alguma alteração na classe
// que observam. Existem muitos pontos a serem considerados, por exemplo, cada observador pode
// ser notificado de uma thread diferente, ou se um tiver exceção, o que ocorre com os outros?
// Também podemos considerar ter notificações diferentes para cada alteração...

interface Observador {
    void ocorreuMudanca(String algo);
}

class ClasseObservada {
    private final List<Observador> observadores = new ArrayList<>();

    public void fazerAlgo(String algo) {
        // Execução
        notificar(algo);
    }

    public void notificar(String algo) {
        for (Observador observador : observadores)
            observador.ocorreuMudanca(algo);
    }

    public void addObservador(Observador observador) {
        observadores.add(observador);
    }
}

class ObsUm implements Observador {
    @Override
    public void ocorreuMudanca(String algo) {
        System.out.println("ObsUm: " + algo);
    }
}

class ObsDois implements Observador {
    @Override
    public void ocorreuMudanca(String algo) {
        System.out.println("ObsDois: " + algo);
    }
}