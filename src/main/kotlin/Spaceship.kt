import com.google.inject.Inject
import com.google.inject.Singleton

@Singleton
class Spaceship @Inject constructor(
    private val controlPanel: ControlPanel,
    private val engine: Engine){

    fun launch(){
        engine.start()
    }

    fun status(){
        controlPanel.getSpeed()
        controlPanel.getGasLeft()
    }
}
