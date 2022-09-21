package tech.erudo.mc.kotlin.commandapi.kotlincommandapi

import org.bukkit.command.CommandSender

interface CommandTab {
    fun complete(sender: CommandSender, args: Array<out String>) : Iterable<String>

    class Container {
        private val tabList = mutableListOf<CommandTab>()

        fun add(commandTab: CommandTab) {
            tabList.add(commandTab)
        }

        internal fun get(sender: CommandSender, args: Array<out String>) : List<String> {
            return tabList.flatMap { it.complete(sender, args).sorted() }
        }
    }
}