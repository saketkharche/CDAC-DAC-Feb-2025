# Part A - Linux Commands Explanation

## What will the following commands do?

### `echo "Hello, World!"`
Prints `Hello, World!` to the terminal.

### `name="Productive"`
Creates a variable `name` and assigns it the value `Productive`.

### `touch file.txt`
Creates an empty file named `file.txt` or updates its timestamp if it already exists.

### `ls -a`
Lists all files and directories in the current directory, including hidden ones (those starting with `.`).

### `rm file.txt`
Removes the file `file.txt` permanently.

### `cp file1.txt file2.txt`
Copies `file1.txt` to `file2.txt`. If `file2.txt` exists, it will be overwritten.

### `mv file.txt /path/to/directory/`
Moves `file.txt` to the specified directory.

### `chmod 755 script.sh`
Grants the owner full permissions (read, write, execute) and gives others read and execute permissions on `script.sh`.

### `grep "pattern" file.txt`
Searches for occurrences of "pattern" in `file.txt` and prints matching lines.

### `kill PID`
Terminates the process with the specified Process ID (PID).

### `mkdir mydir && cd mydir && touch file.txt && echo "Hello, World!" > file.txt && cat file.txt`
- Creates a directory `mydir`
- Changes into `mydir`
- Creates an empty file `file.txt`
- Writes "Hello, World!" into `file.txt`
- Displays the contents of `file.txt`

### `ls -l | grep ".txt"`
Lists files in long format and filters only those containing ". Txt" in their names.

### `cat file1.txt file2.txt | sort | uniq`
Concatenates `file1.txt` and `file2.txt`, sorts them, and removes duplicate lines.

### `ls -l | grep "^d"`
Lists directories (entries starting with `d` in long format output).

### `grep -r "pattern" /path/to/directory/`
Searches for "pattern" recursively in all files under `/path/to/directory/`.

### `cat file1.txt file2.txt | sort | uniq -d`
Concatenates `file1.txt` and `file2.txt`, sorts them, and displays only duplicate lines.

### `chmod 644 file.txt`
Grants the owner read and write permissions, while others get read-only access to `file.txt`.

### `cp -r source_directory destination_directory`
Recursively copies `source_directory` to `destination_directory`, preserving contents.

### `find /path/to/search -name "*.txt"`
Finds all `.txt` files in `/path/to/search` and its subdirectories.

### `chmod u+x file.txt`
Gives the owner (`u`) execute permission on `file.txt`.

### `echo $PATH`
Displays the system's `PATH` environment variable, listing directories where executable files are searched for.

---

# Part B - Identify True or False

1. **True** - `ls` is used to list files and directories in a directory.
2. **True** - `mv` is used to move files and directories.
3. **False** - `cd` is used to change directories, not copy files and directories.
4. **True** - `pwd` stands for "print working directory" and displays the current directory.
5. **True** - `grep` is used to search for patterns in files.
6. **True** - `chmod 755 file.txt` gives read, write, and execute permissions to the owner, and read and execute permissions to group and others.
7. **True** - `mkdir -p directory1/directory2` creates nested directories, creating `directory2` inside `directory1` if `directory1` does not exist.
8. **True** - `rm -rf file.txt` deletes a file forcefully without confirmation.

---
1. **Incorrect** - `chmodx` is not a valid command. The correct command to change file permissions is `chmod`.
2. **Incorrect** - `cpy` is not a valid command. The correct command to copy files and directories is `cp`.
3. **Incorrect** - `mkfile` is not a standard Linux command. To create a new file, use `touch filename`.
4. **Incorrect** - `catx` is not a valid command. The correct command to concatenate files is `cat`.
5. **Incorrect** - `rn` is not a valid command. To rename files, use the `mv` command (`mv oldname newname`).

---

# Part C - Shell Scripting Questions

### Question 1: Write a shell script that prints "Hello, World!" to the terminal.
```sh
#!/bin/bash
echo "Hello, World!"
```

![[Pasted image 20250301213434.png]]
### Question 2: Declare a variable named "name" and assign the value "CDAC Mumbai" to it. Print the value of the variable.
```sh
#!/bin/bash
name="CDAC Mumbai"
echo "$name"
```

![[Pasted image 20250301213539.png]]
### Question 3: Write a shell script that takes a number as input from the user and prints it.
```sh
#!/bin/bash
read -p "Enter a number: " num
echo "You entered: $num"
```

![[Pasted image 20250301214517.png]]
### Question 4: Write a shell script that performs addition of two numbers (e.g., 5 and 3) and prints the result.
```sh
#!/bin/bash
a=5
b=3
sum=$((a + b))
echo "Sum: $sum"
```
![[Pasted image 20250301215138.png]]

