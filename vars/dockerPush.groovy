#!/usr/bin/env groovy

import com.example.Docker
def call(String imageName, String tagName)
{
    return new Docker(this).dockerPush(imageName, tagName)
}
