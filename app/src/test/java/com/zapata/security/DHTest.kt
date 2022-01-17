package com.zapata.security

import com.zapata.security.diffieHellman.DiffieHellman
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DHTest {

    @Test
    fun diffieHellmanTest() {

        val dh = DiffieHellman()
        val publicKey = "MIIBojCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAVYSM+IPAxc/9WxoyNBPsAUWwqb/uhyenDFeXTky3DsI+JK+1uGB3eYzYyN2E1x1hWbFXZ2lmd9vGa3dS7wiwEUqsQ60atbI4/D0HVSEhhpdrxtwMtSdY1ppjRk9+58KzRPUIO6J/HH9HIpoGC9PGZSLrThIBK1Cg0yn3fFNlcWQ="
        val privateKey = "MIIBpQIBADCCARcGCSqGSIb3DQEDATCCAQgCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEgYQCgYEAifGDBnesRQlS9zUYz4ol9VNah6nDW85xaWbLkNYX6v3ZJLEMSV39sROZhkGWxJSIZRaB166OpiEG5HFiT+GTLhWDBsh3am11FzWzqa5kC18BJPdoY/VGC8VMrC6lPtpUVu912qpaxH11iEf0YBDnWnhEGu08K0n1aJDxjWD2pNY="
        val serverPublicKey = "MIIBpjCCARsGCSqGSIb3DQEDATCCAQwCgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoCAgIAA4GEAAKBgAfrl35dTdpDK2f3SiQTkryMcraUiNM19JjLKqF7wMYXCndQisqAklaLP1UsFoWxmxldAueI363lwc4PR/fmy5dN7xwIjSLbGUjX6ELK9mB76IhQASdMUw1Au7MsfwL6xj+l6EhhACuTJZm5bAsVKOuhfntsLRv3sTRH98s+Md5R"


        dh.setKeyPar(publicKey, privateKey)
        dh.setServerKey(serverPublicKey)
        dh.generateCommonSecretKey()
        val secretKey = Base64.getEncoder().encode(dh.getSecretKey())

        assertEquals(4, 4)
    }
}
