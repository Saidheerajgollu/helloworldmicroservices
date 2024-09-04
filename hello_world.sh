#!/bin/bash

# Get the responses from both services
hello=$(curl -s http://127.0.0.1:58645/hello)
world=$(curl -s http://127.0.0.1:59004/world)

# Combine the responses
echo "$hello $world"

