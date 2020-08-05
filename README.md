# posrocket
____________________________________

you need to install 
1. [jdk 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. [maven](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/)

to run the code
1. cd to directory
2. `mvn clean package assembly:single`
3. `java -jar .\target\assesment-1.0-SNAPSHOT-jar-with-dependencies.jar <input_file_path>` example `java -jar .\target\assesment-1.0-SNAPSHOT-jar-with-dependencies.jar C:\Users\HP\Desktop\transaction.xml`
