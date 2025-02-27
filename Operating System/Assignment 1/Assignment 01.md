### Problem 1: Read the instructions carefully and answer accordingly. If there is any need to insert some data then do that as well.

a) Navigate and List:
a. Start by navigating to your home directory and list its contents. Then, move into a
directory named "LinuxAssignment" if it exists; otherwise, create it.
Ans:- 
`cdac@Saket:~$ pwd`
`/home/cdac`
`cdac@Saket:~$ cd`
`cdac@Saket:~$ ls`
`Feb25`
`cdac@Saket:~$ mkdir LinuxAssignment`
`cdac@Saket:~$ ls`
`Feb25  LinuxAssignment`
`cdac@Saket:~$ cd LinuxAssignment/`
`cdac@Saket:~/LinuxAssignment$`
![[Screenshot (187).png]]

b) File Management:
a. Inside the "LinuxAssignment" directory, create a new file named "file1.txt". Display its contents.
Ans:-
`cdac@Saket:~/LinuxAssignment$ touch file1.txt`
`cdac@Saket:~/LinuxAssignment$ ls`
`file1.txt`
`cdac@Saket:~/LinuxAssignment$ nano file1.txt`
`cdac@Saket:~/LinuxAssignment$ cat file1.txt`
`saket kharche`
`Cdac Mumbai`
`Feb25`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250226213912.png]]


c) Directory Management:
a. Create a new directory named "docs" inside the "LinuxAssignment" directory.
Ans
`cdac@Saket:~/LinuxAssignment$ mkdir docs`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  file1.txt`
`cdac@Saket:~/LinuxAssignment$ cd docs/`
`cdac@Saket:~/LinuxAssignment/docs$`
![[Pasted image 20250226214126.png]]

d) Copy and Move Files:
a. Copy the "file1.txt" file into the "docs" directory and rename it to "file2.txt".
Ans:-
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  file1.txt`
`cdac@Saket:~/LinuxAssignment$ cp file1.txt docs`
`cdac@Saket:~/LinuxAssignment$ cd docs/`
`cdac@Saket:~/LinuxAssignment/docs$ ls`
`file1.txt`
`cdac@Saket:~/LinuxAssignment/docs$ mv file1.txt file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$ ls`
`file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$`
![[Pasted image 20250226215722.png]]

e) Permissions and Ownership:
a. Change the permissions of "file2.txt" to allow read, write, and execute permissions for the owner and only read permissions for others. Then, change the owner of "file2.txt" to the current user.
Ans:-
`cdac@Saket:~/LinuxAssignment$ cd docs/`
`cdac@Saket:~/LinuxAssignment/docs$ chmod 744 file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$ ls -l`
`total 4`
`-rwxr--r-- 1 cdac cdac 33 Feb 26 16:25 file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$ chown $(whoami) file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$ ls -l file2.txt`
`-rwxr--r-- 1 cdac cdac 33 Feb 26 16:25 file2.txt`
`cdac@Saket:~/LinuxAssignment/docs$`


![[Pasted image 20250226232125.png]]

f) Final Checklist:
a. Finally, list the contents of the "LinuxAssignment" directory and the root directory to
ensure that all operations were performed correctly.
Ans:-
`cdac@Saket:~/LinuxAssignment/docs$ cd ..`
`cdac@Saket:~/LinuxAssignment$ ls -l ~/LinuxAssignment`
`total 8`
`drwxr-xr-x 2 cdac cdac 4096 Feb 26 16:25 docs`
`-rw-r--r-- 1 cdac cdac   33 Feb 26 16:02 file1.txt`
`cdac@Saket:~/LinuxAssignment$ ls -l /`
`total 2448`
`lrwxrwxrwx   1 root root       7 Apr 22  2024 bin -> usr/bin`
`drwxr-xr-x   2 root root    4096 Feb 26  2024 bin.usr-is-merged`
`drwxr-xr-x   2 root root    4096 Apr 22  2024 boot`
`drwxr-xr-x  16 root root    3620 Feb 26 15:33 dev`
`drwxr-xr-x  92 root root    4096 Feb 26 15:57 etc`
`drwxr-xr-x   3 root root    4096 Feb 25 15:35 home`
`-rwxrwxrwx   1 root root 2424984 Feb 12 00:59 init`
`lrwxrwxrwx   1 root root       7 Apr 22  2024 lib -> usr/lib`
`drwxr-xr-x   2 root root    4096 Apr  8  2024 lib.usr-is-merged`
`lrwxrwxrwx   1 root root       9 Apr 22  2024 lib64 -> usr/lib64`
`drwx------   2 root root   16384 Feb 25 15:34 lost+found`
`drwxr-xr-x   2 root root    4096 Feb 15 08:09 media`
`drwxr-xr-x   5 root root    4096 Feb 25 15:35 mnt`
`drwxr-xr-x   2 root root    4096 Feb 15 08:09 opt`
`dr-xr-xr-x 235 root root       0 Feb 26 15:33 proc`
`drwx------   3 root root    4096 Feb 15 08:11 root`
`drwxr-xr-x  18 root root     540 Feb 26 15:33 run`
`lrwxrwxrwx   1 root root       8 Apr 22  2024 sbin -> usr/sbin`
`drwxr-xr-x   2 root root    4096 Mar 31  2024 sbin.usr-is-merged`
`drwxr-xr-x   6 root root    4096 Feb 26 10:58 snap`
`drwxr-xr-x   2 root root    4096 Feb 15 08:09 srv`
`dr-xr-xr-x  11 root root       0 Feb 26 15:32 sys`
`drwxrwxrwt  12 root root    4096 Feb 26 15:58 tmp`
`drwxr-xr-x  12 root root    4096 Feb 15 08:09 usr`
`drwxr-xr-x  13 root root    4096 Feb 25 15:35 var`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250226222231.png]]

