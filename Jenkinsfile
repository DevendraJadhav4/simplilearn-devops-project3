pipeline {
    agent any

    stages {
        stage('User') {
            steps {
                sh 'whoami'
            }
        }
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/DevendraJadhav4/simplilearn-devops-project3.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Copy') {
            steps {
                sh 'sudo -s cp ./target/project3-0.0.1-SNAPSHOT.jar /home/devendrajadhav4/project3/'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sudo -s'
                sh 'sudo su devendrajadhav4'
                sh 'sudo chmod 777 /home/devendrajadhav4/project3/'
                sh 'sudo nohup java -jar /home/devendrajadhav4/project3/project3-0.0.1-SNAPSHOT.jar >/home/devendrajadhav4/project3/server.log &'
            }
        }
    }
}
