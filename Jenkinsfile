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

    stage('Test execution') {
      steps {
        echo 'Initiate test execution'
        sh 'docker-compose -f disposable-docker-grid.yml up -d'
        echo 'Test execution done successfully'
      }
    }

  }
}