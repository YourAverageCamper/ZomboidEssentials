
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SpawnCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public SpawnCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("spawn").setExecutor(this);
    }

    public Location spawnlocation;

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            ((Player) sender).teleport(plugin.locationholder.getSpawn());
        }
        return false;
    }

    // ======================================================= \\

}
