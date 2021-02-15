# ojaynico-kotlin-react-native-async-storage

[Download](https://search.maven.org/artifact/com.github.ojaynico/ojaynico-kotlin-react-native-async-storage/1.0.1/pom)

Kotlin wrapper for react-native-async-storage

Java Version : 14

Kotlin Version : 1.4.30

React Native Async Storage Version : 1.13.4

**Follow instructions in this repository on how to setup a fully working react native app**

https://github.com/ojaynico/ojaynico-kotlin-react-native

**After check out the following links on how to install async storage in react native.**

https://react-native-async-storage.github.io/async-storage/docs/install/

## `How to use the wrapper?`

In your react native application shared module (a kotlin gradle project), update your gradle file to include the following in the respective blocks.

```kotlin
repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.github.ojaynico:ojaynico-kotlin-react-native-async-storage:1.0.1")
}
```

### `Example of code snippet for a react native app using the above wrapper`

```kotlin
class App : RComponent<RProps, RState>() {

    override fun componentDidMount() {
        GlobalScope.launch(Dispatchers.Main.immediate) {
            // Store a name using the setItem(key, value) function passing in two parameters
            AsyncStorage.setItem("name", "Nicodemus Ojwee").await()

            // Print out the name using the getItem(key) function with the above key "name"
            println(AsyncStorage.getItem("name").await())
        }
    }
    
    override fun RBuilder.render() {
        ...
    }
}
```
