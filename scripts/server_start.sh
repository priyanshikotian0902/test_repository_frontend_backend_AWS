#!/usr/bin/env bash

# Change directory to where your frontend application is located
cd /home/ec2-user/fitnessapp/

# Start the frontend application
sudo npm start > /dev/null 2>&1 &
