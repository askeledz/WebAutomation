# Selenium Grid (PageObjectModel)

An example project that runs JUnit tests in parallel using TestNG.
To drive the browsers I use Selenium WebDriver.
Tests can be executed locally or remotely.
Project is created on MacBook Pro (Retina, 13-inch, Early 2015), OS X El Capitan.

# IMPORTING PROJECT TO ECLIPSE
1. File --> Import --> Existing Maven Project (Please be aware that there is no dependencies)
2. Right click on project --> Build path --> Configure Build Path --> Libraries --> Add External JARs --> Select All JAR files from the "lib" folder. Or you can download Selenium JARS (selenium-server-2.53.1.zip) from following location: http://selenium-release.storage.googleapis.com/index.html?path=2.53/ and import them on same way.

## Configuration
Before you run your tests locally or remotely, you need to:

* decide in what browsers you want to run them (I use Chrome, Firefox and IE) 
* configure TestNG XML suites accordingly (they are in src/test/resources).
* if you want use Chrome, type "chrome", for Internet Explorer, type "ie" for parameter browserName, etc...
* I run tests on Internet Explorer with Virtual Machine since I use MacOS.


## How to run LOCAL tests from IDE
Simply right click on the "src/test/resources/LocalWebDriverListener.xml" and chose "Run As...."

### Remote configuration
You don't have to change anything in project, simply:

Start the hub

    java -jar selenium-server-standalone-3.8.1.jar -role hub -hubConfig DefaultHub.json

Then register the nodes:

Chrome:

    java -Dwebdriver.chrome.driver=/Users/askeledzija/Documents/Private/Development/selenium/driver/chromedriver -jar selenium-server-standalone-3.8.1.jar -role node -nodeConfig DefaultNodeWebDriver.json

## How to run REMOTE tests from IDE
Simply right click on the "src/test/resources/RemoteWebDriverListener.xml" for remote config usage and "Run As....".
Please be sure that your HUB and NODES are up&running.


## Known issues
