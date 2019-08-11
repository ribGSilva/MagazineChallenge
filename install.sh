#!/bin/bash

echo "Building JAVA server container..."

sudo docker build -t webserver:0.1 ./MagazinServer/

sudo docker run -d -p 8080:8080 --restart=always --name javaserver webserver:0.1

sudo docker stop javaserver

echo "Building Angular client container..."

sudo docker build -t webclient:0.1 ./MagazinClient/

sudo docker run -d -v ${PWD}/MagazinClient:/app -v /app/node_modules -p 4200:4200 --restart=always --name clinetserver webclient:0.1

sudo docker stop clinetserver

echo "Setting up proxying..."

sudo cp /etc/nginx/nginx.conf /etc/nginx/nginx.conf.old

sudo cp nginx.conf /etc/nginx/nginx.conf

sudo nginx -s reload

echo "Done! Know, run the 'start.sh' script to start everything."

