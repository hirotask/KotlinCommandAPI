### こういうの作りたい
- 案1
```kotlin
plugin.register(mainCommand = "test") {
    arg("sub1") {
        //ここに処理を書く
        execute { //"/test sub1"を実行した時
            
        }
        
    }
    arg("sub2") {
        arg("arg1") {
            execute { //"/test sub2 arg1"を実行した時
                
            }
        }
        arg("arg2") {
            
        }
    }
    
    execute { //"/test"を実行した時
        
    }
}
```

- 案2
```kotlin
val command = CommandAPI(plugin)
command.register {
    arg("sub1") {
        
    }
    arg("sub2") {
        arg("arg1") {

        }
        arg("arg2") {

        }
    }
}
```