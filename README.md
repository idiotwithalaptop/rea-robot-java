REA ROBOT
=========

By Ryan Brown

 

Building REA-ROBOT
------------------

This section describes how to build the REA-ROBOT application.

 

### Prerequisites

In order to build REA-ROBOT, you need the following pre-requisites:

-   [Java SDK][1] (at least 1.5)

    [1]: <http://www.oracle.com/technetwork/java/javase/downloads/index.html>

-   [Apache Maven 3][2]

    [2]: <http://maven.apache.org/download.cgi>

-   Archive Utility of your choice that supports .tar.gz file formats

 

### Getting Started

Once you have installed the pre-requisites, the next step is to extract the
rea-robot package using your choice of archive utility.  For example, to extract
this using the command line tar command:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> tar -xvzf RYAN_BROWN.tar.gz
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

### Running a build

Open a command prompt window and change to the directory where you extracted the
rea-robot package.  From there, use Maven 3 to build the REA-ROBOT application
(NOTE: If this is the first time you are build REA-ROBOT, be sure to have a
working internet connection in order to allow Maven 3 to download the
dependencies) using the command:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> mvn clean assembly:assembly
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

Running REA-ROBOT
-----------------

After building, the REA-ROBOT executable jar can be found in the resulting
“target” directory (Note: For the sake of portability, a redistributable copy
can also be found as a packaged zip archive in the “target/dist” directory).
From the target directory, issuing a simple java command will launch REA-ROBOT:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

REA-ROBOT runs commands passed in from the standard input, so there are two
simple ways to issue commands to the REA-ROBOT:

1.  Run using the command above and issuing commands directly from there. For
    example:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar 
> PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT 
> 3,3,NORTH
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

1.  Run using a pre-defined file and redirecting it into the standard out

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar < path/to/command_file
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

In order to make this simple, I have also provided a number of simple example
command files.  These can be run using the following commands:

**Moves the robot in a spiral**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar < spiral.path
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

**Moves the robot diagonally from the bottom left (0,0) to the top right (5,5)**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar < diagonal.path
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

**Moves the robot in an X, starting from the top left (0,5) to the bottom right
(5,0).  Then starting again from top right (5,5) down to the bottom left
(0,0).**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
> java -jar rea-robot-1.0.jar < xmarksTheSpot.path
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
