pipeline {
  agent any

  environment {
    GITHUB_URL = ""
    CREDENTIAL = "a7c0186a-cf9a-4e15-b6c6-b0c796925c4b"
  }

  parameters {
    string(name : "branch", defaultValue : "main", description : "")
  }

  stages {
    stage("Git") {
      steps {
        git(
          branch: "${params.branch}",
          credentialsId: "${CREDENTIAL}",
          url: "${GITHUB_URL}"
        )
      }

      post {
        success {
          sh "echo \"Successfully Cloned Repository\""
        }
        failure {
          sh "echo \"Fail Cloned Repository\""
        }
      }
    }

    stage("Build") {
      steps {
        script {
          sh "chmod +x ./gradlew"
          sh  "./gradlew clean build"
        }
      }
      post {
        success {
          echo "gradle build success"
        }

        failure {
          echo "gradle build failed"
        }
      }
    }
  }
}