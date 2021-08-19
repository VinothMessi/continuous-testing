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
![image](https://user-images.githubusercontent.com/34208574/129863172-d710becf-f55f-4c90-b627-240343d1b397.png)
![image](https://user-images.githubusercontent.com/34208574/129863297-b8fea912-c102-41f6-9169-5351a0869d9e.png)

**Step6:**

      1. Create WebDriverWait configuration
      
![image](https://user-images.githubusercontent.com/34208574/129940587-402322d5-c667-41a7-8f0a-25802b461a7b.png)
      
**Create docker-compose files for disposable/scalable Docker/Selenoid grids ---> docker-grid.yml && selenoid-grid.yml**
      
Access docker-grid using: http://localhost:4444/grid/console

Access selenoid-grid using: http://localhost:8090/#/ (Live Preview)

**Configuring Jenkins Master in GCP:**

**VM1:**

Create a VM (Ubuntu 18.0.4) in GCP and name it as Jenkins-Master

![image](https://user-images.githubusercontent.com/34208574/130090677-5f528417-cf6b-4cfb-a96e-b220842100a8.png)

1. Install configure Java 11, Maven 3.8.2, GIT and Jenkins in the above VM using the ---> Installing-Jenkins.text file
2. Configure the initialAdministrator password and Install all the default plugins
3. Create a Maven project and create a job which pulls the code from GIT and package it

Access Jenkins using: http://<machine IP>:8080/

**VM2:**
      
Create a VM (Ubuntu 18.0.4) in GCP and name it as JFrog-Artifactory

![image](https://user-images.githubusercontent.com/34208574/130112243-bbfaa834-ccca-47c5-89a3-932139417f7c.png)

1. Install configure Java 11, Maven 3.8.2, GIT and J-Frog Artifactory in the above VM using the ---> Installing-JFrog-Artifactory.text file
2. Login J-Frog Artifactory using **default username: admin and password: password**
3. Change the password after the initial login
4. Create **2 local repositories : one for release and the another for snapshots**
  
Access J-Frog Artifactory using: http://<machine IP>:8081/artifactory
