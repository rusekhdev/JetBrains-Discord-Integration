/*
 * Copyright 2017-2020 Aljoscha Grebe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gamesdk.impl

import com.almightyalpaca.jetbrains.plugins.discord.gamesdk.DiscordResult
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal typealias Pointer = Long

internal typealias Callback<T> = (T) -> Unit
internal typealias DiscordResultCallback = Callback<DiscordResult>

internal suspend inline fun <T> suspendCallback(crossinline callback: (Callback<T>) -> Unit): T = suspendCoroutine { continuation ->
    callback { result ->
        continuation.resume(result)
    }
}
