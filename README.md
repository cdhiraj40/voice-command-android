# voice-command-android
A simple voice command bot with voice triggers made using aimybox, kaldi speechkit and vosk

# Result

https://user-images.githubusercontent.com/75211982/163027920-8ae70a2a-bc8b-47ec-939e-063422262be1.mp4

# Libraries used
The bot uses following open-source libraries: 
## 1. [Aimybox SDK](https://github.com/just-ai/aimybox-android-sdk/)
The application uses mainly Aimybox Android SDK to create a voice assistant. The main reason for me to use Aimybox is that its really easy to integrate into any new or existing Android project. Along with this it provides ready to use modules of speech to text, text to speech which can be easily customized. There is definitely more features than this that <b>Aimybox SDK</b> provides and they all are worth checking out. you can give it a read from [here](https://help.aimybox.com/en/article/android-sdk-overview-1ih4xn7/).

### Different modules from Aimybox SDK
1. [Aimybox Core](https://help.aimybox.com/en/article/core-android-sdk-2gs13n/)
Core Android SDK provides the main Aimybox service that manages all nested processes of every voice assistant application.

2. [Google platform speechkit](https://github.com/just-ai/aimybox-android-sdk/tree/master/google-platform-speechkit)
Another module that is provided by <b>AimyBoxSpeech</b> Google platform speechkit. It is the same good old android's recognition and synthesis by Google Services. The reason to use this is pretty straight-forward that is to not write alot of implementations. It gives us direct functions that makes the whole process really easier.

## 2. [Vosk-Android](https://github.com/alphacep/vosk)
Vosk is a speech recognition toolkit. It gives an offline support to around 20+ languages. It is pretty lightweight and gives portable per-language models of around 50Mb each that can be easily integrated with your application, but because of small size it does come with a drawback i.e. less accurate. If you are not worried about an offline integration then it does provide bigger server models too that are more accurate. one can read more about vosk from [here](https://alphacephei.com/vosk/).

In this project we are using vosk library with custom implementation of kaldi. A demo implementation can be seen from [here](https://github.com/alphacep/vosk-android-demo) and if you would like to read then this is the [place](https://alphacephei.com/vosk/android) to go.
The aimybox-sdk does provide a support for this directly in its library, but unfortunately it seems like it has not been maintained properly and it will give you build errors while importing it and building. This was the reason, I have added kaldi-vosk's custom implementation separately [here](https://github.com/cdhiraj40/voice-command-android/tree/main/app/src/main/java/com/example/myapplication/kaldi_speech_kit). One can look the vosk-kaldi implementation from Aimybox library from [here](https://github.com/just-ai/aimybox-android-sdk/tree/master/kaldi-speechkit)

<b>Currently this part is used for voice triggers</b>




