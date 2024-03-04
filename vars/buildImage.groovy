#!/usr/bin/env groovy
def call(String imageName, String tagName)
{
    echo 'Building the docker images...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh("docker build -t $imageName:$tagName .")
        sh("echo $PASS | docker login -u $USERNAME --password-stdin")
        sh("docker push $imageName:$tagName")
    }
}
