package line


import java.net.URL
import java.util.Base64
import javax.net.ssl.HttpsURLConnection

class LineNotification(private val token: String) {
    private val timeout = 60


    fun send(message: String, stickerPackageId: String = "", stickerId: String = "", notification: Boolean = true, picture: String = "", timeout: Int = 60): HttpsURLConnection {
        val timeoutValue = timeout ?: this.timeout
//        val payload = """
//        {
//            "message": "$message",
//            "notificationDisabled": ${!notification}
//        }
//    """.trimIndent()
        val payload = "message=$message&notificationDisabled=${!notification}"
//        if (stickerPackageId.isNotEmpty() && stickerId.isNotEmpty()) {
//            payload.replaceRange(
//                    payload.indexOf("}"),
//                    payload.length,
//                    """,
//                "stickerPackageId": "$stickerPackageId",
//                "stickerId": "$stickerId"
//            }
//        """
//            )
//        }

        val url = URL("https://notify-api.line.me/api/notify")
//        val url = URL("https://httpbin.org/post")
        val connection = url.openConnection() as HttpsURLConnection
        connection.doInput = true
        connection.doOutput = true
        connection.requestMethod = "POST"
//        val header =  mapOf("Authorization" to "Bearer ${Base64.getEncoder().encodeToString(this.token.toByteArray())}")
//        connection.headerFields = header
        connection.setRequestProperty(
                "Authorization",
                "Bearer ${this.token}"
        )
        connection.doOutput = true
//        connection.connectTimeout = timeoutValue
        connection.outputStream.use {
            it.write(payload.toByteArray())
            it.flush()
        }
        println(connection.responseCode)
        println(connection.responseMessage)
        val response = connection.inputStream.bufferedReader().use { it.readText() }
//        val response = connection.errorStream.bufferedReader().use { it.readText() }
        println(response)
        return connection
    }

}