g) File Searching:
a. Search for all files with the extension ".txt" in the current directory and its subdirectories.
Ans:-
`cdac@Saket:~/LinuxAssignment$ find . -type f -name "*.txt"`
`./docs/file2.txt`
`./data.txt`
`./file1.txt`
`./docs1/docs/file2.txt`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227180158.png]]


b. Display lines containing a specific word in a file (provide a file name and the specific
word to search).
Ans:-
`cdac@Saket:~/LinuxAssignment$ grep "book" file1.txt`
`Books are man’s best friends. Books are portable and so they are easy to carry around. And so books can be read at any time night or day, while travelling on a bus or train or flight, and at meal time too. Books are published in many languages and in varied genres. There arebooks in fiction and non-fiction categories. Each of these categories has many different sections and genres, and there are many thousands of titles in each type. Every book title has an International Standard Book Number (ISBN) that is unique to it, and helps in identifying it. Today books are available as web versions too so that they can be read on the internet. They may be read on the modern kindle or on the computer. And books are available in audio versions too so that you can hear an entire book being read out aloud.`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250226231206.png]]

h) System Information:
a. Display the current system date and time.
`cdac@Saket:~/LinuxAssignment$ date`
`Wed Feb 26 17:54:42 UTC 2025`
`cdac@Saket:~/LinuxAssignment$ date +"%Y-%m-%d"`
`2025-02-26`
`cdac@Saket:~/LinuxAssignment$ date +"%H:%M:%S"`
`17:54:47`
`cdac@Saket:~/LinuxAssignment$ date +"%A, %B %d, %Y %I:%M %p"`
`Wednesday, February 26, 2025 05:54 PM`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250226232521.png]]

i) Networking:
a. Display the IP address of the system.
`cdac@Saket:~/LinuxAssignment$ ipconfig.exe`

`Windows IP Configuration`


`Wireless LAN adapter Local Area Connection* 9:`

   `Media State . . . . . . . . . . . : Media disconnected`
   `Connection-specific DNS Suffix  . :`

`Wireless LAN adapter Local Area Connection* 10:`

   `Media State . . . . . . . . . . . : Media disconnected`
   `Connection-specific DNS Suffix  . :`

`Wireless LAN adapter Wi-Fi:`

   `Connection-specific DNS Suffix  . :`
   `Link-local IPv6 Address . . . . . : fe80::599d:1c30:c213:a385%15`
   `IPv4 Address. . . . . . . . . . . : 192.168.1.2`
   `Subnet Mask . . . . . . . . . . . : 255.255.255.0`
   `Default Gateway . . . . . . . . . : 192.168.1.1`

`Ethernet adapter Bluetooth Network Connection:`

   `Media State . . . . . . . . . . . : Media disconnected`
   `Connection-specific DNS Suffix  . :`

`Ethernet adapter Ethernet:`

   `Media State . . . . . . . . . . . : Media disconnected`
   `Connection-specific DNS Suffix  . :`

`Ethernet adapter vEthernet (Default Switch):`

   `Connection-specific DNS Suffix  . :`
   `Link-local IPv6 Address . . . . . : fe80::b3a7:66f5:35ba:e38a%24`
   `IPv4 Address. . . . . . . . . . . : 172.23.112.1`
   `Subnet Mask . . . . . . . . . . . : 255.255.240.0`
   `Default Gateway . . . . . . . . . :`

