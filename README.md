# Dikastis Android

Criado por:

- Daniel Bastos - dmrb2
- Rodrigo Rodrigues - rfrl


## Geral

Esse repositório está relacionado com uma aplicação Android implementada para auxiliar professores na checagem de submissões e de código dos seus alunos.

Ele pode navegar livremente por as páginas, que serão discutidas mais tarde nesse README, e assim ir acompanhando o desempenho de seus alunos em diferentes turmas e dar feedbacks compartilhando audio através do próprio aplicativo (enquanto ele analisa a submissão do seu aluno).

## Modelo Arquitetural

O modelo arquitetural utilizado para o desenvolvimento foi o MVVM onde cada activity possui um controlador de estados relacionadas a ela, para fazer calculo das regras de negócio e também acessar o repositório para buscar os dados que devem ser msotrados em tela.

## Data fetching

Os dados que serão vistos em tela estão todos sendo buscado em uma API de suporte que criamos para conseguir visualizar o comportamento do nosso aplicativo. Assim, eles representam situações fictícias que não representam os dados reais da plataforma Dikastis (porque no momento de desenvolvimento não exisitam as rotas disponíveis na API ainda).

Para facilitar no acesso a essa API a aplicação utiliza do Retrofit para realizar as chamadas HTTP e Jackson no parseamento dos JSON para os objetos que utilizamos como model no nosso App.

## Telas

### Main

Esse é a primeira tela do aplicativo, de cara o usuario pode ver uma lista de organizações do dikastis que ele tem acesso e alguns detalhes sobre ela.

A lista de organizações foi feita utilizando um RecyclerView e possui detalhes como nome, numero de membros e numero de administradores, quando um deles é clicado o professor será redirecionado para a tela de `Organization` onde verá mais detalhes.

### Organization

A Organization Activity é uma tela onde o professor pode ver os times definidos para a organization selecionada anteriormente.

A lista de times foi feita utilizando um RecyclerView e quando um deles é clicado o professor será redirecionado para a tela de `Team` onde verá mais detalhes.

### Team

A Team Activity é uma tela onde o professor pode ver as tarefas definidas para o time selecionado.

A lista de tarefas foi feita utilizando um RecyclerView e quando um deles é clicado o professor será redirecionado para a tela de `Task` onde verá mais detalhes.

### Task

A Task Activity é uma tela onde o professor pode ver o andamento da tarefa selecionada anteriormente em uma visão individualizada por aluno.

A lista de alunos foi feita utilizando RecyclerView e possui as informações de quantas das questões da tarefa foram respondidas por ele, alem disso temos um Spinner que seleciona uma certa questão da tarefa de um aluno e pode acompanhar mais detalhes sendo redirecionado para a tela de `Problem`.

### Overview

O Overview Activity é uma tela onde o professor pode ver os detalhes agrupados da tarefa passada, apresentando um grafico com o numero de estudantes que tentaram(fizeram uma submissão) e que finalizaram(acertaram o problema).

Ele foi implementado utilizando a biblioteca [AAChartModel](https://github.com/AAChartModel/AAChartCore-Kotlin) que desenha a tela e forma o grafico dados os dados que foram fornecidos pela API.

### Problem

A Problem Activity é uma tela onde o professor pode ver detalhes de como o aluno está performando em um determinado problema.

Atravez de uma RecyclerView horizontal o professor pode seleciona entre as submissões do aluno, podendo vizualizar o status final daquela solução com um icone indicativo e ao ser clicado mais detalhes aparecem na tela, como a linguagem da submissão, tempo de execução e o codigo submetido.

Os novos detalhes aparecem na tela atravez de um broadCast que é gerado pelo item da RecyclerView clicado e é recebido pela Activity, criando então os demais dados referentes a submissão selecionada.

O professor tambem tem a opção de gravar um audio para o aluno diretamente do aplicativo, esse audio é capturado por um MediaRecorder e as permissões necessarias são solicitadas quando o botão `Start` é precionado. É possivem tambem dar `Pause` e `Resume` na gravação e assim que ela for concluida(Usando o botão de `Stop`) o usuario pode compartilhar aquele arquivo utilizando o botão `Share`, que cria um `Action Chooser Intent` e permite que o audio seja enviado para outros aplicativos.
