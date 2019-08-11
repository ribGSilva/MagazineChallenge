#!/bin/bash


echo "Stopping Angular client container..."

sudo docker stop clinetserver

echo "Stopping JAVA server container..."

sudo docker stop javaserver

echo "Done"
