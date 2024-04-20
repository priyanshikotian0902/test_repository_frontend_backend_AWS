#!/usr/bin/env bash

# Change directory to where your server scripts are located
chown -R ec2-user:ec2-user /var/www/html
chmod +x /home/ec2-user/server/*.jar
chmod +x /home/ec2-user/server/server_start.sh
chmod +x /home/ec2-user/server/server_stop.sh
