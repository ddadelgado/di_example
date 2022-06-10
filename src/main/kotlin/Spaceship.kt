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

    // this will inject a method, method will run
    // upon object creation. Because it is a singleton,
    // it will run only once
    @Inject
    fun init(){
        println("Spaceship ready.")
    }
}
