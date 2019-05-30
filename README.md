


# NetMonitor
![](Images/LogoAC.png)   
#### Application for monitoring network status
- DNS status
- WAN/internet status
- DHCP/IP status
- Connection speed
- Internet speed (run a speedtest on boot, then maybe       monitor how much is used and present it as a
bar to show how much speed is available)
- Possibly write a script to reboot the router (remote reboot by the click of a button)
- Display number of connected units
- Display number of packets going in/out at any time
- Adjustable parameters for checks (file sizes, timeouts)

## Initial planned frameworks
- Simple java command line application
- SQL hook for storing and presenting history
- XML/JSON API to get data on other devices

## Motivation
NetMonitor was created to be a part of a open source project at the University of Agder.
More specifically it exists as a contribution of an open source project for students in the subject [IS-213 OPEN SOURCE](https://www.uia.no/en/studieplaner/topic/IS-213-1)
to contribute as an introductory idea of the open source working method.  
The developers of the project felt that it would be useful to have some sort of tool to easily access the functions mentioned above beneath "NetMonitor".
The maintenance within the project is to deliver a product concluding the subject IS-213.
Further maintenance will be unlikely, but the project is open for development and iteration.

## Code Standards
Methods should be named after what they do and what they return. In camelCase.
Use standard "get"/"set"Field names for methods, and make sure methods can return fields that are necessary for the GUI.

Keep information hidden as much as possible, and only pass values with getters and setters.

In the GUI class, keep all related items bunched together. I.e: Related buttosn and panels should be close, and the draw methods should be close to the element definitions.

## Screenshots

![](Images/IndicatorMac.png) 

 

## Technology used
Built with [IntelliJ](https://www.jetbrains.com/idea/), by JetBrains   
Developed with [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)     
Github Desktop & GitKraken

## Features
- DHCP/IP status
- WAN/internet status
- Internet speed (run a speedtest on boot)
- Adjustable parameters for checks (file sizes, timeouts)
- Display number of packets going in/out at a specific scenario


## Installation / Running
Provided by a Java Main:   
Executed in Terminal / Command prompt

## Tests
No test examples added.
Worked towards functionally rather than uptime/bugs

## How to use?
To use our project run the Main within the project in terminal for Mac OS X
 and run it within command prompt on any windows version allowing JDK 11.

 ## Contribute
 #### Getting started:  
 This application is made with IntelliJ. You can find a great guide for IntelliJ [here](https://www.jetbrains.com/idea/documentation/).
 For easier understanding of the project Syntax.
 
 #### Community: 
 We appreciate student contributing belonging to a student alumni among different universities around the world.

 ##### We wish for people to contribute with:  
 -Improvement of functions through GUI  
 -Adding features mentioned above beneath "NetMonitor" into the
 program which currently are not found in Features.  
 -Adding tests to the methods within the program.

 ## Credits   
 #### AltUnderCtrl:      
 Jostein Våga Rygg   
 Joakim Schjølberg   
 Marius Tjøstheim   
 Kristian Jul-Larsen   
 Henrik Lindseth

 ## License
 GPL v2 CE [*LICENSE*](LICENSE)   
 
