# Smart Bear POM JUnit Parallel Project

## How to run JUnit tests inside the project

###In order to run parallel tests using Selenium Grid and JUnit as testing framework. Please follow these instructions
***
1) Set up the hub and the node 
   > 1) To do so open the com.smartbear.seleniumgrid3 package under test/java in windows explorer from your editor
   > 2) Once open, double click on runHub.bat file and run and wait till hub started(press any key to continue)
   > 3) Now double click on runNodes.bat file and run to start/register two nodes(press any key to continue)
   > 4) Open http://localhost:4444/grid/console on browser to see hub and nodes are configured.
   
2) Now to run parallel Selenium test using Grid and JUnit there are two tests depicting different ways to run Selenium JUnit tests in parallel
   > 1) Right click on GridParallelComputerTest.java under com.smartbear.junitparalleltests package and run
   > 2) Right click on GridParallelTest.java under com.smartbear.junitparalleltests package and run