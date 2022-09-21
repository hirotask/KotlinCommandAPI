package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class CommandCreator(
    val mainCommand: String,
    var description : String = "",
    var usageMessage : String = "/",
    var aliases : List<String> = listOf(),
    var permission: String = "",
    var permissionMessage: String = "",
)  {

    private var executeAction: CommandExecuteAction = {}

    fun execute(action: CommandExecuteAction) {
        executeAction = action
    }

    fun create() : Command {
        return object : Command(mainCommand, description, usageMessage, aliases) {
            init {
                permission = this@CommandCreator.permission
                permissionMessage = this@CommandCreator.permissionMessage
            }


            override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
                if(sender.hasPermission(this@CommandCreator.permission)) {
                    executeAction(CommandExecuteParam(sender, commandLabel, CommandArgument(args.toList())))
                }
                return true
            }

        }
    }
}