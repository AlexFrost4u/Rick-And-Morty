object ModuleDependency {

    const val app = ":app"
    const val navigation = ":navigation"

    object UI {
        private const val directory = ":ui"

        const val home = "$directory:home"
        const val character = "$directory:character:list"
        const val characterDetail = "$directory:character_detail"
        const val location = "$directory:location:list"
        const val locationDetail = "$directory:location:detail"
        const val episode = "$directory:episode:list"
        const val episodeDetail = "$directory:episode:detail"
    }

    object Feature {
        private const val directory = ":feature"

        const val rickAndMorty_api = "$directory:rickandmorty_api"
        const val rickAndMorty_impl = "$directory:rickandmorty_impl"
    }

    object Core {
        private const val directory = ":core"

        const val ui = "$directory:ui"
        const val common = "$directory:common"
    }
}
