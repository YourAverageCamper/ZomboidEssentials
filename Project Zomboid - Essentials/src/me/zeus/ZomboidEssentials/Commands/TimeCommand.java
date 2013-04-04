
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class TimeCommand implements CommandExecutor {

    // ======================================================= \\

    @SuppressWarnings("unused")
    private ZomboidEssentials plugin;

    public TimeCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("time").setExecutor(this);
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.Time"))
            {
                if (args.length < 1)
                {
                    sender.sendMessage(ChatColor.GOLD + "[Time] " + ChatColor.RED + "Invalid time");
                    return false;
                } else if (args.length >= 1)
                {
                    if (args[0].equalsIgnoreCase("day"))
                    {
                        ((Player) sender).getWorld().setTime(0);
                        sender.sendMessage(ChatColor.GOLD + "[Time] " + ChatColor.GREEN + "Set the time to day!");
                    } else if (args[0].equalsIgnoreCase("night"))
                    {
                        ((Player) sender).getWorld().setTime(16000);
                        sender.sendMessage(ChatColor.GOLD + "[Time] " + ChatColor.GREEN + "Set the time to night!");
                    }
                }
            }
        }
        return false;
    }

    // ======================================================= \\

}
