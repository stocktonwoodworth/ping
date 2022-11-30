#!/bin/sh
# Script for running various options for ping program

echo "Running..."

scalac src/main/scala/ping.scala	# Compile program
scala ping 							          # Run empty args
scala ping -h 						        # Run -h arg
scala ping --help 					      # Run --help arg

echo "Script finished"
