
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetSpawnCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public SetSpawnCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.SetSpawn") || sender.hasPermission("ZomboidEssentials.*"))
            {
                double x = ((Player) sender).getLocation().getX();
                double y = ((Player) sender).getLocation().getY();
                double z = ((Player) sender).getLocation().getZ();
                double pitch = ((Player) sender).getLocation().getPitch();
                double yaw = ((Player) sender).getLocation().getYaw();
                plugin.getConfig().set("Spawn_Location",
                        ((Player) sender).getWorld().getName() + "," + x + "," + y + "," + z + "," + pitch + "," + yaw);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "Spawn location set!");
            } else
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to set spawn!");
            }
        }
        return false;
    }

    // ======================================================= \\

}
