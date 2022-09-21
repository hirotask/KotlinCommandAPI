package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.plugin.java.JavaPlugin

class KotlinCommandAPI : JavaPlugin() {
    override fun onEnable() {
        this.command("test") {
            execute {
                when(args[0].lowercase()) {
                    "arg1" ->  sender.sendMessage("hello world")
                    "arg2" -> sender.sendMessage("hello japan")
                    else -> sender.sendMessage("hello mc")
                }
            }
        }

    }
    override fun onDisable() {
        // Plugin shutdown logic
    }
}