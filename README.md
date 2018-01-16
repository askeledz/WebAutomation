# Selenium Grid (PageObjectModel)

An example project that runs JUnit tests in parallel using TestNG.
To drive the browsers I use Selenium WebDriver.
Tests can be executed locally or remotely.
Project is created on MacBook Pro (Retina, 13-inch, Early 2015), OS X El Capitan.

# IMPORTING PROJECT TO IntelliJ IDEA
1. Import Project --> Select project root dir --> Create Project from Existing Sources
2. Extract lib.zipxxxx fiel and import to build path: File --> Project Structure - Libraries (+ button)-->Java. Or you can download Selenium JARS (selenium-server-2.53.1.zip) from following location: http://selenium-release.storage.googleapis.com/index.html?path=2.53/ and import them on same way.
3. Download and install Firefox v46.0
https://ftp.mozilla.org/pub/firefox/releases/46.0/

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

    java -jar selenium-server-standalone-2.53.1.jar -role hub -hubConfig DefaultHub.json

Then register the nodes:

Chrome:

    java -jar selenium-server-standalone-2.53.1.jar -Dwebdriver.chrome.driver=/Users/askeledzija/Documents/Private/Development/workspace/web-automation/chromedriver -role node -nodeConfig DefaultNodeWebDriver.json

## How to run REMOTE tests from IDE
Simply right click on the "src/test/resources/RemoteWebDriverListener.xml" for remote config usage and "Run As....".
Please be sure that your HUB and NODES are up&running.


## Known issues
