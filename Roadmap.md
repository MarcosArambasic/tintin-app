# 🧭 Backlog Integrado – Projeto Tintin (Match de Conhecimentos)

**Escopo:** Aplicativo Web e Mobile inspirado no Tinder, voltado para trocas de conhecimento (ensinar/aprender), com backend em **Java + Spring Boot**, frontend em **React/React Native**, banco de dados **PostgreSQL**, e pipeline **Docker + Jenkins + AWS EC2**.

---

## 🟩 Sprint 1 – Configuração da Infraestrutura
**Objetivo:** Criar o ambiente de desenvolvimento e CI/CD para todo o ciclo de build e deploy.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Criar instância EC2 (Ubuntu 22.04) com portas 22, 8080 e 5432 abertas | DevOps | Acesso SSH e ping remoto ativos | Nenhuma |
| Instalar e configurar Jenkins | DevOps | Jenkins acessível via `http://IP:8080` | EC2 criada |
| Integrar Jenkins com GitHub (token + webhook) | DevOps | Commit no GitHub dispara build automático | Jenkins ativo |
| Configurar Maven e Java 17 | DevOps | Jenkins executa `mvn clean install` com sucesso | Nenhuma |
| Criar `.gitignore`, `README.md`, estrutura de pastas backend/frontend | Dev Backend | Estrutura visível no GitHub | Nenhuma |
| Configurar credenciais seguras (AWS, DockerHub, GitHub Token) | DevOps | Jenkinsfile acessa credenciais criptografadas | Jenkins ativo |

---

## 🟩 Sprint 2 – Backend Inicial (Java + Spring Boot + PostgreSQL)
**Objetivo:** Criar o backend base, CRUD de usuário e integração ao banco de dados.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Criar projeto Maven com Spring Boot | Dev Backend | Executa `mvn spring-boot:run` localmente | Infra pronta |
| Configurar PostgreSQL (local e EC2) | DevOps | Banco acessível via JDBC | EC2 e rede configuradas |
| Implementar entidade `Usuário` e repositório JPA | Dev Backend | CRUD via API `/usuarios` testado no Postman | Banco configurado |
| Criar testes unitários com JUnit + Mockito | Dev Backend | Cobertura ≥70% | Projeto compila |
| Configurar Jenkinsfile com build/teste automáticos | DevOps | Jenkins executa pipeline e salva log | Jenkins ativo |
| Gerar imagem Docker do backend (Dockerfile) | DevOps | `docker build` gera imagem executável | Maven finalizado |

---

## 🟩 Sprint 3 – Funcionalidades Core (Match + Chat + Banco em Docker)
**Objetivo:** Implementar lógica principal de match e chat e integrar banco PostgreSQL via container.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Criar entidade `Match` e lógica de swipe (like/dislike) | Dev Backend | Regras de match persistidas no DB | CRUD Usuário |
| Criar API REST `/match` e `/chat` | Dev Backend | Chat inicia apenas após match | Match pronto |
| Implementar entidade `Mensagem` e persistência | Dev Backend | Mensagens salvas e listadas | Chat ativo |
| Adicionar container PostgreSQL em `docker-compose.yml` | DevOps | Banco roda via `docker-compose up` | Dockerfile backend |
| Configurar rede interna no compose (`tintin_net`) | DevOps | Containers se comunicam via hostnames | Docker configurado |
| Criar volume persistente `postgres_data` | DevOps | Dados não se perdem ao reiniciar containers | Compose ativo |

---

## 🟨 Sprint 4 – Frontend Web (React + Docker)
**Objetivo:** Criar interface web e integrá-la com backend containerizado.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Criar app React (`create-react-app`) | Dev Frontend | Página inicial em `localhost:3000` | Nenhuma |
| Criar componentes de Login e Cadastro | Dev Frontend | Usuário autentica com backend | API `/usuarios` |
| Implementar swipe e chat com Axios | Dev Frontend | Comunicação via REST | APIs match/chat |
| Criar Dockerfile do frontend | DevOps | Build gera imagem `tintin-frontend` | Código React estável |
| Adicionar serviço frontend ao `docker-compose.yml` | DevOps | Compose sobe frontend + backend + DB juntos | Dockerfiles prontos |

---

## 🟨 Sprint 5 – Mobile App (React Native)
**Objetivo:** Implementar versão mobile com mesmas funcionalidades principais.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Criar app base com Expo ou React Native CLI | Dev Mobile | App roda em emulador Android | APIs backend |
| Reproduzir telas de login, swipe e chat | Dev Mobile | Funcionalidades idênticas ao web | Frontend validado |
| Testar consumo de API no celular | Dev Mobile | Requests retornam sucesso | Backend publicado |
| Testar em dispositivos físicos (Wi-Fi local) | QA | App funcional sem erros | API em rede local |

---

## 🟥 Sprint 6 – Segurança, Docker Compose e CI/CD Completo
**Objetivo:** Garantir segurança, escalabilidade e pipeline automatizado com Docker e AWS.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Implementar autenticação com Spring Security + JWT | Dev Backend | Login protegido e validado | Backend estável |
| Configurar `docker-compose.yml` completo (backend, frontend, db) | DevOps | Todos sobem com `docker-compose up` | Dockerfiles |
| Configurar Jenkinsfile com build/push Docker | DevOps | Imagens publicadas no Docker Hub | Jenkins ativo |
| Criar `.dockerignore` para otimizar build | DevOps | Build 40% mais rápido | Dockerfile pronto |
| Automatizar deploy EC2 (pull do Docker Hub) | DevOps | Jenkins faz deploy remoto | Pipeline DockerHub |
| Configurar logs e monitoramento CloudWatch | DevOps | Logs centralizados AWS | Deploy EC2 |

---

## 🟦 Sprint 7 – Refinamento e Publicação
**Objetivo:** Ajustar design, testes, documentação e publicação.  

| Tarefa | Responsável | Critério de Aceitação | Dependência |
|--------|--------------|----------------------|--------------|
| Testes de usabilidade e performance | QA | Relatório validado e aprovado | API e UI prontas |
| Ajustar design responsivo e acessibilidade | Dev Frontend | Layout adaptável (web/mobile) | Telas prontas |
| Publicar imagens Docker no ECR (AWS) | DevOps | Imagens públicas no repositório | Jenkins pipeline |
| Publicar app nas lojas (Play Store / App Store) | Dev Mobile | App disponível publicamente | Backend estável |
| Gerar documentação técnica final (instalação, uso, arquitetura) | Todos | Entrega validada no GitHub | Projeto completo |

---

## 🧩 Visão Geral do Fluxo Docker + Jenkins + AWS

| Fase | Ação | Ferramenta | Resultado |
|------|------|-------------|------------|
| Build | `mvn clean package` | Maven | Gera `.jar` |
| Containerização | `docker build` | Docker | Cria imagem do backend/frontend |
| Orquestração | `docker-compose up` | Docker Compose | Sobe todo o ambiente local |
| CI/CD | Jenkins + DockerHub | Jenkins | Build + push automático |
| Deploy | EC2 ou ECS | AWS | Containers em produção |
| Monitoramento | CloudWatch | AWS | Logs e métricas centralizadas |

---

✅ **Resultado final esperado:**  
O projeto Tintin poderá ser construído, testado e implantado com **um único comando (`docker-compose up`)**, validado automaticamente via **Jenkins pipeline**, com deploy contínuo na **AWS EC2**, garantindo **isolamento, reprodutibilidade e escalabilidade**.
