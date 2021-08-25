pipeline {
  agent any
  stages {
    stage('Build/Push docker image') {
      steps {
        echo 'Build Docker image'
        sh 'docker image build --tag=vinothmessi/continuous-testing:v1.0 .'
        echo 'Docker image built done successfully'
      }
    }

    stage('Push docker image') {
      steps {
        echo 'Try to push docker image'
        sh 'docker image push vinothmessi/continuous-testing:v1.0'
        echo 'Docker image push done successfully'
      }
    }

  }
}