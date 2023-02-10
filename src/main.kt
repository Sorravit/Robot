import line.LineNotification

fun main(args: Array<String>) {
//    AutoClicker().keepScreenAlive()
    val line = LineNotification("")
    println(line.send("Message without picture").inputStream.bufferedReader().use { it.readText() })
    println(line.send("Message with picture", picture = "BIG.jpg").inputStream.bufferedReader().use { it.readText() })
}