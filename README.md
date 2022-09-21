### こういうの作りたい
- 案1
```kotlin
plugin.register(mainCommand = "test") {
    subcommand("sub1") {
        //ここに処理を書く
    }
    subcommand("sub2") {
        arg("arg1") {
            
        }
        arg("arg2") {
            
        }
    }
}
```

- 案2
```kotlin
val command = CommandAPI(plugin)
command.register {
    subcommand("sub1") {
        
    }
    subcommand("sub2") {
        arg("arg1") {

        }
        arg("arg2") {

        }
    }
}
```