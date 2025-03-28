pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                dir("${env.WORKSPACE}/AutomationFrameworkMission") {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                dir("${env.WORKSPACE}/AutomationFrameworkMission") {
                    sh 'mvn clean test -DsuiteXmlFiles=testng.xml -Dbrowser.name=chrome -Dheadless.mode=false -Denvironment=Test -Dcucumber.filter.tags="@this" -DthreadCount=2 -Dwindows.size=1920,1080'
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