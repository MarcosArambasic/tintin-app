# Documentação para auxiliar

## GITHUB

| Etapa              | Comando                       | Resultado                |
| ------------------ | ----------------------------- | ------------------------ |
| Inicializar git    | `git init`                    | Repositório local criado |
| Adicionar arquivos | `git add .`                   | Prontos para commit      |
| Criar commit       | `git commit -m "mensagem"`    | Histórico salvo          |
| Conectar GitHub    | `git remote add origin <url>` | Conexão remota           |
| Enviar código      | `git push -u origin main`     | Publicado no GitHub      |
| Enviar código      | `git push -u origin main`     | Publicado no GitHub      |
| Adiciona um arquivo| `git add caminho/do/arquivo`  | Pronto para commit       |
| Ver o que mudou    | `git status`                  | Vê o que mudou           |


## ACESSOS

ACESSAR EC2 VIA SSH:
ssh -i "C:\Users\marco\OneDrive\Documentos\MACKENZIE\LAB ENGENHARIA DE SOFTWARE\tinTinKey.pem" ubuntu@ec2-3-87-167-84.compute-1.amazonaws.com

LINK DO BROWSER:
http://3.87.167.84:8080

**JENKINS**
PEGAR A CHAVE DE COMANDO DO JENKINS
sudo cat /var/lib/jenkins/secrets/initialAdminPassword

CHAVE JENKINS: 1111347257424b8ea897a2bee901119b

LOGIN: marcos_arambasic_silva
SENHA: vFKhp657AgHd
EMAIL: marcos.arambasic.silva@gmail.com

**GITHUB**
TOKEN PARA CREDENCIAL JENKINS: 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C

**RDS POSTGRES**
USUARIO: tintin_postgres
SENHA: XnLR0XW62zxU


## VARIÁVEIS DE AMBIENTE
RESUMO RÁPIDO
| Ambiente        | Onde definir                   | Persistência                     | Observações                    |
| --------------- | ------------------------------ | -------------------------------- | ------------------------------ |
| **Local (dev)** | `.env` ou `export` no terminal | Temporária ou no arquivo         | Ideal para testes              |
| **EC2**         | `/etc/environment`             | Permanente                       | Recarrega a cada boot          |
| **Docker**      | `docker-compose.yml`           | Enquanto container estiver ativo | Boa prática para microserviços |
| **Jenkins**     | Credentials → Environment      | Segura e integrada               | Ideal para CI/CD               |


Recomendação prática para o seu projeto Tintin
|Contexto|	Método recomendado|
| ----- | -----| 
|💻 Desenvolvimento local|	Arquivo .env (não versionado)|
|☁️ EC2 (produção/staging)|	/etc/environment|
|🤖 Jenkins CI/CD|	Variáveis no painel “Credentials”|