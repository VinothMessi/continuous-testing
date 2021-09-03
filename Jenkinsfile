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

    stage('Selenium grid set-up and test execution') {
      steps {
        echo 'Setting up selenium grid and test execution'
        sh 'docker-compose -f disposable-docker-grid.yml up -d'
        sh 'sleep 120'
        echo 'Selenium grid set-up and test execution done successfully'
      }
    }

    stage('Disposable selenium grid tear-down') {
      steps {
        echo 'Bringing down selenium grid'
        sh 'docker-compose -f disposable-docker-grid.yml down'
        echo 'Tear down of selenium grid done successfully'
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