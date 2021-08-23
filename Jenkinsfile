pipeline {
  agent any
  stages {
    stage('Package') {
      steps {
        echo 'Package project and its dependancies'
        sh 'mvn clean package -DskipTests'
        echo 'Package is done successfully'
      }
    }

    stage('Build docker image') {
      steps {
        echo 'Building the docker image'
        sh 'docker image build --tag=vinothmessi/continuous-testing:v1.0 .'
        echo 'Image build done successfully'
      }
    }

    stage('Push docker image') {
      steps {
        echo 'Push image to docker hub'
        sh 'docker image push --all-tags vinothmessi/continuous-testing:v1.0'
        echo 'Docker image push done successfully'
      }
    }
  }
}
