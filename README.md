# README #

"main" branch is the main branch of the project. 

You can find release details in [CHANGELOG](./CHANGELOG.md)

## What is required to build the app
1. Java JDK 17
2. Android SDK (Command line tools only). The latest avaiable version by the link below


## How to pull the app from the repo
```sh
git clone https://github.com/TAvenger/todo_app_kotlin_mobile.git
```

## How to install dependencies.
1. Download Java JDK 17 from [https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) and install it
2. Download Command line tools only from [https://developer.android.com/studio#downloads](https://developer.android.com/studio#downloads)
 
    2.0 Note: 
        1) these 2.X steps are written for **Mac OS**. Perhaps it can be reused without changes for Ubuntu. For Windows you will need to 
        perform Windows-specific steps (updating and configuring PATH)
        2) There is no direct download link because Google requires to accept terms and conditions on that page before downloading 

    2.1 Unzip it to the folder you want to install Android SDK to (e.g. ~/android_sdk) <br>
        by this moment you should have the following folders in the ~/android_sdk folder: <be>

        
        ~/android_sdk/cmdline-tools/bin 
        ~/android_sdk/cmdline-tools/lib 
        

    2.2 Create folder ```latest``` in the ```cmdline-tools``` folder and move all the content from ```cmdline-tools``` folder to the ```latest``` folder

    2.3 After that you should have the following folders in the ~/android_sdk folder: <be>

        
        ~/android_sdk/latest/bin 
        ~/android_sdk/latest/lib 
        
    
    2.4 Add the following lines to your \~/.zshrc file: <br>

        
        export ANDROID_HOME=\~/android_sdk/ 
        export ANDROID_SDK=\~/android_sdk/ 
        export JAVA_HOME=\`/usr/libexec/java_home -v 17\` 
        

    relaunch terminal or run the following command: <br>

      ```      
        source ~/.zshrc
      ```       

## How to build the app

Open terminal and run the following command: 

    
        ./gradlew assembleDebug
    
APK file will be generated in the following folder: 

    
        app/build/outputs/apk/debug/app-debug.apk
    

## How to run unit tests
Open terminal and run the following command: <br>


    ./gradlew testDebugUnitTest


if tests run **successfully** you should see the message    "BUILD SUCCESSFUL in XXs"  and the exit code should be 0. <br>
If something went **wrong** you would see   "BUILD FAILED in XXs"   and the exit code would be other than 0
