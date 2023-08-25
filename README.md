# README #

"main" branch is the main branch of the project. It contains 4 different tags
release-1
release-2
release-3
release-4

## What is required to build the app
1. Java JDK 17
2. Android SDK (Command line tools only)


## How to pull the app from the repo
git clone https://github.com/TAvenger/todo_app_kotlin_mobile.git

## How to install dependencies.
1. Download Java JDK 17 from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html and install it
2. Download Command line tools only from https://developer.android.com/studio#downloads 
    2.1 Unzip it to the folder you want to install Android SDK to (e.g. ~/android_sdk)
        by this moment you should have the following folders in the ~/android_sdk folder:
        - ~/android_sdk/cmdline-tools/bin
        - ~/android_sdk/cmdline-tools/lib
    2.2 Create folder "latest" in the "cmdline-tools" folder and move all the content from cmdline-tools folder to the "latest" folder

    2.3 After that you should have the following folders in the ~/android_sdk folder:
        - ~/android_sdk/latest/bin
        - ~/android_sdk/latest/lib
    
    2.4 Add the following lines to your ~/.zshrc file:
        export ANDROID_HOME=~/android_sdk/
        export ANDROID_SDK=~/android_sdk/
        export JAVA_HOME=`/usr/libexec/java_home -v 17`

    relaunch terminal or run the following command:
        source ~/.zshrc

## How to build the app
   Open terminal and run the following command:
   ./gradlew assembleDebug

   APK file will be generated in the following folder:
   app/build/outputs/apk/debug/app-debug.apk

## How to run unit tests
   Open terminal and run the following command:
   ./gradlew testDebugUnitTest