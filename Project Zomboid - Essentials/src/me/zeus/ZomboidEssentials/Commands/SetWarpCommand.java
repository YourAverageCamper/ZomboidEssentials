
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Misc.Warp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetWarpCommand implements CommandExecutor {

    // ======================================================= \\

    public ZomboidEssentials plugin;

    public SetWarpCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.SetWarp"))
            {
                if (args.length >= 1)
                {
                    new Warp(plugin, args[0], ((Player) sender).getLocation());
                    sender.sendMessage(ChatColor.GREEN + "Warp set!");
                }
            }
        }
        return false;
    }

    // ======================================================= \\

}
