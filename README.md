# Ping
This program is a rudimentary implementation of the ping command. The current build does not ping addresses, only options currently supported are print usage.

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
scala ping [-c <count> or --count <count>] <IP Address>
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

1. From the ping root dirictory
```
./run.sh
```

**Expected Output:**
```
Running...
ping [-c <count> or --count <count>] <IP Address>
ping [-h or --help]

ping [-c <count> or --count <count>] <IP Address>
ping [-h or --help]

ping [-c <count> or --count <count>] <IP Address>
ping [-h or --help]

Cleaning environment...
Cleaning complete
Script finished
```

