pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                // No need to change the directory if pom.xml is in the root
                sh 'mvn clean package'
            }
        }
        stage('Start Selenium Grid) {
            steps {
                script {
                     sh 'docker-compose up -d'
                }
            }
        }
        stage('Test') {
            steps {
                // No need to change the directory if pom.xml is in the root
                sh 'mvn clean test -DsuiteXmlFiles=testng.xml -Dbrowser.name=chrome -Dheadless.mode=false -Denvironment=Test -Dcucumber.filter.tags="@this" -DthreadCount=2 -Dwindows.size=1920,1080'
            }
        }
        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-report']],
                ])
            }
        }
        stage('Stop Selenium Grid) {
            steps {
                script {
                     sh 'docker-compose down'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}