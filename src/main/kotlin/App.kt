import com.google.inject.Injector
import kotlin.system.exitProcess

/**
 * App creates a spaceship (only one) using dependency injection.
 * There are 2 flags: "--dev" and "--prod". Depending on flag used
 * it will create objects for testing or for prod.
 *
 * Injector will populate all objects required by spaceship, and the
 * objects of those objects and so on.
 */
fun main(args: Array<String>) {
    val injector : Injector = if(args[0] == "--prod"){
        prod() // Create production injector
    } else if(args[0] == "--dev"){
        dev() // Create development injector
    } else {
        println("No flag detected")
        exitProcess(-1)
    }

    val spaceship : Spaceship = injector.getInstance(Spaceship::class.java)
    spaceship.launch()
    spaceship.status()
}