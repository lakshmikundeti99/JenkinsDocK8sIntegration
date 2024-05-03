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
		            steps{
		                script{
		                    withCredentials([string(credentialsId: 'pwd', variable: 'dockerpwd')]) {
		                        bat "docker login -u ldocker9 -p ${dockerpwd}"
		                    }
		                bat "docker push ldocker9/jenkins-integration.jar"
		                }
		            }
		        }

    
    

    stage('Deploying SpringBoot container to Kubernetes') {
      steps {
        script {          
          kubernetesDeploy(configs: 'deployment.yaml',  kubeconfigId: 'kubeconfig_pwd')
          kubernetesDeploy(configs: 'service.yaml' ,  kubeconfigId: 'kubeconfig_pwd')
        }
      }
    }

  }

}