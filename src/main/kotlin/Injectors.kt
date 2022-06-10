import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Stage

// Functions to create prod/dev injector
val prod : () -> Injector = { Guice.createInjector(Stage.PRODUCTION, ProdModule()) }
val dev : () -> Injector = { Guice.createInjector(Stage.DEVELOPMENT, DevModule()) }

// To know what object to use in each case, an interface (Logger, Engine,
// ControlPanel) is mapped to the actual class (DefaultLoggerImpl, DefaultEngineImpl,
// DefaultControlPanelImpl) for production.
// Same logic is applied for development.

// Module for production
class ProdModule : AbstractModule() {
    override fun configure(){
        bind(Logger::class.java).to(DefaultLoggerImpl::class.java)
        bind(Engine::class.java).to(DefaultEngineImpl::class.java)
        bind(ControlPanel::class.java).to(DefaultControlPanelImpl::class.java)
    }
}

// Module for development
class DevModule : AbstractModule() {
    override fun configure(){
        bind(Logger::class.java).to(DefaultLoggerImpl::class.java)
        bind(Engine::class.java).to(FakeEngine::class.java)
        bind(ControlPanel::class.java).to(FakeControlPanel::class.java)
    }
}
