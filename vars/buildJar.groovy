#!/usr/bin/env groovy
def call()
{
    echo "Building the application for branch $env.BRANCH_NAME"
    sh 'mvn clean package'
}
