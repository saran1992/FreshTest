# Fresh Test
### UI Automation using Selenium+Maven+TestNG with AI powered live dashboard(reportportal.io)

##### Prerequisites:
- Apache maven
- JDK 8+

To run the test in chrome browser, enter the following command in the terminal:

`$mvn clean test -Dbrowser=chrome -Denvironment=production -Dsurefire.suiteXmlFiles=regression.xml`

To run the test in firefox browser, enter the following command in the terminal:

`$mvn clean test -Dbrowser=firefox -Denvironment=production -Dsurefire.suiteXmlFiles=regression.xml`

The chrome and firefox .exe files are already part of the framework. Incase you're not running as an admin, make sure you give full permission to the drivers by running the following command,

`$chmod +x chromedriver`
(or) 
`$chmod 777 chromedriver`

###### Runtime parameters explanation:

- browser - the browser name for the tests to be run(If the parameter is not added in the runtime, by default chrome browser will be selected)
- environment - the folder in which the test data should be initialized(By default it is production) . Test data are placed under the TestData folder in root
- surefire.suiteXmlFiles - specify which test suite to run (regression.xml / sanity.xml)

### Reports and logs
After the execution is completed, a human readable test report will be generated under the folder TestReport. The report will be in html format and the steps will be logged for each test case.


### (Optional) Steps for configuring AI-powered live dashboard(reportportal.io):
1) Make sure the Docker Engine and Compose are installed.

2) Download the latest ReportPortal Docker compose file from here. You can make it by run the following command:

`$curl https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml -o docker-compose.yml`

3) Give right permissions to ElasticSearch data folder using the following commands:

```shell
$mkdir -p data/elasticsearch
$chmod g+rwx data/elasticsearch
$chgrp 1000 data/elasticsearch
```

4) Now, compose the downloaded docker-file,
`$docker-compose -p reportportal up -d --force-recreate `

5) Go to localhost:8080 and login with default admin credentials (superadmin/erebus)

Project Config:
Create `reportportal.properties` file under src/test.resources with following parameters

```
rp.endpoint = http://localhost:8080
rp.uuid = YOUR_KEY
rp.launch = YOUR_LAUNCH
rp.project = YOUR_PROJECT
```

Above keys can be copied from  localhost:8080 -> Profile Settings
If the reportportal image is running in a host machine, the IP address of the machine should be given as endpoint

###Additional Libraries/Plugins Used:
- Extent Reports : For generating e-mailable reports
- Epam report portal : For enabling live dashboard
- Surefire plugin :  Used during the test phase of the build lifecycle to execute the tests


Now, we are all set :)
