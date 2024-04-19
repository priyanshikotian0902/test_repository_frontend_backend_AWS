#!/usr/bin/env bash

# Change directory to where your frontend application is located
cd /home/ec2-user/server/fitnessapp/build

# Start the frontend application
sudo npm install
sudo npm start > /dev/null 2>&1 &
