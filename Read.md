`In order to run parallel tests using Selenium Grid and JUnit as testing framework.
Please follow these instructions

1) Set up the hub and the node
    a) To do so open the com.smartbear.seleniumgrid3 package under test/java in windows explorer from your editor
    b) Once open, right click on runHub.bat file and run as admin and wait till hub started
    c) Now right click on runNodes.bat file and run as admin to start/register two nodes
    d) Open http://localhost:4444/grid/console on browser to see hub and nodes are configured.
   
2) Now to run parallel Selenium test using Grid and JUnit there are two options
    a) Right click on GridParallelComputerTest.java under com.smartbear.junitparalleltests package
    b) Right click on GridParallelTest.java under com.smartbear.junitparalleltests package`