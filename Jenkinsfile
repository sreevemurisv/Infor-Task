pipeline {
    agent any

    stages {
        stage('Branch Detection') {
            steps {
                echo "Triggered on branch: ${env.BRANCH_NAME}"
            }
        }

        stage('Dev Task') {
            when {
                branch 'Dev'
            }
            steps {
                echo "Running unit tests and dev build..."
            }
        }

        stage('QA Task') {
            when {
                branch 'QA'
            }
            steps {
                echo "Running integration and QA automated tests..."
            }
        }

        stage('Feature Task') {
            when {
                branch 'futureBranch'
            }
            steps {
                echo "Validating feature branch code..."
            }
        }

        stage('Production Build') {
            when {
                branch 'main'
            }
            steps {
                echo "Building production release artifact..."
            }
        }
    }
}