`Ethernet adapter vEthernet (WSL (Hyper-V firewall)):`

   `Connection-specific DNS Suffix  . :`
   `Link-local IPv6 Address . . . . . : fe80::6a3a:4076:d6e:ca88%51`
   `IPv4 Address. . . . . . . . . . . : 172.20.176.1`
   `Subnet Mask . . . . . . . . . . . : 255.255.240.0`
   `Default Gateway . . . . . . . . . :`
`cdac@Saket:~/LinuxAssignment$`

![[Pasted image 20250226234143.png]]
b. Ping a remote server to check connectivity (provide a remote server address to ping).
`cdac@Saket:~/LinuxAssignment$ ping -c 4 google.com`
`PING google.com (142.250.77.46) 56(84) bytes of data.`
`64 bytes from bom07s26-in-f14.1e100.net (142.250.77.46): icmp_seq=1 ttl=116 time=23.1 ms`
`64 bytes from bom07s26-in-f14.1e100.net (142.250.77.46): icmp_seq=2 ttl=116 time=25.2 ms`
`64 bytes from bom07s26-in-f14.1e100.net (142.250.77.46): icmp_seq=3 ttl=116 time=23.3 ms`
`64 bytes from bom07s26-in-f14.1e100.net (142.250.77.46): icmp_seq=4 ttl=116 time=22.2 ms`

`--- google.com ping statistics ---`
`4 packets transmitted, 4 received, 0% packet loss, time 3266ms`
`rtt min/avg/max/mdev = 22.193/23.454/25.216/1.098 ms`
`cdac@Saket:~/LinuxAssignment$ ping -c 4 nasa.com`
`PING nasa.com (185.53.177.52) 56(84) bytes of data.`
`64 bytes from 185.53.177.52: icmp_seq=1 ttl=40 time=151 ms`
`64 bytes from 185.53.177.52: icmp_seq=2 ttl=40 time=150 ms`
`64 bytes from 185.53.177.52: icmp_seq=3 ttl=40 time=151 ms`
`64 bytes from 185.53.177.52: icmp_seq=4 ttl=40 time=150 ms`

`--- nasa.com ping statistics ---`
`4 packets transmitted, 4 received, 0% packet loss, time 3198ms`
`rtt min/avg/max/mdev = 150.216/150.777/151.387/0.554 ms`
`cdac@Saket:~/LinuxAssignment$ ping -c 4 jio.com`
`PING jio.com (49.40.8.179) 56(84) bytes of data.`

`--- jio.com ping statistics ---`
`4 packets transmitted, 0 received, 100% packet loss, time 3387ms`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250226235915.png]]
j) File Compression:
a. Compress the "docs" directory into a zip file.
 `cdac@Saket:~/LinuxAssignment$ ls`
`docs  file1.txt`
`cdac@Saket:~/LinuxAssignment$ zip -r docs.zip docs`
`Command 'zip' not found, but can be installed with:`
`sudo apt install zip`
`cdac@Saket:~/LinuxAssignment$ sudo apt install zip`
`[sudo] password for cdac:`
`Reading package lists... Done`
`Building dependency tree... Done`
`Reading state information... Done`
`The following additional packages will be installed:`
  `unzip`
`The following NEW packages will be installed:`
  `unzip zip`
`0 upgraded, 2 newly installed, 0 to remove and 0 not upgraded.`
`Need to get 350 kB of archives.`
`After this operation, 933 kB of additional disk space will be used.`
`Do you want to continue? [Y/n] y`
`Get:1 http://archive.ubuntu.com/ubuntu noble-updates/main amd64 unzip amd64 6.0-28ubuntu4.1 [174 kB]`
`Get:2 http://archive.ubuntu.com/ubuntu noble-updates/main amd64 zip amd64 3.0-13ubuntu0.2 [176 kB]`
`Fetched 350 kB in 1s (277 kB/s)`
`Selecting previously unselected package unzip.`
`(Reading database ... 47312 files and directories currently installed.)`
`Preparing to unpack .../unzip_6.0-28ubuntu4.1_amd64.deb ...`
`Unpacking unzip (6.0-28ubuntu4.1) ...`
`Selecting previously unselected package zip.`
`Preparing to unpack .../zip_3.0-13ubuntu0.2_amd64.deb ...`
`Unpacking zip (3.0-13ubuntu0.2) ...`
`Setting up unzip (6.0-28ubuntu4.1) ...`
`Setting up zip (3.0-13ubuntu0.2) ...`
`Processing triggers for man-db (2.12.0-4build2) ...`
`cdac@Saket:~/LinuxAssignment$ zip -r docs.zip docs`
  `adding: docs/ (stored 0%)`
  `adding: docs/file2.txt (stored 0%)`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  file1.txt`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227001302.png]]
b. Extract the contents of the zip file into a new directory.
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  file1.txt`
`cdac@Saket:~/LinuxAssignment$ mkdir docs1`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ unzip docs.zip -d docs1`
`Archive:  docs.zip`
   `creating: docs1/docs/`
 `extracting: docs1/docs/file2.txt`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ cd docs1`
