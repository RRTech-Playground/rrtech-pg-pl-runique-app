package ch.rrte.runique.app.core.presentation.ui

import ch.rrte.runique.app.core.domain.util.DataError
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.Res
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_disk_full
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_no_internet
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_payload_too_large
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_request_timeout
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_serialization
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_too_many_requests
import rrtech_pg_pl_runique_app.modules.core.presentation.ui.generated.resources.error_unknown

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full

        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER_ERROR -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.PAYLOAD_TOO_LARGE -> Res.string.error_payload_too_large
        else -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}