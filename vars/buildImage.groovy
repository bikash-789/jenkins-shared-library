#!/usr/bin/env groovy
def call()
{
    echo 'Building the docker images...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t bikash789/product-service-private:psa-2.0 .'
        sh "docker login -u $USERNAME -p $PASS"
        sh "docker push bikash789/product-service-private:psa-2.0"
    }
}
