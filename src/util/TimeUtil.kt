package util

import java.text.SimpleDateFormat
import java.util.*

class TimeUtil {
    fun getCurrentTime():String{
        val cal = Calendar.getInstance()
        val sdf = SimpleDateFormat("HH:mm:ss")
        return sdf.format(cal.time)
    }
}