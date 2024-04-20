#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -jar *.jar > /dev/null 2> /dev/null < /dev/null &
# Change directory to where your frontend application is located
cd /var/www/html
npm start
