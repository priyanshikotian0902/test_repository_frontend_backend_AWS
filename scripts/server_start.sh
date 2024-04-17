#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -jar s30project-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &
# cd /home/ec2-user/server/fitnessapp/build
# sudo npm start