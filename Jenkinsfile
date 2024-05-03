pipeline {

  environment {
    dockerimagename = "ldocker9/jenkins-integration.jar"
    dockerImage = ""
  }

  agent any
  tools{
		        maven 'LocalMaven'
		    }
  

  stages {

    stage('Checkout Source') {
      steps {
         checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/lakshmikundeti99/jenkinsDocK8sIntegration.git']])
        
      }
    }

    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerpwd'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }
    
    

    stage('Deploying SpringBoot container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yaml", "service.yaml")
        }
      }
    }

  }

}