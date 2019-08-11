#!/bin/bash

echo "Starting JAVA server container..."

sudo docker start javaserver

echo "Starting Angular client container..."

sudo docker start clinetserver

echo "Done!"
