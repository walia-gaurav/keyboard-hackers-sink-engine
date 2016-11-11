# keyboard-hackers-sink-engine

## Setting up the database
1. Install MySQL on your OS.
2. Run create.sql (as a script, or copy/paste onto editor)
3. This script will create the required tables for the web application to run.

## Build the project
1. After cloning or downloading the project, run **mvn clean install** on the project base directory.
2. This will compile the code, and package it into a web archive (popularly known as .war)

## Set up a web server
1. Download a light-weight web server. Preferably Jetty! (jetty-distribution-9.3.5.v20151012)
2. Copy the generated .war from the previous step to jetty-distribution-9.3.5.v20151012/webapps/ROOT.war (Note, you should rename your .war to .root)
3. Go to jetty-distribution-9.3.5.v20151012/start.ini and look for 'jetty.http.port'. Change it to '8080'.
4. Run jetty server by **sh jetty-distribution-9.3.5.v20151012/bin/jetty.sh run**
5. Check logs using **tail -100f jetty-distribution-9.3.5.v20151012/logs/YOUR_DATE.stderrout.log**

## REST API Specifications
1. Go to file **rest-specs.js**
2. This contains information about all APIs, and includes javascript code to consume the APIs too.

## Contact Me ##
gaurav.walia@cmu.edu

