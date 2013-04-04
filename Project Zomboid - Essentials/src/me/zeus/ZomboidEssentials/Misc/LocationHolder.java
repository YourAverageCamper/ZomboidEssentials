
package me.zeus.ZomboidEssentials.Misc;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.Location;



public class LocationHolder {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public LocationHolder(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    Location spawnloc;

    public Location getSpawn()
    {
        String[] spawnLoc = plugin.getConfig().getString("Spawn_Location").split(",");
        spawnloc = new Location(plugin.getServer().getWorld(spawnLoc[0]), Double.parseDouble(spawnLoc[1]), Double.parseDouble(spawnLoc[2]),
                Double.parseDouble(spawnLoc[3]));
        spawnloc.setPitch(Float.parseFloat(spawnLoc[4]));
        spawnloc.setYaw(Float.parseFloat(spawnLoc[5]));
        return spawnloc;
    }

    // ======================================================= \\

}
