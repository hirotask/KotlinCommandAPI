package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.CommandSender

class CommandExecuteParam(val sender: CommandSender, val label: String, val args: CommandArgument)