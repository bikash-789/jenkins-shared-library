package com.example

class Docker implements Serializable{
    def script

    Docker(script)
    {
        this.script = script
    }

    def buildDockerImage(String imageName, String tagName) {
        script.echo 'Building the docker images...'
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
            script.sh("docker build -t $imageName:$tagName .")
            script.sh("echo $script.PASS | docker login -u $script.USERNAME --password-stdin")
            script.sh("docker push $imageName:$tagName")
        }
    }
}
