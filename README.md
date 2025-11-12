QUESTÃO 1: 
Contexto: Você está desenvolvendo um sistema de processamento de dados para uma empresa financeira que lida com diferentes tipos de análise de risco. O sistema precisa calcular métricas de risco usando diferentes algoritmos (Value at Risk, Expected Shortfall, Stress Testing) que podem mudar dinamicamente durante a execução.

Problema:
- Cada algoritmo de risco deve ser intercambiável em tempo de execução 
- Os algoritmos devem ser capazes de compartilhar um contexto complexo com múltiplos parâmetros financeiros
- Deve ser possível trocar de algoritmo de acordo com a necessidade de negócios
  
Restrições:
- O cliente deve poder mudar de algoritmo sem conhecer os detalhes de implementação
- Implemente pelo menos 3 algoritmos diferentes com cálculos dummy (podem ser mensagens de texto) distintos

Justificativa das Decisões de Design:

Strategy Pattern: O uso do padrão Strategy permite que os algoritmos de risco sejam intercambiáveis de forma simples e eficaz. 
O cliente pode alterar o algoritmo de risco sem precisar entender sua implementação, o que atende à restrição de não expor os detalhes internos dos algoritmos.

Dependency Injection (DIP): A classe RiskCalculatorContext depende de uma abstração (RiskAlgorithm), e não de uma implementação concreta. Isso permite que o sistema seja facilmente extensível com novos algoritmos de risco sem alterar o código existente.

Factory Method: A RiskCalculatorFactory centraliza a criação de instâncias de algoritmos de risco, promovendo a flexibilidade na escolha do algoritmo, além de garantir que o cliente não precise se preocupar com a instância concreta do algoritmo.

Single Responsibility Principle (SRP): Cada classe tem uma responsabilidade bem definida:

RiskAlgorithm: Define o comportamento comum dos algoritmos.

RiskContext: Armazena os dados financeiros.

RiskCalculatorContext: Controla a troca de algoritmos de risco.

RiskCalculatorFactory: Cria instâncias de algoritmos de risco.

Conclusão:

Este design segue os princípios SOLID e utiliza padrões de design adequados para resolver o problema de cálculo dinâmico de risco, garantindo flexibilidade, extensibilidade e manutenção do código de forma eficiente.




QUESTÃO 2:
Contexto: Sua empresa está integrando com um legado bancário que possui uma interface complexa para processamento de transações. A interface legada `SistemaBancarioLegado` possui métodos com assinaturas incompatíveis e usa tipos de dados obsoletos.

Problema:

- Converter a interface atualizada ProcessadorTransacoes (com métodos autorizar(String cartao, double valor, String moeda)) para a interface legada

- O sistema legado usa: processarTransacao(HashMap<String, Object> parametros)

- Implemente de forma que o funcionamento seja bidirecional, ou seja, que também permita converter respostas do legado para o formato atualizado

- Adicione tratamento para campos obrigatórios do legado que não existem na interface moderna (ao menos um)



Restrições:

- O legado exige codificação específica para moedas (USD=1, EUR=2, BRL=3)

Justificativa das Decisões de Design:

Adapter Pattern:

O padrão Adapter foi escolhido para permitir que a interface moderna (ProcessadorTransacoes) se comunique com a interface legada (SistemaBancarioLegado). O Adapter realiza a conversão dos parâmetros e garante que o sistema moderno e o legado consigam interagir sem a necessidade de mudar as implementações originais.

Tratamento de Moeda:

A conversão de moedas é feita através de um método que mapeia a string da moeda para o código esperado pelo sistema legado (1 = USD, 2 = EUR, 3 = BRL). Isso resolve a exigência do legado de usar códigos específicos para as moedas.

Campo Obrigatório do Legado:

Um campo adicional, como dataTransacao, foi incluído no HashMap para representar um campo obrigatório que o legado exige, mas que não está presente na interface moderna.

Codificação Flexível:

O código da moeda é feito de forma extensível, ou seja, se for necessário adicionar mais moedas no futuro, basta incluir novos casos no método codificarMoeda.

Conclusão:

A solução proposta usa o Adapter Pattern para integrar o sistema moderno com o legado de forma bidirecional. Ela resolve os problemas de incompatibilidade de assinaturas de métodos e tipos de dados, além de garantir que o sistema legado tenha os parâmetros e os tratamentos necessários (como a codificação de moedas e campos obrigatórios). Com essa abordagem, é possível alterar o sistema legado sem modificar a interface moderna, mantendo a flexibilidade e a extensibilidade do sistema.



QUESTÃO 3:
Contexto: Você está modelando um sistema de controle para uma usina nuclear com estados complexos de operação. A usina pode estar em: DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGENCIA.

Problema:

- Cada transição de estado deve validar condições complexas (temperatura, pressão, nível de radiação)

- Algumas transições são bidirecionais, outras são unidirecionais

- Previna transições circulares perigosas

- O estado EMERGENCIA só pode ser ativado após passar por ALERTA_VERMELHO

- Adicione um modo "manutenção" que sobreescreva temporariamente os estados normais



Regras:

- OPERACAO_NORMAL → ALERTA_AMARELO: se temperatura > 300°C

- ALERTA_AMARELO → ALERTA_VERMELHO: se temperatura > 400°C por mais de 30 segundos

- ALERTA_VERMELHO → EMERGENCIA: se sistema de resfriamento falhar

Justificativa do Design

State Pattern: O uso do padrão State é adequado aqui porque a usina possui estados bem definidos com regras de transição entre eles. Cada estado encapsula sua própria lógica de transição, facilitando a manutenção e extensão do código.

Condições de Transição: Cada transição de estado é validada de forma independente, e o comportamento da usina depende das condições atuais, como temperatura e radiação.

Modo Manutenção: O modo manutenção funciona como um bloque


Questão 4 - Sistema de Validação de Documentos
Descrição
Contexto
Desenvolva um sistema de validação de documentos fiscais eletrônicos (NF-e) que precisa aplicar múltiplas regras de validação em cadeia.

Problema
Cada validador especializado verifica um aspecto específico do documento
A cadeia deve suportar validações condicionais (se validador X falhar, pule Y)
Implemente um mecanismo de "circuit breaker" que interrompa a cadeia após 3 validações falharem
Adicione capacidade de rollback para validadores que modificam o documento
Validadores Requeridos
Validador de Schema XML contra XSD
Validador de Certificado Digital (expiração e revogação)
Validador de Regras Fiscais (cálculo de impostos)
Validador de Banco de dados (duplicidade de número)
Validador de Serviço SEFAZ (consulta online)
Restrições
Os validadores 3 e 5 devem ser executados apenas se os anteriores passarem
O validador 4 deve fazer rollback da inserção se validações subsequentes falharem
Implemente timeout individual para cada validador
Justificativa do Padrão
Decidi aplicar o padrão de projeto Chain of Responsibility, porque distribui a responsabilidade entre vários objetos de forma sequencial. Além disso, evita código com muitos if/else encadeados. Dessa forma, consigo dividir de forma adequada as validações por tipo, seguindo o princípio da Responsabilidade Única (SRP) do SOLID, e, por conta disso, agilizar operações de rollback por meio do conhecimento indivual de cada tipo de validação.