`cdac@Saket:~/LinuxAssignment/docs1$ ls`
`docs`
`cdac@Saket:~/LinuxAssignment/docs1$ cd docs/`
`cdac@Saket:~/LinuxAssignment/docs1/docs$ ls`
`file2.txt`
`cdac@Saket:~/LinuxAssignment/docs1/docs$`
![[Pasted image 20250227001412.png]]
k) File Editing:
a. Open the "file1.txt" file in a text editor and add some text to it.
`cdac@Saket:~$ ls`
`Feb25  LinuxAssignment`
`cdac@Saket:~$ cd LinuxAssignment/`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ nano file1.txt`
`cdac@Saket:~/LinuxAssignment$ cat file1.txt`
`saket kharche`
`Cdac Mumbai`
`Feb25`
`Books are man’s best friends. Books are portable and so they are easy to carry around. And so books can be read at any time night or day, while travelling on a bus or train or flight, and at meal time too. Books are published in many languages and in varied genres. There are books in fiction and non-fiction categories. Each of these categories has many different sections and genres, and there are many thousands of titles in each type. Every book title has an International Standard Book Number (ISBN) that is unique to it, and helps in identifying it. Today books are available as web versions too so that they can be read on the internet. They may be read on the modern kindle or on the computer. And books are available in audio versions too so that you can hear an entire book being read out aloud.`
`Hey Good Morning every one`

`cdac@Saket:~/LinuxAssignment$`


![[Pasted image 20250227084023.png]]
b. Replace a specific word in the "file1.txt" file with another word (provide the original
word and the word to replace it with).
`cdac@Saket:~$ ls`
`Feb25  LinuxAssignment`
`cdac@Saket:~$ cd LinuxAssignment/`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ nano file1.txt`
`cdac@Saket:~/LinuxAssignment$ cat file1.txt`
`saket kharche`
`Cdac Mumbai`
`Feb25`
`Books are man’s best friends. Books are portable and so they are easy to carry around. And so books can be read at any time night or day, while travelling on a bus or train or flight, and at meal time too. Books are published in many languages and in varied genres. There are books in fiction and non-fiction categories. Each of these categories has many different sections and genres, and there are many thousands of titles in each type. Every book title has an International Standard Book Number (ISBN) that is unique to it, and helps in identifying it. Today books are available as web versions too so that they can be read on the internet. They may be read on the modern kindle or on the computer. And books are available in audio versions too so that you can hear an entire book being read out aloud.`
`Hey Good Morning every one`

