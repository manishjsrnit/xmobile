xmobile
===================
xmobile is a simple tool to measure mobile experience. For any android application it generates an experience report about  
1. Page tranistion  
2. Launch time  
3. Responsiveness  

### Details
Unfortunately most of the factors that define a user's mobile experience are tough to quantify, there is also a lack of comparision with peers, this tool tries to address this gap by giving a rating. For apps in the same class (complexity, functionality) app developers can compare with existing ratings and arrive at conclusions about the experience their applications offer.

It generates a rating (1-100) for these parameters based on profiling the application from multiple perspectives like GC Overhead, Activity in Back Stack, Overdraw Count

### Build
To build the project use mvn, mvn install will build the child modules android-tool and web. cd to web and run mvn jetty:run to start the http server. Browse to http://localhost:8080/static for viewing the report. To change the port and any other detail for http server look into jetty:run documentation.

### References  
[Performance Tuning on Android](http://blog.venmo.com/hf2t3h4x98p5e13z82pl8j66ngcmry/performance-tuning-on-android)




