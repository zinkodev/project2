pipeline {
    agent any

    tools {
        maven 'maven 3.9.10'
        jdk 'Java JDK 17'
    }

    stages {
        stage('clean') {
            steps {
                echo "Start Clean"
                bat "mvn clean"
            }
        }

        stage('test') {
            steps {
                echo "Start Test"
                bat "mvn test"
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('build') {
            steps {
                echo "Start Build"
                bat "mvn install -DskipTests"
            }
        }

        stage('scan') {
            steps {
                withSonarQubeEnv('SonarQube_SVR') {
                   bat 'mvn sonar:sonar -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml'
                }
            }
        }
    } // End of Stages

    post {
        always {
            echo "Pipeline completed. Check SonarQube dashboard for analysis results."
        }
    }
} // End of Pipeline