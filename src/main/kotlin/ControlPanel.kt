import com.google.inject.Inject

// Control Panel should gather all information
// related to the spaceship status
interface ControlPanel {
    fun getSpeed()
    fun getGasLeft()
}

class DefaultControlPanelImpl @Inject constructor(
    private val logger: Logger) : ControlPanel {

    override fun getSpeed() {
        // Insert here logic to calculate current speed,
        // most likely extracted from some other component
        // in charge to measuring spaceship info
        val speed = 10 // random value
        logger.info("[Control Panel] Current speed is $speed mph")
    }

    override fun getGasLeft() {
        // Insert here logic to calculate current speed,
        // most likely extracted from some other component
        // in charge to measuring spaceship info
        val gas = 9 // random value
        logger.info("[Control Panel] Gas left in tank is $gas L")
    }
}

// Contains fake data for testing purposes
class FakeControlPanel @Inject constructor(
    private val logger: Logger) : ControlPanel {

    override fun getSpeed() {
        // log fake speed
        logger.info("[Fake Control Panel] Current speed of 10mph") // Fake speed
    }

    override fun getGasLeft() {
        // log fake gas left
        logger.info("[Fake Control Panel] Gas left in tank is 9L") // Fake gas left
    }
}
