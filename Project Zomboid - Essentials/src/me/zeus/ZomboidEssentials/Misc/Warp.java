
package me.zeus.ZomboidEssentials.Misc;


import java.io.IOException;

import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class Warp {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    private FileConfiguration warps;

    public Warp(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    public Warp(ZomboidEssentials plugin, String name, Location loc)
    {
        this.plugin = plugin;
        warps = YamlConfiguration.loadConfiguration(plugin.warpsFile);
        warps.set("Warps." + name, loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getPitch() + ","
                + loc.getYaw());
        try
        {
            warps.save(plugin.warpsFile);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Location getWarpLocation(String name)
    {
        warps = YamlConfiguration.loadConfiguration(plugin.warpsFile);
        String[] s = warps.get("Warps." + name).toString().split(",");
        Location loc = new Location(Bukkit.getWorld(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]));
        loc.setPitch(Float.parseFloat(s[4]));
        loc.setYaw(Float.parseFloat(s[5]));
        return loc;
    }

    // ======================================================= \\

}
