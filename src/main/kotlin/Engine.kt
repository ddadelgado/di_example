import com.google.inject.Inject
import com.google.inject.Singleton

interface Engine {
    fun start()
    fun stop()
}

@Singleton
class DefaultEngineImpl @Inject constructor(
    private val logger: Logger
): Engine {
    override fun start() {
        // Insert here logic to start engine
        logger.info("[Engine] Started")
    }

    override fun stop() {
        // Insert here logic to stop engine
        logger.info("[Engine] Stopped")
    }
}

@Singleton
class FakeEngine @Inject constructor(
    private val logger: Logger
): Engine {
    override fun start() {
        // fake start engine
        logger.info("[Fake Engine] Started")
    }

    override fun stop() {
        // fake stop engine
        logger.info("[Fake Engine] Stopped")
    }
}