`cdac@Saket:~/LinuxAssignment$ sed -i 's/Books/Food/g' file1.txt`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ cat file1.txt`
`saket kharche`
`Cdac Mumbai`
`Feb25`
`Food are man’s best friends. Food are portable and so they are easy to carry around. And so books can be read at any time night or day, while travelling on a bus or train or flight, and at meal time too. Food are published in many languages and in varied genres. There are books in fiction and non-fiction categories. Each of these categories has many different sections and genres, and there are many thousands of titles in each type. Every book title has an International Standard Book Number (ISBN) that is unique to it, and helps in identifying it. Today books are available as web versions too so that they can be read on the internet. They may be read on the modern kindle or on the computer. And books are available in audio versions too so that you can hear an entire book being read out aloud.`
`Hey Good Morning every one`

`cdac@Saket:~/LinuxAssignment$`



![[Pasted image 20250227084814.png]]

## Problem 2: Read the instructions carefully and answer accordingly. If there is any need to insert some data then do that as well.

a. Suppose you have a file named "data.txt" containing important information. Display the
first 10 lines of this file to quickly glance at its contents using a command.
`cdac@Saket:~$ cd LinuxAssignment/`
`cdac@Saket:~/LinuxAssignment$ ls`
`docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ touch data.txt`
`cdac@Saket:~/LinuxAssignment$ nano data.txt`
`cdac@Saket:~/LinuxAssignment$ head -10 data.txt`
`apple, blue, 27, dog, mountain`
`sun, red, 12, cat, river`
`book, green, 45, bird, forest`
`car, yellow, 8, fish, ocean`
`house, purple, 62, rabbit, desert`
`tree, orange, 19, horse, field`
`computer, brown, 33, mouse, city`
`phone, pink, 51, snake, jungle`
`chair, gray, 7, bear, cave`
`table, white, 22, lion, savanna`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227175529.png]]

b. Now, to check the end of the file for any recent additions, display the last 5 lines of
"data.txt" using another command.
`cdac@Saket:~/LinuxAssignment$ ls`
`data.txt  docs  docs.zip  docs1  file1.txt`
`cdac@Saket:~/LinuxAssignment$ tail -5 data.txt`
`time, metal, 95, snail, garden`
`space, glass, 29, ant, ground`
`light, wax, 16, bee, hive`
`water, clay, 71, fly, window`
`fire, sand, 43, spider, web`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227180414.png]]
c. In a file named "numbers.txt," there are a series of numbers. Display the first 15 lines of
this file to analyze the initial data set.
`cdac@Saket:~/LinuxAssignment$ nano numbers.txt`
`cdac@Saket:~/LinuxAssignment$ head -n 15 numbers.txt`
`1`
`2`
`3`
`4`
`5`
`6`
`7`
`8`
`9`
`10`
`11`
`12`
`13`
`14`
`15`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227181254.png]]
d. To focus on the last few numbers of the dataset, display the last 3 lines of "numbers.txt".
`cdac@Saket:~/LinuxAssignment$ tail -n 3 numbers.txt`
`28`
`29`
`30`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227181347.png]]
e. Imagine you have a file named "input.txt" with text content. Use a command to translate
all lowercase letters to uppercase in "input.txt" and save the modified text in a new file
named "output.txt."
`@Saket:~/LinuxAssignment$ nano input.txt`
`cdac@Saket:~/LinuxAssignment$ ls`
`data.txt  docs1        output.txt`
`docs      input.txt`
`docs.zip  numbers.txt`
`cdac@Saket:~/LinuxAssignment$ cat input.t`
`xt`
`this is a test.`
`hello world.`
`some more text.`
`1234 test words`

`cdac@Saket:~/LinuxAssignment$ tr '[:lower:]' '[:upper:]' < input.txt > output.txt`
`cdac@Saket:~/LinuxAssignment$ ls`
`data.txt  docs1        output.txt`
`docs      input.txt`
`docs.zip  numbers.txt`
`cdac@Saket:~/LinuxAssignment$ cat output.txt`
`THIS IS A TEST.`
`HELLO WORLD.`
`SOME MORE TEXT.`
`1234 TEST WORDS`

`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227184853.png]]
f. In a file named "duplicate.txt," there are several lines of text, some of which are
duplicates. Use a command to display only the unique lines from "duplicate.txt."
`cdac@Saket:~/LinuxAssignment$ ls`
`data.txt  docs  docs.zip  docs1  duplicate.txt  input.txt  numbers.txt  output.txt  uniqe1.txt`
`cdac@Saket:~/LinuxAssignment$ cat duplicate.txt`
`alpha`
`beta`
`gamma`
`alpha`
`delta`
`epsilon`
`beta`
`gamma`
`gamma`
`alpha`
`epsilon`
`delta`
`beta`
`cdac@Saket:~/LinuxAssignment$ sort duplicate.txt | uniq`
`alpha`
`beta`
`delta`
`epsilon`
`gamma`
`cdac@Saket:~/LinuxAssignment$`
![[Pasted image 20250227185615.png]]
g. In a file named "fruit.txt," there is a list of fruits, but some fruits are repeated. Use a
command to display each unique fruit along with the count of its occurrences in
"fruit.txt."
`cdac@Saket:~/LinuxAssignment/docs$ nano fruit.txt`
`cdac@Saket:~/LinuxAssignment/docs$ cat fruit.txt`
`apple`
`banana`
`apple`
`orange`
`banana`
`grape`
`apple`
`grape`
`mango`
`orange`
`mango`
`banana`
`pineapple`
`pear`
`kiwi`
`apple`
`pear`
`kiwi`
`grape`
`melon`
`melon`
`banana`
`cdac@Saket:~/LinuxAssignment/docs$ sort fruit.txt | uniq -c`
      `4 apple`
      `4 banana`
      `3 grape`
      `2 kiwi`
      `2 mango`
      `2 melon`
      `2 orange`
      `2 pear`
      `1 pineapple`
`cdac@Saket:~/LinuxAssignment/docs$`

![[Pasted image 20250227185834.png]]








