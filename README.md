# NetMonitor
Application for monitoring network status using an Arduino

- Display WiFi signal strength (dB/"readable"/progressive LEDs)
- DNS status
- WAN/internet status
- DHCP/IP status
- Connection speed
- Internet speed (run a speedtest on boot, then maybe       monitor how much is used and present it as a
bar to show how much speed is available)
- Possibly write a script to reboot the router (remote reboot by the click of a button)
- Display number of connected units
- Display number of packets going in/out at any time
- Maybe make it mesh/remote to allow for some basic network monitoring for system
administration?

# Initial planned resources and frameworks
- Arduino
- Arduino WiFi card
- Python
  -  Easy to write
  -  Easy to interface with Arduino
  -  Good library
  -  Open source language
- Django
  - Simple but powerful
  - May not be necessary if we get the Arduino to run a graphical interface by itself

# Initial concerns
For the application to work, we need a varying level of (admin?) access to a network(router/switch/access point).

The goal is to make this deployable by either an administrator or a home user, where both have easy access to whatever they should need, so we need to simulate this during development.

## Security
Seeing as this is supposed to access a lot of information from a network, we need to make sure that it doesn't open up a door for malicious activities.     
One idea is both a MAC filter and a password protected user in the router.      
Alternatively the arduino could simply act as a display that fetches information from a server (can we do both?)
-In this case, Python comes in handy with a simple interface for interacting with databases.


