#!/usr/bin/env groovy
def call(String imageName)
{
    echo 'Building the docker images...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh "docker login -u $USERNAME -p $PASS"
        sh "docker push $imageName"
    }
}
