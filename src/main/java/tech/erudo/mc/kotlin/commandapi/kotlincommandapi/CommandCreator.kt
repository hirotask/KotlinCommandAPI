package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class CommandCreator(val mainCommand: String) {

    var description = ""
    var usageMessage = "/"
    var aliases = listOf<String>()
    var permission = ""
    var permissionMessage = ""

    private var executeAction: CommandExecuteAction = {}


    fun arg(arg: String, action: CommandCreateAction) {}

    fun execute(action: CommandExecuteAction) {
        executeAction = action
    }

    fun create() : Command {
        return object : Command(mainCommand, description, usageMessage, aliases) {
            init {
                permission = this@CommandCreator.permission
                permissionMessage = this@CommandCreator.permissionMessage
            }


            override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>?): Boolean {
                TODO("Not yet implemented")
            }

        }
    }

}