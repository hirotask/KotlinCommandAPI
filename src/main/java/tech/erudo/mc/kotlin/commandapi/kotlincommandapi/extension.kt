package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.plugin.java.JavaPlugin

typealias CommandCreateAction = CommandCreator.() -> Unit

typealias CommandExecuteAction = CommandExecuteParam.() -> Unit

fun JavaPlugin.command(mainCommand: String, action: CommandCreateAction) {

}

private fun registerCommand(plugin: JavaPlugin, command: Command) {
    val commandMapField = plugin.server.javaClass.getDeclaredField("commandMap")
    commandMapField.isAccessible = true
    val commandMap = commandMapField.get(plugin.server) as CommandMap
    commandMap.register(plugin.name, command)
    commandMapField.isAccessible = false
}