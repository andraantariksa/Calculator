package id.shaderboi.calculator.util

sealed class Resource<T> {
    class Loading<T>: Resource<T>()
    class Loaded<T>(val data: T): Resource<T>()
    class Error<T>(val throwable: Throwable): Resource<T>()
}