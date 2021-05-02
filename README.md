# dikastis-android

## Geral

Esse repositório está relacionado com uma aplicação Android implementada para auxiliar professores na checagem de submissões e de código dos seus alunos.

Ele pode navegar livremente por as páginas, que serão discutidas mais tarde nesse README, e assim ir acompanhando o desempenho de seus alunos em diferentes turmas e dar feedbacks compartilhando audio através do próprio aplicativo (enquanto ele analisa a submissão do seu aluno).

## Modelo Arquitetural

O modelo arquitetural utilizado para o desenvolvimento foi o MVVM onde cada activity possui um controlador de estados relacionadas a ela, para fazer calculo das regras de negócio e também acessar o repositório para buscar os dados que devem ser msotrados em tela.

## Data fetching

Os dados que serão vistos em tela estão todos sendo buscado em uma API de suporte que criamos para conseguir visualizar o comportamento do nosso aplicativo. Assim, eles representam situações fictícias que não representam os dados reais da plataforma Dikastis (porque no momento de desenvolvimento não exisitam as rotas disponíveis na API ainda).

Para facilitar no acesso a essa API a aplicação utiliza do Retrofit para realizar as chamadas HTTP e Jackson no parseamento dos JSON para os objetos que utilizamos como model no nosso App.

## Cada Activity

### Main

### Organization

### Team

### Task

### Overview

### Problem
