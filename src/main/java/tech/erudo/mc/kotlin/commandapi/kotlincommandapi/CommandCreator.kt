package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandCreator(val mainCommand: String) {

    var description = ""
    var usageMessage = "/"
    var aliases = listOf<String>()
    var permission = ""
    var permissionMessage = ""

    private val tabContainer = CommandTab.Container()
    private var executeAction: CommandExecuteAction = {}


    fun arg(arg: String, action: CommandCreateAction) {

    }

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

            override fun tabComplete(
                sender: CommandSender,
                alias: String,
                args: Array<out String>
            ): List<String> {
                return tabContainer.get(sender, args)
            }

        }
    }

}