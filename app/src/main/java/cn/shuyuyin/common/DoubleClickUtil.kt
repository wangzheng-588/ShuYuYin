package cn.shuyuyin.common


object DoubleClickUtil {

    private val DEFAULT = 1500L
    private var lastClickTime: Long = 0

    val isFastDoubleClick: Boolean
        get() {
            val time = System.currentTimeMillis()
            val timeD = time - lastClickTime
            if (0 < timeD && timeD < DEFAULT) {
                return true
            }
            lastClickTime = time
            return false
        }

}
