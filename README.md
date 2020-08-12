# CSX42: Assignment 5
## Name: Shrijeet Rupnar
## B-00808280

-------------------------------------------------------------------------

Due Date:  August 05, 2020 
Submitted date : August 08, 2020 
Author(s): Shrijeet Rupnar 
e-mail(s): srupnar1@binghamton.edu

PERCENT COMPLETE: I believe I have completed 100% of this project.

BUGS: No bugs.

Note :

I am using 3 Slack days.Kindly make a note of it.


---------------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [textdecorators/src](./textdecorators/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile textdecorators/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile textdecorators/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile textdecorators/src/build.xml run -Dinput="input.txt" -Dmisspelled="misspelled.txt" -Dkeywords="keywords.txt" -Doutput="output.txt" -Ddebug="2"
```
Note: Arguments accept the absolute path of the files.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Description:

Program to implement Text Decorators pattern :


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Provide justification for Data Structures used in this assignment in term of Big O complexity (time and/or space):

1.List :
To insert a data into ArrayList it take always a constant time O(1) operation.
To get a data from ArrayList it take always a constant time O(1) operation.
indexOf() – also runs in linear time. It iterates through the internal array and checking each element one by one. So the time complexity for this operation always requires O(n) time


2.Map

LinkedHashMap - I have used LinkedHashMap to find the most frequent word. LinkedHashMap has complexity of O(1) for insertion and lookup.
 
3.Display
I have used list data structure in result class to store the final result. Complexity to add element is O(n).



---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [08/08/2020]

citation:

https://stackoverflow.com/questions/13597373/writing-a-list-to-a-file
https://stackoverflow.com/questions/1936462/java-linkedhashmap-get-first-or-last-entry




