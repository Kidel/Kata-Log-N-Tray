# (Kata) Log 'N Tray
Code kata. 

A simple Java+Node+MongoDB application to login and comunicate your status interacting with a tray icon. The user can log in from the Java client and change his/her status (using cookies and session). If the user makes no actions for 1 hour (default), the server will mark him/her as logged out. After the login, the client will reduce to tray, and the icon will change according to the selected status.

## Instructions
* Build the contents of /LogNTray as a Java application. External libraries are in ```lib.zip```.
* You can also run an **example** server by using ```start_mongo_service``` (you need mongod in your PATH), ```npm install``` and ```npm start``` in the root foolder. The example server will provide REST APIs to login (post), logout (post), update the status (post), list the users (get) and create example users (get). By default it's on port 3000.
