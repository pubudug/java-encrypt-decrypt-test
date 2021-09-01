Commands used to genearate the key pair and the cert

keytool -genkey -v -keystore server-keystore -alias server -keyalg RSA -keysize 2048 -validity 10000

keytool -export -alias server -file server.cer -keystore server-keystore

To run the program,

javac Program.java

Example:-

java Program ../server-keystore Q1QiztKmB0A9J+Cs7UQrUHlxk0K66U7js7obn+BLl4gMIX6QMerz8wwSy17J8fWsvot903VCWEt1UyUChezJ2ApDB4s4kW8dlJdC2UL+TsNBx+Hhozl016IJQmTHb9LEHJkXhfY0/Mwn5OwRKZJKWwOu+AV/DrZSpSDMrY6SLjGwMFC36O7FvvLJ6O4wueZGuqVBKqz9PqLBQH6wPISPETzIzOQM9+bYWABLcozhUUF5AziiIO5yg2c8Skich4wg7dwB5D915YVnltB1k40m9VItZFfSPIAdXC3Xnly1n1O29EAl/omrQ1wzbtiWiCgi5kj2oAXDegWAOFARD8Mn2Q== server

Prints "Encrypt this"
