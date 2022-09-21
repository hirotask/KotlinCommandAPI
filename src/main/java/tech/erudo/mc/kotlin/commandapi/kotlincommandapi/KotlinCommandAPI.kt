package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.plugin.java.JavaPlugin

class KotlinCommandAPI : JavaPlugin() {
    override fun onEnable() {
        this.command("test") {
            subcommand("test") {

            }
        }

    }
    override fun onDisable() {
        // Plugin shutdown logic
    }
}