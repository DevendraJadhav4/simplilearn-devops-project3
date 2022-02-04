pipeline {
    environment { 
        docker_tag = getCommitRev()
        docker_container = 'simplilearn-devops-project3'
    }

    agent any
    stages {
      stage('Checkout Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/DevendraJadhav4/simplilearn-devops-project3.git'
            }
        }
        stage('Execute Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Create Package') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
            	sh 'sudo docker build -t djdockerhub/simplilearn-devops-project3:${docker_tag} .'
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'docker_hub_password', variable: 'docker_hub_password')]) {
                    sh 'sudo docker login -u djdockerhub -p ${docker_hub_password}'
                }
                sh 'sudo docker push djdockerhub/simplilearn-devops-project3:${docker_tag}'
            }
        }
        stage('Pull Docker Image') {
            steps { 
                sh 'sudo docker pull djdockerhub/simplilearn-devops-project3:${docker_tag}'
            }
        }
        stage('Stop Docker Container'){
            steps{
                script{
                    sh 'sudo chmod 666 /var/run/docker.sock'
                    def doc_containers = sh(returnStdout: true, script: 'sudo docker container ps -aq -f name=${docker_container}').replaceAll("\n", " ") 
                    if (doc_containers) {
                        sh "echo Docker Containers ${doc_containers} Found"
                        sh "sudo docker stop ${doc_containers}"
                        sh "sudo docker container rm -f ${doc_containers}"
                    }
                    
                }
            }
        }
        stage('Start Docker Container') {
            steps { 
                sh 'sudo docker run --name ${docker_container} -d -p 10000:10000 djdockerhub/simplilearn-devops-project3:${docker_tag}'
            }
        }

    }
}
def getCommitRev() {
    def commitRev = sh returnStdout: true, script: 'git rev-parse --short HEAD'
    return commitRev
}