### Question 5: Write a shell script that takes a number as input and prints "Even" if it is even, otherwise prints "Odd".
```sh
#!/bin/bash
read -p "Enter a number: " num
if ((num % 2 == 0)); then
    echo "Even"
else
    echo "Odd"
fi
```
![[Pasted image 20250301215326.png]]
### Question 6: Write a shell script that uses a for loop to print numbers from 1 to 5.
```sh
#!/bin/bash
for i in {1..5}; do
    echo "$i"
done
```
![[Pasted image 20250301215226.png]]
### Question 7: Write a shell script that uses a while loop to print numbers from 1 to 5.
```sh
#!/bin/bash
i=1
while [ $i -le 5 ]; do
    echo "$i"
    ((i++))
done
```
![[Pasted image 20250301215433.png]]
### Question 8: Write a shell script that checks if a file named "file. Txt" exists in the current directory.
```sh
#!/bin/bash
if [ -f "file.txt" ]; then
    echo "File exists"
else
    echo "File does not exist"
fi
```
![[Pasted image 20250301215713.png]]
### Question 9: Write a shell script that checks if a number is greater than 10 and prints a message accordingly.
```sh
#!/bin/bash
read -p "Enter a number: " num
if [ $num -gt 10 ]; then
    echo "Number is greater than 10"
else
    echo "Number is 10 or less"
fi
```
![[Pasted image 20250301215936.png]]
### Question 10: Write a shell script that prints a multiplication table for numbers from 1 to 5.
```sh
#!/bin/bash
for i in {1..5}; do
    for j in {1..5}; do
        printf "%4d" $((i * j))
    done
    echo
done
```
![[Pasted image 20250301220214.png]]
![[Pasted image 20250301220243.png]]
![[Pasted image 20250301220302.png]]
### Question 11: Write a shell script that reads numbers from the user until a negative number is entered.
```sh
#!/bin/bash
while true; do
    read -p "Enter a number: " num
    if [ $num -lt 0 ]; then
        break
    fi
    echo "Square: $((num * num))"
done
```
![[Pasted image 20250301220454.png]]

---

# Part D - Common Interview Questions

1. What is an operating system, and what are its primary functions?
2. Explain the difference between process and thread.
3. What is virtual memory, and how does it work?
4. Describe the difference between multiprogramming, multitasking, and multiprocessing.
5. What is a file system, and what are its components?
6. What is a deadlock, and how can it be prevented?
7. Explain the difference between a kernel and a shell.
8. What is CPU scheduling, and why is it important?
9. How does a system call work?
10. What is the purpose of device drivers in an operating system?
11. Explain the role of the page table in virtual memory management.
12. What is thrashing, and how can it be avoided?
13. Describe the concept of a semaphore and its use in synchronization.
14. How does an operating system handle process synchronization?
15. What is the purpose of an interrupt in operating systems?
16. Explain the concept of a file descriptor.
17. How does a system recover from a system crash?
18. Describe the difference between a monolithic kernel and a microkernel.
19. What is the difference between internal and external fragmentation?
20. How does an operating system manage I/O operations?
21. Explain the difference between preemptive and non-preemptive scheduling.
22. What is round-robin scheduling, and how does it work?
23. Describe the priority scheduling algorithm. How is priority assigned to processes?
24. What is the shortest job next (SJN) scheduling algorithm, and when is it used?
25. Explain the concept of multilevel queue scheduling.
26. What is a process control block (PCB), and what information does it contain?
27. Describe the process state diagram and the transitions between different process states.
28. How does a process communicate with another process in an operating system?
29. What is process synchronization, and why is it important?
30. Explain the concept of a zombie process and how it is created.
31. Describe the difference between internal fragmentation and external fragmentation.
32. What is demand paging, and how does it improve memory management efficiency?
33. How does a memory management unit (MMU) work?
34. What is a system call, and how does it facilitate communication between user programs and the operating system?
35. Explain the concept of a race condition and how it can be prevented.
36. How does the fork () system call work in creating a new process in Unix-like operating systems?
37. How does process termination occur in Unix-like operating systems?
38. What is the role of the long-term scheduler in process scheduling?
39. Describe how a parent process can wait for a child process to finish execution.
40. What is the significance of the exit status of a child process in the wait () system call?


# Part E - Scheduling and Process Management Questions

## 1. First-Come, First-Served (FCFS) Scheduling

Consider the following processes with arrival times and burst times:

| Process | Arrival Time | Burst Time |
|---------|--------------|------------|
| P 1      | 0            | 5          |
| P 2      | 1            | 3          |
| P 3      | 2            | 6          |

Calculate the average waiting time using First-Come, First-Served (FCFS) scheduling.
![[Pasted image 20250301233236.png]]
---

## 2. Shortest Job First (SJF) Scheduling

Consider the following processes with arrival times and burst times:

| Process | Arrival Time | Burst Time |
|---------|--------------|------------|
| P 1      | 0            | 3          |
| P 2      | 1            | 5          |
| P 3      | 2            | 1          |
| P 4      | 3            | 4          |

Calculate the average turnaround time using Shortest Job First (SJF) scheduling.
![[Pasted image 20250301233553.png]]
---

## 3. Priority Scheduling

Consider the following processes with arrival times, burst times, and priorities (lower number indicates higher priority):

| Process | Arrival Time | Burst Time | Priority |
|---------|--------------|------------|----------|
| P 1      | 0            | 6          | 3        |
| P 2      | 1            | 4          | 1        |
| P 3      | 2            | 7          | 4        |
| P 4      | 3            | 2          | 2        |

Calculate the average waiting time using Priority Scheduling.
![[WhatsApp Image 2025-03-01 at 23.28.52_bd738bb6 1.jpg]]
---

## 4. Round Robin Scheduling

Consider the following processes with arrival times and burst times, and the time quantum for Round Robin scheduling is 2 units:

| Process | Arrival Time | Burst Time |
|---------|--------------|------------|
| P 1      | 0            | 4          |
| P 2      | 1            | 5          |
| P 3      | 2            | 2          |
| P 4      | 3            | 3          |

Calculate the average turnaround time using Round Robin scheduling.
![[Pasted image 20250301233738.png]]
---

## 5. Fork System Call Scenario

Consider a program that uses the `fork()` system call to create a child process. Initially, the parent process has a variable `x` with a value of `5`. After forking, both the parent and child processes increment the value of `x` by `1`.

What will be the final values of `x` in the parent and child processes after the `fork()` call?
![[Pasted image 20250301234027.png]]
![[WhatsApp Image 2025-03-01 at 23.28.53_08256142.jpg]]