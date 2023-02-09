import line.LineNotification

fun main(args:Array<String>) {
//    AutoClicker().keepScreenAlive()
    val line = LineNotification("put token here")
    println(line.send("Hello from kotlin"))
}