
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;



public class KillAllCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public KillAllCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("killall").setExecutor(this);
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.KillAll") || sender.hasPermission("ZomboidEssentials.*"))
            {
                int count = 0;
                for (Entity e : ((Player) sender).getWorld().getEntities())
                {
                    if (!(e.getType().equals(EntityType.PLAYER) || e.getType().equals(EntityType.PAINTING)))
                    {
                        e.remove();
                        count++;
                    }
                }
                plugin.getServer().broadcastMessage(ChatColor.GREEN + "Cleared " + count + " entities!");
            }
        }
        return false;
    }

    // ======================================================= \\

}
