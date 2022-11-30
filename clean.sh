#!/bin/sh

echo "Cleaning environment..."

# Hard code file names
file1="/ping$.class"
file2="/ping.class"

# Get current path
path1=$PWD$file1
path2=$PWD$file2

# Testing path
echo $path1
echo $path2

# Clean up
rm $path1
rm $path2

echo "Cleaning complete"