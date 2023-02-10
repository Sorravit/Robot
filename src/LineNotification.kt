package line


import java.io.File
import java.io.FileInputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class LineNotification(private val token: String) {
    fun send(message: String, stickerPackageId: String = "", stickerId: String = "", notification: Boolean = true, picture: String = "", timeout: Int = 60000): HttpsURLConnection {
        val payload = "message=$message&notificationDisabled=${!notification}"
        if (stickerPackageId.isNotEmpty() && stickerId.isNotEmpty()) {
            payload.plus("&stickerPackageId=$stickerPackageId&stickerId=$stickerId")
        }
        val url = URL("https://notify-api.line.me/api/notify")
        val connection = url.openConnection() as HttpsURLConnection
        connection.requestMethod = "POST"
        connection.setRequestProperty("Authorization", "Bearer $token")
        if (picture.isNotEmpty()) {
            val boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW"
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")
            connection.doOutput = true
            connection.connectTimeout = timeout
            val file = File(picture)
            val fileSize = file.length().toInt()
            val fis = FileInputStream(file)
            connection.outputStream.use { os ->
                os.write("--$boundary\r\n".toByteArray())
                os.write("Content-Disposition: form-data; name=\"imageFile\"; filename=\"${file.name}\"\r\n".toByteArray())
                os.write("Content-Type: ${getMimeType(file.extension)}\r\n\r\n".toByteArray())
                val buffer = ByteArray(fileSize)
                fis.read(buffer)
                os.write(buffer)
                os.write("\r\n--$boundary\r\n".toByteArray())
                os.write("Content-Disposition: form-data; name=\"message\"\r\n".toByteArray())
                os.write("Content-Type: text/plain\r\n\r\n".toByteArray())
                os.write("$message\r\n".toByteArray())
                os.write("--$boundary--\r\n".toByteArray())
            }
        } else {
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            connection.doOutput = true
            connection.connectTimeout = timeout
            connection.outputStream.use {
                it.write(payload.toByteArray())
            }
        }
        println(connection.responseCode)
        println(connection.responseMessage)
        return connection
    }

    private fun getMimeType(extension: String): String {
        return when (extension) {
            "jpeg", "jpg" -> "image/jpeg"
            "png" -> "image/png"
            "gif" -> "image/gif"
            else -> "application/octet-stream"
        }
    }
}
