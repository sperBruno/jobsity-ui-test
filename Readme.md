JobSity

Automation UI testing POC for http://automationpractice.com web application.

**Requeriments:**
1. JAVA 8 JRE and JDK defined on classpath.
2. Gradle defined on the classpath (To install follow the steps on https://gradle.org/install/)
3. Intellij idea IDE installed

**Step to run feature file**
1. Open Jobsity-selenium project with the intellij idea IDE.
2. Enable auto import option or wait while gradle dependencies are being installed.
3. Open a CMD console
4. Navigate to the jobsity-selenium project path
5. Execute following command gradle executeFeatures
6. Open build/report/cucumber-html-report/index.html to see execution report
