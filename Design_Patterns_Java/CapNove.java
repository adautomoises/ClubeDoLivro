// GERENCIANDO MUITOS OBJETOS

// Padrão Facade
// Encapsula a complexidade da interação entre os diversos componentes e desacopla o cliente
// das implementações.
// Basicamente, em vez do Cliente fazer chamadas aos subsistemas diretamente, cria-se uma fachada
// que vai isolar essas chamadas, fazendo a coordenação das chamadas e controle das dependências.
// Assim, fica disponível ao Cliente apenas o necessário, simplificando o acesso às funcionalidades.


// Padrão Anti-Corruption Layer
// Propõe a criação de uma camada entre a nova aplicação e o código legado. Traduzindo as chamadas
// da aplicação para o sistema legado. Pode-se usar o Facade para encapsular a lógica do código
// legado. Se há necessidade apenas de invocar as chamadas da classe legada, temos o Adapter.


// Padrão Mediator
// Propõe a criação de uma classe que serve como mediadora entre os objetos.
// Todas as interações entre os objetos passam pelo mediador, fazendo cada objeto receber e enviar
// o necessário. Recomendado quando as relações entre os objetos forem complexas.


// Padrão Flyweight
// Seu objetivo é permitir a representação de um número grande de objetos de forma eficiente.
// Quando se existem diversas instâncias da mesma classe em mémoria que são similares. Tenta
// reutilizar a mesma instância em todos os locais onde há objetos semelhantes sendo usados.
// Os objetos representados devem ser imutáveis.