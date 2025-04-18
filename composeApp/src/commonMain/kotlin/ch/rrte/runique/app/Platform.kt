package ch.rrte.runique.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform