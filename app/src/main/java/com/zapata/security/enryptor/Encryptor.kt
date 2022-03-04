package com.zapata.security.enryptor

import android.annotation.SuppressLint
import android.util.Log
import java.io.UnsupportedEncodingException
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

            val byteArrayStrToEncrypt = cipher.doFinal(
                strToEncrypt.toByteArray(Charsets.UTF_8)
            )
            android.util.Base64.encodeToString(
                byteArrayStrToEncrypt,
                android.util.Base64.NO_WRAP
            )
        } catch (ex: Exception) {
            Log.d(TAG, "Error while encrypting. ${ex.message}")
            null
        }

    @SuppressLint("GetInstance")
    fun decrypt(strToDecrypt: String, secretKey: ByteArray): String? =
        try {
            setKey(secretKey)
            val cipher = Cipher.getInstance(CIPHER_TRANSFORMATION)
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)

            val byteArrayStrToDecrypt = cipher.doFinal(
                android.util.Base64.decode(strToDecrypt, android.util.Base64.NO_WRAP)
            )
            String(byteArrayStrToDecrypt)
        } catch (ex: Exception) {
            Log.d(TAG, "Error while decrypting. ${ex.message}")
            null
        }

    private fun setKey(_secretKey: ByteArray) {
        try {
            secretKeySpec = SecretKeySpec(_secretKey.copyOf(16), ALGORITHM_AES)
        } catch (ex: NoSuchAlgorithmException) {
            Log.d(TAG, ex.message.toString())
        } catch (ex: UnsupportedEncodingException) {
            Log.d(TAG, ex.message.toString())
        }
    }
}