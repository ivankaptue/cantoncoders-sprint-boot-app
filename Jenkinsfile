pipeline {
    // where or who
    agent { label 'master' }
    
    // collection of stages
    stages{
        stage('Quality Dpt'){
            steps{
                sh 'mvn test -B'
            }
        }
        stage('Package '){
            steps{
                sh 'mvn clean package -B -Dmaven.test.skip=true'
            }
        }
        stage('Deploy war'){
            steps{
                sh 'cp target/cantoncoders-0.0.1.war /var/lib/tomcat8/webapps/cantoncoders-0.0.1.war'
            }
        }
    }
    post{
        failure{
            echo 'You failed'
        }
        success{
            echo 'You are Yoda'
        }
    }
}