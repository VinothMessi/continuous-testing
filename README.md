# continuous-testing
Continuous Testing pipeline using GCP (Spring Boot/Java/Maven/Selenium/TestNG)

**Step1:**
  Create a public repository in GitHub -> continuous-testing (with ReadMe.md file)

**Step2:** Clone the repo to your local drive location -> git clone https://github.com/VinothMessi/continuous-testing.git

**Step3:** 

      1. Generate a spring boot project (continuous-testing) using spring initializr and extract the contents under the local drive location
      2. Commit the same to the local repository and finally push it to the remote repo
      3. Make sure both the local/remote repos are in sync
      
 **Step4:** 
 
      1. Add the necessary dependancies in pom.xml (for build/compile/test process)
      2. Make sure all imports of the dependancies are working fine
      3. Create sample test cases and execute - maven package lifecycle
      
 **Step5:**
 
      1. Create Local Browsers configuration -> **@Bean** for chrome,firefox,edge,headlessChrome and headlessFirefox -> @Profile("local")
      2. Create Docker Browsers configuration -> **@Bean** for chrome and firefox -> @Profile("docker-grid")
      3. Create Selenoid Browsers configuration -> **@Bean** for chrome,firefox and edge -> @Profile("selenoid-grid")
      
![image](https://user-images.githubusercontent.com/34208574/129774102-bd6d7705-9540-4763-aead-5f2f4767e05f.png)


      
 

