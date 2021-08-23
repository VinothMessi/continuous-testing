pipeline {
  agent any
  stages {
    stage('get code from GIT') {
      steps {
        git(url: 'https://github.com/VinothMessi/continuous-testing.git', branch: 'main', credentialsId: 'GIT_Credentials', poll: true, changelog: true)
      }
    }

  }
}