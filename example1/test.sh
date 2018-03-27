### this is test scripts #
export ANDROID_HOME=/Users/alice/Library/Android/sdk
export PATH=${PATH}:${ANDROID_HOME}/tools
export PATH=${PATH}:${ANDROID_HOME}/platform-tools
#build
./gradlew clean
./gradlew assembleDebug installDebug
./gradlew assembleDebugAndroidTest installDebugAndroidTest

#test

adb shell am instrument -w -r   -e debug false -e class com.application.example1.ExampleInstrumentedTest com.application.example1.test/android.support.test.runner.AndroidJUnitRunner
