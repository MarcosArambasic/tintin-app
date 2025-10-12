pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/MarcosArambasic/tintin-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials-id') {
                        def app = docker.build("marcosarambasic/tintin-app:latest")
                        app.push()
                    }   
                }
            }
        }   
    }

    post {
        success {
            echo '✅ Build e testes concluídos com sucesso!'
        }
        failure {
            echo '❌ Ocorreu uma falha no pipeline.'
        }
    }
}
