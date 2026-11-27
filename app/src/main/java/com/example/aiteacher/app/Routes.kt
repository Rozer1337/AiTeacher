package com.example.aiteacher.app

import kotlinx.serialization.Serializable

@Serializable
object MainScreenRoute

@Serializable
object NewBookScreenRoute
@Serializable
data class BookScreenRoute(
    val bookId : Int
)