package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.kaldi_speech_kit.KaldiAssets
import com.example.myapplication.kaldi_speech_kit.KaldiVoiceTrigger
import com.justai.aimybox.Aimybox
import com.justai.aimybox.api.aimybox.AimyboxDialogApi
import com.justai.aimybox.components.AimyboxProvider
import com.justai.aimybox.core.Config
import com.justai.aimybox.speechkit.google.platform.GooglePlatformSpeechToText
import com.justai.aimybox.speechkit.google.platform.GooglePlatformTextToSpeech
import java.util.*

class AimyboxApplication : Application(), AimyboxProvider {

    companion object {
        // API key given by AIMYBOX
        private const val AIMYBOX_API_KEY = "Ldf0j7WZi3KwNah2aNeXVIACz0lb9qMH"
    }

    override val aimybox by lazy { createAimybox(this) }

    private fun createAimybox(context: Context): Aimybox {

        // change model based on language
        val assets = KaldiAssets.fromApkAssets(this, "model/en")

        // trigger words
        val voiceTrigger = KaldiVoiceTrigger(assets, listOf("listen", "envirocar"))

        val unitId = UUID.randomUUID().toString()

        val textToSpeech = GooglePlatformTextToSpeech(context, Locale.ENGLISH)
        val speechToText = GooglePlatformSpeechToText(context, Locale.ENGLISH)

        val dialogApi = AimyboxDialogApi(
            AIMYBOX_API_KEY, unitId, customSkills = linkedSetOf(MyCustomSkill(context))
        )

        return Aimybox(Config.create(speechToText, textToSpeech, dialogApi) {
            this.voiceTrigger = voiceTrigger
        })
    }
}