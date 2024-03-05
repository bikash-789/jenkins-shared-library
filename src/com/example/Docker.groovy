package com.example

class Docker implements Serializable{
    def script

    Docker(script)
    {
        this.script = script
    }

    def buildDockerImage(String imageName, String tagName) {
        script.echo 'Building the docker image...'
        script.sh('docker build -t $imageName:$tagName .')
    }

    def dockerLogin()
    {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
            script.sh('echo $script.PASS | docker login -u $script.USERNAME --password-stdin')
        }
    }

    def dockerPush(String imageName, String tagName)
    {
        script.sh('docker push $imageName:$tagName')
    }
}
