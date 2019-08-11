This projet was made by Gabriel Ribeiro Silva, gabriel.siilv3409@gmail.com

It is a simple project with Spring and Angular, bolth in different Docker Containers.

WebService Spring is listenning at port 8080.
xgnix is redirecting the requests at 80 to 8080 server of the Spring server.
Angular client is listenning to default 4200. 

To access the application, hit http://localhost:4200/.

Pre-requirements:


	To run this projet, you must have shure that you have installed in your computer:


	1. Docker / for installation, follow the tutorial on the official docker site https://docs.docker.com/install/

	2. nginx / for installation, follow the tutorial on the github repository https://gist.github.com/soheilhy/8b94347ff8336d971ad0


	Set the scripts as executables running the following command:


		chmod +x install.sh start.sh stop.sh uninstall.sh



Installation:

	Execute the install.sh script for correct installation.



Start:

	Execute the start.sh script to up the containers.



Stop:

	Execute the stop.sh to stop the containers.



Untallation:

	Execute the unistall.sh script for uninstall the containers.



Thanks,
Gabriel ;D




