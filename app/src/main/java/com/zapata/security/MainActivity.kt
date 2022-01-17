package com.zapata.security

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zapata.security.diffieHellman.DiffieHellman
import com.zapata.security.enryptor.Encryptor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dhTes1()
        dhTes2()
    }

    private fun dhTes1() {

        val dh = DiffieHellman()
        dh.generateKeys()
        val myPublicKey = dh.getPublicKey()
        val privateKey = dh.getPrivateKey()

        val myPublicKeyStr = android.util.Base64.encodeToString(
            myPublicKey,
            android.util.Base64.NO_WRAP
        )
        val privateKeyStr = android.util.Base64.encodeToString(
            privateKey,
            android.util.Base64.NO_WRAP
        )
        Log.d("MainActivity", "myPublicKeyStr: $myPublicKeyStr")
        Log.d("MainActivity", "privateKeyStr: $privateKeyStr")

    }

    private fun dhTes2() {

        val serverPublicKeyStr =
            "MIIBJDCBmQYJKoZIhvcNAQMBMIGLAoGBAP//////////yQ/aoiFowjTExmKLgNwc0SkCTgiKZ8x0Agu+pjsTmyJRSgh5jjQE3e+VGbPNOkMbMCsKbfJfFDdP4TVtbVHCReSFtXZiXn7G9ExC6aY37WsL/1y29Aa37e44a/taiZ+lrp8kEXxLH+ZJKGZR7OZTgf//////////AgECAgICAAOBhQACgYEA7d9WAFhWjqdkjOhGCQYmvzWm/gPOi+2RaWVnckEe7txTCOno8sJTuBeGUcVWfdzDTc3tUY2WlGYkDzUJjrKhLos6kjq41MjpzWc2YVr/gpp3UvV0sqojyYiGI1nE4mjiIJlh8Q6FUIAetBY27Dld6EKLmLzi6ddAFZOggjLnKQk="
        val myPrivateKey =
            "MIHkAgEAMIGZBgkqhkiG9w0BAwEwgYsCgYEA///////////JD9qiIWjCNMTGYouA3BzRKQJOCIpnzHQCC76mOxObIlFKCHmONATd75UZs806QxswKwpt8l8UN0/hNW1tUcJF5IW1dmJefsb0TELppjftawv/XLb0Brft7jhr+1qJn6WunyQRfEsf5kkoZlHs5lOB//////////8CAQICAgIABEMCQQClTz9W7BzaAMqcJKf/TZBKa/8myR05IiyywJB9igHCqGCYUKoQIED/DE37ddPaXsIprqhPCgJ6XyANlp4aYvrm"
        val myPublicKey =
            "MIIBJDCBmQYJKoZIhvcNAQMBMIGLAoGBAP//////////yQ/aoiFowjTExmKLgNwc0SkCTgiKZ8x0Agu+pjsTmyJRSgh5jjQE3e+VGbPNOkMbMCsKbfJfFDdP4TVtbVHCReSFtXZiXn7G9ExC6aY37WsL/1y29Aa37e44a/taiZ+lrp8kEXxLH+ZJKGZR7OZTgf//////////AgECAgICAAOBhQACgYEA80GyAFKGCUA+UWO9X+NxRPjdiOZnVgs1rCjSrGbBqvXsNTxGpHnXP9I36NVIpaLdSoUTtY7ryOjiAxT95ObyfCTCArvAEys62O1s3Eo4VjrqkTsohQytOthuu32GHIoHnb2HDGpNqB7nkGGYy7lkD9PKzSd1trxYKRIwH219V/Q="

        val dh = DiffieHellman()
        dh.setKeyPar(myPublicKey, myPrivateKey)
        dh.setServerKey(serverPublicKeyStr)
        dh.generateCommonSecretKey()

        val secretKey = dh.getSecretKey()
        val textMessage = "Hi, this is the text to encrypt"
        val encryptor = Encryptor()
        val encryptedText = encryptor.encrypt(textMessage, secretKey!!)
        val decryptedText = encryptor.decrypt(encryptedText, secretKey)

        Log.d("MainActivity", decryptedText!!)
    }
}