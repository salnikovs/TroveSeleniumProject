1. Instructions for installing and setting up the testing harness framework.

 This testing framework is built around Selenium Webdriver + JUnit + Maven
 Before you can start make sure you have all of them installed.

 * Download Selenium Webdriver for Chrome browser from here: https://sites.google.com/a/chromium.org/chromedriver/    (you need to check against your current version of Chrome browser to find matching chromedriver).
 
 !!! Very important !!! I order to get the project up and running you need to save chromedriver.exe to a specific folder: "C:\\Program Files\\chromedriver\\chromedriver.exe"


 * Download Maven from here: https://maven.apache.org/download.cgi (download binary zip archive)     (make sure you unpack the archive to a dedicated folder and set the environment variables on your machine tied to that folder).
   Once you done with this run this command in CL: mvn -v        -this should return you maven version installed on your computer.

 * Download the project from this repo: https://github.com/salnikovs/TroveSeleniumProject.git
 


2. Instructions to download your automation script.

 Simply go to:  https://github.com/salnikovs/TroveSeleniumProject.git
 download the project to a dedicated folder.




3. Instructions to run your automation test.

 Once the project is downloaded, open command line, CD -> to the project folder.




 In this project there are two patterns applied: Page Object Pattern and PageFactory, so the structure is looking pretty much specific.
 There're 5 pages described in details and each has its own test suite. Due to limited time not all the test-cases are automated, this project is serving the idea of showing the concept.
 
  
 to run the main scenario that covers the whole story run the next command in the command line: mvn clean -Dtest=mainScenario_Test test

 to run page specific tests run the next commands:
 
 * mvn clean -Dtest=landingPage_Test test           - stands for landing page test
 * mvn clean -Dtest=shoesAndFilters_Test test       - stands for testing of filters and shoes grid
 * mvn clean -Dtest=productDescription_Test test    - stands for product descrption page test
 * mvn clean -Dtest=cartPage_Test test              - stands for cart page testing
 * mvn clean -Dtest=checkoutPage_Test test          - stands for checkout page testing
 