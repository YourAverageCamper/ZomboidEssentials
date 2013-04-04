
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class TeleportHereCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public TeleportHereCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("tphere").setExecutor(this);
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (cmd.getName().equalsIgnoreCase("tphere") || sender.hasPermission("ZomboidEssentials.*"))
            {
                if (args.length >= 1)
                {
                    Player target = plugin.getServer().getPlayer(args[0]);
                    if (target != null)
                    {
                        target.teleport(((Player) sender).getLocation());
                        target.sendMessage(ChatColor.GREEN + "You've been teleported to " + sender.getName());
                        sender.sendMessage(ChatColor.GREEN + "You teleported " + target.getName() + " here!");
                    } else
                    {
                        sender.sendMessage(ChatColor.RED + "Target is offline or does not exist!");
                    }
                } else
                {
                    sender.sendMessage(ChatColor.RED + "You must specify a target to teleport here!");
                }
            } else
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to teleport people here!");
            }
        }
        return false;
    }

    // ======================================================= \\

}
