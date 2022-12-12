# Ping

This program is a rudimentary implementation of the ping command. Elevated privileges are required 
for the ping to work.

## Run Program

### Option 1:

This option is for standard use.

1. Traverse to /src/main/scala directory in terminal

```
cd /src/main/scala
```

2. Compile files

```
scalac ping.scala
```

3. Execute

```
Print usage: 
scala ping [-h or --help]
sudo scala ping [-c <count> or --count <count>] <IP Address>
```

**Example**

```
$ scala ping -h

Output:
ping [-c <count> or --count <count>] <IP Address>
ping [-h or --help]
```

### Option 2:

This option is for quick testing. ```run.sh``` is a script that will
run all options with the ping command and clean the environment of excess files after running.

1. From the ping root directory

```
./run.sh
```

**Note:** if ```./run.sh fails```, try ```sh run.sh```, or run ```chmod +x run.sh```
to make it an executable.

**Expected Output:**

```
Running...
TEST: ping
ping [-c <count> or --count <count>] <IP Address>
ping [-s] <IP Address>
ping [-h or --help]

TEST: ping -h
ping [-c <count> or --count <count>] <IP Address>
ping [-s] <IP Address>
ping [-h or --help]

TEST: ping --help
ping [-c <count> or --count <count>] <IP Address>
ping [-s] <IP Address>
ping [-h or --help]

TEST: ping -s 8.8.8.8
[sudo] password for stocktonwoodworth:
PING 8.8.8.8
Host reachable
TEST: ping -c 5 8.8.8.8
PING 8.8.8.8
Host reachable
Host reachable
Host reachable
Host reachable
Host reachable
TEST: ping -s www.google.com
PING www.google.com
Host reachable
Wrong usage, try: ping -c 5 'ipAddr'
ping [-c <count> or --count <count>] <IP Address>
ping [-s] <IP Address>
ping [-h or --help]

Cleaning environment...
Cleaning complete
Script finished
```

