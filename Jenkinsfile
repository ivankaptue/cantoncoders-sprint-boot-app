pipeline {
    agent { label 'built-in'}
    stages {
        /*stage('Checkout') {
            steps {
                git credentialsId: 'github',
                url: 'https://github.com/ivankaptue/cantoncoders-sprint-boot-app'
            }
        }*/
        stage('Tests') {
            steps {
                sh 'ls -ltr'
                sh './mvnw clean test -B'
            }
        }
        stage('Package') {
            steps {
                sh './mvnw clean package -B -Dmaven.test.skip=true'
            }
        }
    }
    post {
        failure {
            echo 'Failed'
        }
        success {
            echo 'Success'
        }
    }
}
