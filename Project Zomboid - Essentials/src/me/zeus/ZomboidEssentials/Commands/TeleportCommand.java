
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class TeleportCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public TeleportCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.Teleport") || sender.hasPermission("ZomboidEssentials.*"))
            {
                if (args.length >= 1)
                {
                    Player target = plugin.getServer().getPlayer(args[0]);
                    if (target != null)
                    {
                        ((Player) sender).teleport(target.getLocation());
                        sender.sendMessage(ChatColor.GREEN + "Teleported to " + target.getName());
                    } else
                    {
                        sender.sendMessage(ChatColor.RED + "Target is offline or does not exist!");
                    }
                } else
                {
                    sender.sendMessage(ChatColor.RED + "You must specify a target to teleport to!");
                }
            } else
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to teleport!");
            }
        }
        return false;
    }

    // ======================================================= \\

}
