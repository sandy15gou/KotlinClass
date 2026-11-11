package com.example.exploringkotlinclasses

abstract class GreetingsScreen {
    abstract fun message(): String

    fun greet(): String = "Greeting: ${message()}"
}

class HelloScreen : GreetingsScreen() {
    override fun message() = "Hello, welcome to Android Development!"
}

// Interfaces
interface Clickable {
    fun onClick(): String
}

class clickHandler : Clickable {
    override fun onClick(): String {
        return "Interface Clicked!"
    }
}

// Inner Class
class Outer {
    private val greeting = "Hello from Outer Class"

    inner class Inner {
        fun greet() = "$greeting (via Inner Class)"
    }
}

sealed interface UiState

// Singleton state
object Loading: UiState

data class Success(val message: String) : UiState
data class Error(val message: String) : UiState


















