pipeline {
    agent { label 'built-in' }

    environment {
        PROFILE = 'dev'
    }

    stages {
        /*stage('Checkout') {
            steps {
                git credentialsId: 'github',
                url: 'https://github.com/ivankaptue/cantoncoders-sprint-boot-app'
            }
        }*/
        stage('Env variable') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} and java : ${env.JAVA_HOME}, and profile ${env.PROFILE}"
            }
        }
        stage('Tests') {
            steps {
                sh 'ls -ltr'
                sh './mvnw clean test -B'
            }
        }
        stage('Package') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
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
        always {
            deleteDir()
        }
    }
}
