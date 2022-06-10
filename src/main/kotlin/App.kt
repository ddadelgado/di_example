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
    val injector : Injector = if(args.isEmpty()) {
            println("no flag --dev or --prod detected")
            exitProcess(-1)
    } else if(args[0] == "--prod"){
        prod() // Create production injector
    } else if(args[0] == "--dev"){
        dev() // Create development injector
    } else {
        println("no flag --dev or --prod detected")
        exitProcess(-1)
    }

    // injection only needs to happen once
    val spaceship : Spaceship = injector.getInstance(Spaceship::class.java)

    // example code to see diff outputs in terminal
    spaceship.launch()
    spaceship.status()
}