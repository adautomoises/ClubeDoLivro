// DELEGANDO COMPORTAMENTO COM COMPOSIÇÃO
public class Main {
    public static void main(String[] args) {

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
// Não é a mesma coisa que hook methods. Basicamente, em vez do método da classe principal ser
// especializada numa subclasse, vai existir uma relação de composição entre a classe principal
// e a classe gancho, onde as subclasses da classe gancho vão extendê-la e assim, a classe
// principal fica livre pra decidir qual método utilizar trocando as instâncias


// Padrão State