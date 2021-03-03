# BASF_Frontend

Contents

   1.  Introduction
   2.  Installation
   3.  Components and structure a) application structure b) code structure c) goal 
   4.  Final result

Introduction
 My project was made in Java using Maven, Junit, WebDriver in SpringToolSuite. As a browser I chose the chrome. In the Instalation part you can find instalation links for all these elements. Below is the path of each test:
LOGIN
GIVEN opened url WHEN I provide credentials AND click 'Log In' THEN I am redirected to the Main page AND assert the logo
SEARCH
GIVEN I am logged in AND have a word of which I have min 3 results WHEN I type the word to the search box AND click 'Search' button THEN I assert that search word appears in first 3 abstracts

Installation 
For download: Chrome Driver - https://chromedriver.chromium.org/downloads Selenium Java v3.8.1, apache maven 3.5.2 - https://selenium.dev/downloads/ jdk 11.0.1 - https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html Spring Tool Suite - https://spring.io/blog/2017/12/22/spring-tool-suite-3-9-2-released Libraries: JUnit 3.8.1 -4.1.2 Maven Dependencies

How to set up the environment: https://www.edureka.co/blog/selenium-installation/

In the Generic class in System.setProperty: 
@Before public void setup() throws MalformedURLException { 
System.setProperty("webdriver.chrome.driver", "C:\Programowanie\chromedriver.exe"); 
driver = new ChromeDriver(); 
driver.get("https://qknows-qa.basf.com/"); 
logger.info("WebDriver used: " + driver); 
driver.manage().window().maximize(); 
} 
change C:\Programowanie\chromedriver.exe to the path were you downloaded and unpacked the Chrome Driver 

Components and structure 
a) application structure
Project is written with used the PageObject Concept and consists of 3pages: Basf.Form, Pages, Tests. In Basf.From is possible to find the Generic class with the environemnet setup.  In this class are placed also @Before and @After which open and close every @Test implemented in the Login and Search classes. Pages includes classes with the elements of the sites of the application: Login page, Terms Of Use and Main Page. There ares stored paths to the elements of each site and methods calling them. The final part to execute is store in Tests where are two tests: LogIn and Search described in the section above.
b) code structure 
Every element and method in the code highlights the element and action on the website.
c) goal 
The goal of the test is to confirm the happy path. To do this in the Login test I added the assertion which looks for the QKnows logo

Final result 
If the test passed succesfully then the green stripe will be visible in the JUnit tab in your IDE. If will appear any error, then the red one will be displayed with the bug description below.
Both tests passes on my local machine. 

Pawel Grabowski
