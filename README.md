# README - TinTin - Match do Aprendizado

# Estrutura do projeto - TinTin

Esta página descreve a organização do repositório e os principais arquivos/pastas do projeto.

```
.backend/
|-HELP.md                  -> instruções específicas do backend
|-Jenkinsfile              -> pipeline CI (Jenkins)
|-mvnw, mvnw.cmd           -> wrapper do Maven
|-pom.xml                  -> configuração do Maven e dependências
|-src/
  |-main/
    |-java/com/tintin/backend/
      |-BackendApplication.java   -> classe principal (Spring Boot)
        controller/               -> controllers REST (ex.: UsuarioController.java)
        entity/                   -> entidades JPA (ex.: Usuaria.java)
        repository/               -> interfaces de acesso a dados (ex.: UsuarioRepository.java)
        service/                  -> lógica de negócio (ex.: UsuarioService.java)
      resources/
        application.properties     -> propriedades do Spring Boot
        static/                    -> arquivos estáticos (JS/CSS)
        templates/                 -> templates Thymeleaf/HTML
    test/
      java/...                    -> testes unitários / integração
  target/                        -> build output do Maven (não comitar)

Auxiliador.md                  -> notas auxiliares do projeto
Roadmap.md                      -> planejamento e roadmap

tintin-app-backend/
├── src/
├── pom.xml
├── Jenkinsfile
├── .gitignore
└── README.md
```

Notas rápidas:
- O `application.properties` normalmente fica em `src/main/resources` e é carregado pelo Spring Boot no classpath.
- Se você usar variáveis de ambiente externas (ex.: `.env`) para configurar segredos ou parâmetros de runtime, documente como inicializar/assignar essas variáveis (ex.: script PowerShell para Windows).
- Mantenha o `target/` no .gitignore (é o diretório de build produzido pelo Maven).

Sugestões de próximo passo:
- Posso inserir esta mesma seção no `README.md` principal (posso tentar novamente a substituição), ou
- Posso adicionar uma seção "Como rodar localmente" com comandos Maven/PowerShell.
