package com.zapata.security.enryptor

import android.annotation.SuppressLint
import android.util.Log
import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


/*
 * @author azapata
 *  nov 2021
 */
class Encryptor {

    private var secretKeySpec: SecretKeySpec? = null

    companion object {

        const val ALGORITHM_AES = "AES"

        const val CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding"

        private val TAG = this::class.java.canonicalName

    }

    @SuppressLint("GetInstance")
    fun encrypt(strToEncrypt: String, secretKey: ByteArray): String? =
        try {
            setKey(secretKey)
            val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            android.util.Base64.encodeToString(
                cipher.doFinal(strToEncrypt.toByteArray(charset("UTF-8"))),
                android.util.Base64.NO_WRAP
            )
        } catch (ex: Exception) {
            Log.d(TAG, "Error while encrypting. ${ex.message}")
            null
        }

    @SuppressLint("GetInstance")
    fun decrypt(strToDecrypt: String?, secretKey: ByteArray): String? =
        try {
            setKey(secretKey)
            val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
            String(
                cipher.doFinal(
                    android.util.Base64.decode(
                        strToDecrypt,
                        android.util.Base64.NO_WRAP
                    )
                )
            )
        } catch (ex: Exception) {
            Log.d(TAG, "Error while decrypting. ${ex.message}")
            null
        }


    private fun setKey(_secretKey: ByteArray) {
        val sha: MessageDigest?
        try {
            var secretKey = _secretKey
            sha = MessageDigest.getInstance("SHA-1")
            secretKey = sha.digest(secretKey)
            secretKey = secretKey.copyOf(16)
            secretKeySpec = SecretKeySpec(secretKey, ALGORITHM_AES)
        } catch (ex: NoSuchAlgorithmException) {
            Log.d(TAG, ex.message.toString())
        } catch (ex: UnsupportedEncodingException) {
            Log.d(TAG, ex.message.toString())
        }
    }
}