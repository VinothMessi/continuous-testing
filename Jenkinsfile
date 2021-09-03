pipeline {
  agent any
  stages {
    stage('Build Image') {
      steps {
        echo 'Build Docker image'
        fileExists 'Dockerfile'
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

    stage('Test execution') {
      steps {
        echo 'Initiate test execution'
        sh 'docker-compose -f disposable-docker-grid.yml up -d'
        sleep 120
        echo 'Test execution done successfully'
      }
    }

    stage('Dispose Test infra') {
      steps {
        echo 'Remove all containers'
        sh 'docker-compose -f disposable-docker-grid.yml down'
        echo 'Removed all containers successfully'
        sh 'cd /var/lib/jenkins/workspace/;sudo rm -rf *;sudo rm *'
      }
    }

  }
}