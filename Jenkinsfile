pipeline {
    agent any

    environment {
        // Define environment variables
        NODE_ENV = 'development'
    }

    options {
        // Keep build logs for 10 days
        buildDiscgiarder(logRotator(daysToKeepStr: '10'))
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                echo 'Installing dependencies...'
                sh 'npm install' // or use pip, mvn, etc., based on project
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                sh 'npm test' // replace with your test command
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'npm run build' // or relevant build script
            }
        }

        stage('Deploy') {
            when {
                branch 'main' // or 'master' or any other branch
            }
            steps {
                echo 'Deploying application...'
                // Add deployment steps here
                sh './deploy.sh'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
        always {
            echo 'Cleaning up...'
            cleanWs()
        }
    }
}
