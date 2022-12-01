#!/bin/sh
# Script for running various options for ping program

echo "Running..."

scalac src/main/scala/ping.scala	# Compile program
echo "TEST: ping"
scala ping 							          # Run empty args
echo "TEST: ping -h"
scala ping -h 						        # Run -h arg
echo "TEST: ping --help"
scala ping --help 					      # Run --help arg
echo "TEST: ping -s 8.8.8.8"
scala ping -s 8.8.8.8             # Single ping
echo "TEST: ping -c 5 8.8.8.8"
scala ping -c 1 8.8.8.8           # run -c arg
echo "TEST: ping -s www.google.com"
scala ping -s www.google.com      # run with hostname

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
