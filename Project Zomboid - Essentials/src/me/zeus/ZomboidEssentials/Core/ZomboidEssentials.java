
package me.zeus.ZomboidEssentials.Core;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import me.zeus.ZomboidEssentials.Commands.CMD_Gamemode;
import me.zeus.ZomboidEssentials.Commands.CMD_KillAll;
import me.zeus.ZomboidEssentials.Commands.CMD_SetSpawn;
import me.zeus.ZomboidEssentials.Commands.CMD_SetWarp;
import me.zeus.ZomboidEssentials.Commands.CMD_Spawn;
import me.zeus.ZomboidEssentials.Commands.CMD_Teleport;
import me.zeus.ZomboidEssentials.Commands.CMD_Time;
import me.zeus.ZomboidEssentials.Commands.CMD_Warp;
import me.zeus.ZomboidEssentials.Commands.ZCMD;
import me.zeus.ZomboidEssentials.Misc.Warp;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;



public class ZomboidEssentials extends JavaPlugin {

    // ======================================================= \\

    private File warpsDir;
    private File rootDir;
    private File[] warpsFiles;

    private Map<String, Warp> warps;

    public Map<String, Warp> getWarps()
    {
        return warps;
    }

    private static ZomboidEssentials plugin;

    public static ZomboidEssentials getInstance()
    {
        return plugin;
    }

    private Location spawn;

    public Location getSpawn()
    {
        return spawn;
    }

    public void setSpawn(Location loc)
    {
        spawn = loc;
        getConfig().set("spawn",
                loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getPitch() + "," + loc.getYaw());
        saveConfig();
    }

    private Map<String, ZCMD> commands;

    public Map<String, ZCMD> getCommands()
    {
        return commands;
    }

    // ======================================================= \\

    @Override
    public void onEnable()
    {
        plugin = this;

        commands = new HashMap<String, ZCMD>();
        warps = new HashMap<String, Warp>();

        handleDirs();
        loadCommands();
        loadWarps();
        handleConfig();
        loadSpawn();
    }

    @Override
    public void onDisable()
    {
        plugin = null;
    }

    // ======================================================= \\

    // config.yml
    private void handleConfig()
    {
        File configFile = new File(getDataFolder() + "config.yml");
        if (!configFile.exists())
        {
            getConfig().addDefault("spawn", "World,0,0,0,0,0");
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    // commands
    private void loadCommands()
    {
        commands.put("gamemode", new CMD_Gamemode());
        commands.put("killall", new CMD_KillAll());
        commands.put("setspawn", new CMD_SetSpawn());
        commands.put("setwarp", new CMD_SetWarp());
        commands.put("spawn", new CMD_Spawn());
        commands.put("teleport", new CMD_Teleport());
        commands.put("time", new CMD_Time());
        commands.put("warp", new CMD_Warp());
        commands.put("spawner", new CMD_Spawner());
    }

    // warps
    private void loadWarps()
    {
        warpsFiles = warpsDir.listFiles();
        for (int i = 0; i < warpsFiles.length; i++)
        {
            if (!warpsFiles[i].exists())
            {
                return;
            }
            try
            {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(warpsFiles[i]));
                Warp warp = (Warp) ois.readObject();
                ois.close();
                warps.put(warp.getName(), warp);
                System.out.println("Loaded warp " + warp.getName());
            } catch (IOException | ClassNotFoundException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }

    // handle dirs
    private void handleDirs()
    {
        // root dir
        rootDir = new File(getDataFolder() + "");
        if (!rootDir.exists())
        {
            rootDir.mkdir();
        }

        // warps dir
        warpsDir = new File(getDataFolder() + File.separator + "warps");
        if (!warpsDir.exists())
        {
            warpsDir.mkdir();
        }
    }

    // spawn location
    private void loadSpawn()
    {
        String[] loc = getConfig().getString("spawn").split(",");
        Location newLoc = new Location(getServer().getWorld(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2]),
                Double.parseDouble(loc[3]));
        newLoc.setPitch(Float.parseFloat(loc[4]));
        newLoc.setYaw(Float.parseFloat(loc[5]));
        spawn = newLoc;
    }

    // ======================================================= \\

}
