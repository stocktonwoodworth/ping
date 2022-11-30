#!/bin/sh
# Script for running various options for ping program

echo "Running..."

scalac src/main/scala/ping.scala	# Compile program
scala ping 							          # Run empty args
scala ping -h 						        # Run -h arg
scala ping --help 					      # Run --help arg

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
