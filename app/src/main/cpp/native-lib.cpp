#include <jni.h>
#include <string>

//extern "C" JNIEXPORT jstring JNICALL
//Java_com_example_something_MainActivity_stringFromJNI(
//        JNIEnv* env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_something_App_apiKey(
        JNIEnv* env,
        jobject /* this */) {
    std::string api_key = "AIzaSyDCDBpz0DmShtFMGVgMQTNRSsj-p4QwpF0";
    return env->NewStringUTF(api_key.c_str());
}