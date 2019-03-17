package de.fhdo.ddmm.live_validation

import java.io.File
import java.util.concurrent.atomic.AtomicBoolean

internal val AtomicBoolean.True
    get() = this.get()

internal fun String.asFile() = File(this)