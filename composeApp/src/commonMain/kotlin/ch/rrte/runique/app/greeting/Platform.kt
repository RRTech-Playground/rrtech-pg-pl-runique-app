package ch.rrte.runique.app.greeting

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform