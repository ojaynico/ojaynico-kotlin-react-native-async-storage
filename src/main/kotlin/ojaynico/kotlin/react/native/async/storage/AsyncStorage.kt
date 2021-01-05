@file:JsModule("@react-native-async-storage/async-storage")
@file:Suppress("unused")

package ojaynico.kotlin.react.native.async.storage

import kotlin.js.Promise

external interface AsyncStorageStatic {
    fun getItem(key: String, callback: (error: Error, result: String) -> Unit = definedExternally): Promise<String>
    fun setItem(key: String, value: String, callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun removeItem(key: String, callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun mergeItem(key: String, value: String, callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun clear(callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun getAllKeys(callback: (error: Error, keys: Array<String>) -> Unit = definedExternally): Promise<Array<String>>
    fun multiGet(keys: Array<String>, callback: (errors: Array<Error>, result: Array<dynamic /* JsTuple<String, String?> */>) -> Unit = definedExternally): Promise<dynamic>
    fun multiSet(keyValuePairs: Array<Array<String>>, callback: (errors: Array<Error>) -> Unit = definedExternally): Promise<Unit>
    fun multiRemove(keys: Array<String>, callback: (errors: Array<Error>) -> Unit = definedExternally): Promise<Unit>
    fun multiMerge(keyValuePairs: Array<Array<String>>, callback: (errors: Array<Error>) -> Unit = definedExternally): Promise<Unit>
}

external interface Storage {
    fun getItem(callback: (error: Error, result: String) -> Unit = definedExternally): Promise<String>
    fun setItem(value: String, callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun mergeItem(value: String, callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
    fun removeItem(callback: (error: Error) -> Unit = definedExternally): Promise<Unit>
}

external fun useAsyncStorage(key: String): Storage

@JsName("default")
external var AsyncStorage: AsyncStorageStatic
