pipeline {
  agent any
  stages {
    stage('Build Image') {
      steps {
        echo 'Build Docker image'
        sh 'docker build --tag=vinothmessi/continuous-testing .'
        echo 'Docker Image built successfully'
      }
    }

    stage('Push Image') {
      steps {
        echo 'Push Docker image'
        sh 'docker push vinothmessi/continuous-testing'
        echo 'Image pushed successfully'
      }
    }

  }
}