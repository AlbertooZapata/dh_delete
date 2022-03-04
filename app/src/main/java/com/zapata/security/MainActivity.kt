package com.zapata.security

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.zapata.security.diffieHellman.DiffieHellman
import com.zapata.security.enryptor.Encryptor


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        dhTes1()
        dhTes2()
//        dhTes3()
    }

    private fun dhTes1() {

        val dh = DiffieHellman()
        dh.generateKeys()
        val myPublicKey = dh.getPublicKey()
        val privateKey = dh.getPrivateKey()

        val publicKeyStr = android.util.Base64.encodeToString(
            myPublicKey,
            android.util.Base64.NO_WRAP
        )
        val privateKeyStr = android.util.Base64.encodeToString(
            privateKey,
            android.util.Base64.NO_WRAP
        )
        Log.d("MainActivity", "publicKeyStr: $publicKeyStr")
        Log.d("MainActivity", "privateKeyStr: $privateKeyStr")
    }

    private fun dhTes2() {
        val serverPublicKeyStr =
            "MIIBozCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYUAAoGBAIXUqSOKVUIVsNzxWVmF+gHGEPOxF+bLJZm3KkcFM3Cg8I0CACtamrgLMbrtxQ8wjwn1hMRpaDo9Ow5nFFZYMSznDX2UyrPBDQDYgYbynlRORo6WwSU70xmcaj9LDUZV1NDkX3TDY+dgMnP0mR48lwkFpzcxfg7r1S2YS9B0Zio3"
        val myPublicKey =
            "MIIBojCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGATM8Vjys2Phcvsici4sVqnhE4QdN34g59FECsGNb06bSEoUk05pbxOV1XN2aw2f2Uhz6qZnTQ0Uvui9UxpqbxRldTI/rnlMUWJP4kcOfta2N2TQGf92JwSm7IF5C3KxpwY9bZzTYX1R/tLeDZuVOhv2pxex0smA+FIHGyaIIJkUo="
        val myPrivateKey =
            "MIIBpQIBADCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEgYQCgYEA81QOCRJG2hmZTMzE1f7eQ7+Y0fBYc+KlRaq/giZ2Q5r6c1uDCMkQBYrjeCV4fBLOgDEZfX+itxkXW/nXAi6SDvYEKCBlAaS5PVGT7vIwVaHklM8Dzma+vPp75uQy/hbJRFkRY1f7S253W3AH/oSKXArXaSrJtzKryeU+6TzbZ8g="


        val dh = DiffieHellman()
        dh.setKeyPar(myPublicKey, myPrivateKey)
        dh.setServerKey(serverPublicKeyStr)
        dh.generateCommonSecretKey()

        val secretKey = dh.getSecretKey()

        val secretKeyStr = android.util.Base64.encodeToString(
            secretKey,
            android.util.Base64.NO_WRAP
        )
        val textMessage =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        val encryptor = Encryptor()
        val encryptedText = encryptor.encrypt(textMessage, secretKey!!)
        val decryptedText = encryptor.decrypt(
            "EAu4TRlsPvlI6lUYxeKDWFR8ut42cSZ505g2eZMXI1xaY8y0Gpc+luv4DEro6N+l5oiXmmNP+QKspbwsihh+eQ==",
            secretKey
        )

        Log.d("MainActivity", decryptedText!!)
    }

    private fun dhTes5() {
        val serverPublicKeyStr =
            "MIIBozCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYUAAoGBAIXUqSOKVUIVsNzxWVmF+gHGEPOxF+bLJZm3KkcFM3Cg8I0CACtamrgLMbrtxQ8wjwn1hMRpaDo9Ow5nFFZYMSznDX2UyrPBDQDYgYbynlRORo6WwSU70xmcaj9LDUZV1NDkX3TDY+dgMnP0mR48lwkFpzcxfg7r1S2YS9B0Zio3"
        val myPublicKey =
            "MIIBojCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAEB05jEJ7vD/UrH/t2iMOjwvQ3Myn7HXw1YE4XNsVZ/xYMPkWpug6j9CQlYHMBAtdK0gn0/2m26kQp6ongJ1lln6eVwlmyD70TGetes2mFRZg4ZMiR2SkOoI146BBl+4ZvfJsNZKlW0M55UAc4lXa9v5Y2Kdc5yRUDm3ZQWZwVr8="
        val myPrivateKey =
            "MIIBpQIBADCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEgYQCgYEAk1NZHc1eKRmIk32lp5e5RQ0rz3lBVacxxIf5RkDF+RrSiUC9ehVKmKiHOnDzmA5piQqS+nmVcKKhyGvFYcaNnn8BrpsKavzrryzzVu955FYchuELa54yR4wpR1BP8kNVjf7BbNl5t1OD/azCwOsEwDe2OUo3r8X/fpkYqgs0tbs="


        val dh = DiffieHellman()
        dh.setKeyPar(myPublicKey, myPrivateKey)
        dh.setServerKey(serverPublicKeyStr)
        dh.generateCommonSecretKey()

        val secretKey = dh.getSecretKey()

        val secretKeyStr = android.util.Base64.encodeToString(
            secretKey,
            android.util.Base64.NO_WRAP
        )
        val textMessage =
            "{\"session\":\"0\",\"latitude\":\"0\",\"ipAddress\":\"A-192.168.1.73\",\"deviceId\":\"baa60b2a-cd5e-4775-b3ac-215278472164\",\"longitude\":\"0\"}"
        val encryptor = Encryptor()
        val encryptedText = encryptor.encrypt(textMessage, secretKey!!)
        val decryptedText = encryptor.decrypt(
            "EAu4TRlsPvlI6lUYxeKDWFR8ut42cSZ505g2eZMXI1xaY8y0Gpc+luv4DEro6N+l5oiXmmNP+QKspbwsihh+eQ==",
            secretKey
        )

        Log.d("MainActivity", decryptedText!!)
    }

    private fun dhTes3() {

        val serverPublicKeyStr =
            "MIHcMIGTBgkqhkiG9w0BAwEwgYUCQQD8poLOjhLKuibvzPcRDlJtsHiwXt7LzR60ogjzrhYXrgHzW5Gkfm32NBPF4S7QiZvNEyrNUNmRUb3EPuc3WS4XAkBnhHGyepz0TukaScUUfbGpqvJE8FpDTWSGkx0tFCcbnjUDC3H9c9oXkGmzLik1Yw4cIGI1TQ2iCmxBblC+eUykA0QAAkEAlKV/Or00LNn7KxcIKiGahtnqMg34gDfP81Ts719rnBUiv13hxwnLWP4rWCSYI83JXyHTkHVSkHw8T0uqfN5IfQ=="
        val myPublicKey =
            "MIHcMIGTBgkqhkiG9w0BAwEwgYUCQQD8poLOjhLKuibvzPcRDlJtsHiwXt7LzR60ogjzrhYXrgHzW5Gkfm32NBPF4S7QiZvNEyrNUNmRUb3EPuc3WS4XAkBnhHGyepz0TukaScUUfbGpqvJE8FpDTWSGkx0tFCcbnjUDC3H9c9oXkGmzLik1Yw4cIGI1TQ2iCmxBblC+eUykA0QAAkEAgjjLKVEWdxPAdLCyuVQfSz2TrS5RVXnCCSzzQIkT87SmEiEgEx9WTls1nUUwABNzqjae/Xkp/JpvSWgm+v3KHQ=="
        val myPrivateKey =
            "MIHeAgEAMIGTBgkqhkiG9w0BAwEwgYUCQQD8poLOjhLKuibvzPcRDlJtsHiwXt7LzR60ogjzrhYXrgHzW5Gkfm32NBPF4S7QiZvNEyrNUNmRUb3EPuc3WS4XAkBnhHGyepz0TukaScUUfbGpqvJE8FpDTWSGkx0tFCcbnjUDC3H9c9oXkGmzLik1Yw4cIGI1TQ2iCmxBblC+eUykBEMCQQCz7LJuaA7CitjK2VN/EN6nOvlttYA63cEb3InCYxMqor+keraoGzKTQqo5ZJ0yAGETJFyVBMa5mb8i21TbdBio"


//        val serverPublicKeyStr =
//            "MIIBJDCBmQYJKoZIhvcNAQMBMIGLAoGBAP//////////yQ/aoiFowjTExmKLgNwc0SkCTgiKZ8x0Agu+pjsTmyJRSgh5jjQE3e+VGbPNOkMbMCsKbfJfFDdP4TVtbVHCReSFtXZiXn7G9ExC6aY37WsL/1y29Aa37e44a/taiZ+lrp8kEXxLH+ZJKGZR7OZTgf//////////AgECAgICAAOBhQACgYEA7d9WAFhWjqdkjOhGCQYmvzWm/gPOi+2RaWVnckEe7txTCOno8sJTuBeGUcVWfdzDTc3tUY2WlGYkDzUJjrKhLos6kjq41MjpzWc2YVr/gpp3UvV0sqojyYiGI1nE4mjiIJlh8Q6FUIAetBY27Dld6EKLmLzi6ddAFZOggjLnKQk="
//        val myPrivateKey =
//            "MIHkAgEAMIGZBgkqhkiG9w0BAwEwgYsCgYEA///////////JD9qiIWjCNMTGYouA3BzRKQJOCIpnzHQCC76mOxObIlFKCHmONATd75UZs806QxswKwpt8l8UN0/hNW1tUcJF5IW1dmJefsb0TELppjftawv/XLb0Brft7jhr+1qJn6WunyQRfEsf5kkoZlHs5lOB//////////8CAQICAgIABEMCQQClTz9W7BzaAMqcJKf/TZBKa/8myR05IiyywJB9igHCqGCYUKoQIED/DE37ddPaXsIprqhPCgJ6XyANlp4aYvrm"
//        val myPublicKey =
//            "MIIBJDCBmQYJKoZIhvcNAQMBMIGLAoGBAP//////////yQ/aoiFowjTExmKLgNwc0SkCTgiKZ8x0Agu+pjsTmyJRSgh5jjQE3e+VGbPNOkMbMCsKbfJfFDdP4TVtbVHCReSFtXZiXn7G9ExC6aY37WsL/1y29Aa37e44a/taiZ+lrp8kEXxLH+ZJKGZR7OZTgf//////////AgECAgICAAOBhQACgYEA80GyAFKGCUA+UWO9X+NxRPjdiOZnVgs1rCjSrGbBqvXsNTxGpHnXP9I36NVIpaLdSoUTtY7ryOjiAxT95ObyfCTCArvAEys62O1s3Eo4VjrqkTsohQytOthuu32GHIoHnb2HDGpNqB7nkGGYy7lkD9PKzSd1trxYKRIwH219V/Q="

        val dh = DiffieHellman()
        dh.setKeyPar(myPublicKey, myPrivateKey)
        dh.setServerKey(serverPublicKeyStr)
        dh.generateCommonSecretKey()
        val secretKey = dh.getSecretKey()!!
        val secretKeyStr = android.util.Base64.encodeToString(
            secretKey,
            android.util.Base64.NO_WRAP
        )
        val encryptor = Encryptor()
        val encryptedText =
            "EgYj1+VAEaeuRSpJVnEwQAmxt73yunCcWWHtoWZBu2pEuDwyQH3YiqtP/rQ+poSBk5/uaFZf4GVAtLqj+z8TiRIFblemOWpV5y2fYU/HLgKNisXZmZ1RxkeLWh5Xioff7v4dQA0zYgHlCPuC5X9Pmmj8htkWiAEe395XjdlGdyKtD0yqd6GCIiOiqi9/D4IBvXrf4qGWhCboAQt/W7hpCg=="
        val decryptedText = encryptor.decrypt(encryptedText, secretKey)

        Log.d("MainActivity", decryptedText!!)
    }
}