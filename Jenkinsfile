pipeline {
	environment {
    registry = "nickpappu/mycalculator"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

		stage('DockerHub') {
      stages{
        stage('Build Image') {
          steps{
            script {
              dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
          }
        }
        stage('Push Image') {
          steps{
            script {
              docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
                lat_tag = "docker tag " + ":$BUILD_NUMBER" + registry
		latest = "docker push " + registry
		sh latest
              }
            }
          }
        }
      }
    }
		stage('Deploy') {
      agent any
      steps {
        script {
          step([$class: "RundeckNotifier",
          rundeckInstance: "Rundeck",
          options: """
            BUILD_VERSION=$BUILD_NUMBER
          """,
          jobId: "dcc646aa-a572-4b28-9d3f-008514235fb3"])
        }
      }
    }
  }
}
