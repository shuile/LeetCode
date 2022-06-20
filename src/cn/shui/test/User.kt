package cn.shui.test

/**
 * Created by chenyiting on 2022/6/17
 */
data class User(var name: String, val age: Int, val country: String? = null, val enabled: Boolean = false) {
    companion object {
        const val organisation = "Not Organised"
    }
}
