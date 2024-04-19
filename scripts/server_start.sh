#!/usr/bin/env bash

# Change directory to where your frontend application is located
<<<<<<< HEAD
cd /home/ec2-user/server/fitnessapp/build
=======
cd /home/ec2-user/fitnessapp/
>>>>>>> 7b39902f05fa2c068c54fd4a70982ead8e8cb7b1

# Start the frontend application
sudo npm install
sudo npm start > /dev/null 2>&1 &
