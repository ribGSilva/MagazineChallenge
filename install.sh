#!/bin/bash

echo "Building JAVA server container..."

sudo docker build -t webserver:0.1 ./MagazinServer/

sudo docker run -d -p 8080:8080 --restart=always --name javaserver webserver:0.1

sudo docker stop javaserver

echo "Setting up proxying..."

sudo cp /etc/nginx/nginx.conf /etc/nginx/nginx.conf.old

sudo cp nginx.conf /etc/nginx/nginx.conf

sudo nginx -s reload

echo "Done! Know, run the 'start.sh' script to start everything."

