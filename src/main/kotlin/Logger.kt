import com.google.inject.Singleton

interface Logger {
    fun info(text: String)
}

@Singleton
class DefaultLoggerImpl : Logger {
    override fun info(text: String) {
        println("[LOGGER] $text")
    }
}
