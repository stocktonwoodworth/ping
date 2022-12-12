#!/bin/sh
# Script for running various options for ping program

echo "Running..."

scalac src/main/scala/ping.scala	# Compile program
echo "\e[34mTEST: ping\e[0m"
scala ping 							          # Run empty args
echo "\e[34mTEST: ping -h\e[0m"
scala ping -h 						        # Run -h arg
echo "\e[34mTEST: ping --help\e[0m"
scala ping --help 					      # Run --help arg
echo "\e[34mTEST: ping -s 8.8.8.8\e[0m"
sudo scala ping -s 8.8.8.8             # Single ping
echo "\e[34mTEST: ping -c 5 8.8.8.8\e[0m"
sudo scala ping -c 5 8.8.8.8           # run -c arg
echo "\e[34mTEST: ping -s www.google.com\e[0m"
sudo scala ping -s www.google.com      # run with hostname
scala ping -c 8.8.8.8             # NumberFormatException

echo "Cleaning environment..."

# Hard code file names
file1="/ping$.class"
file2="/ping.class"

# Get current path
path1=$PWD$file1
path2=$PWD$file2

# Testing path
#echo $path1
#echo $path2

# Clean up
rm $path1
rm $path2

echo "Cleaning complete"

echo "Script finished"
