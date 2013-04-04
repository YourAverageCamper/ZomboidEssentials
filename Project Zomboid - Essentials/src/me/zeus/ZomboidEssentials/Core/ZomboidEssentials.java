
package me.zeus.ZomboidEssentials.Core;


import java.io.File;
import java.io.IOException;

import me.zeus.ZomboidEssentials.Commands.BuyCommand;
import me.zeus.ZomboidEssentials.Commands.GiveCommand;
import me.zeus.ZomboidEssentials.Commands.KillAllCommand;
import me.zeus.ZomboidEssentials.Commands.MoneyCommand;
import me.zeus.ZomboidEssentials.Commands.SetMoneyCommand;
import me.zeus.ZomboidEssentials.Commands.SetSpawnCommand;
import me.zeus.ZomboidEssentials.Commands.SetWarpCommand;
import me.zeus.ZomboidEssentials.Commands.SpawnCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportHereCommand;
import me.zeus.ZomboidEssentials.Commands.TimeCommand;
import me.zeus.ZomboidEssentials.Handlers.ShopHandler;
import me.zeus.ZomboidEssentials.Listeners.zInteractEvent;
import me.zeus.ZomboidEssentials.Listeners.zJoinEvent;
import me.zeus.ZomboidEssentials.Listeners.zLeaveEvent;
import me.zeus.ZomboidEssentials.Misc.LocationHolder;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ZomboidEssentials extends JavaPlugin {

    // ======================================================= \\

    private File config;
    public File warpsFile;

    // ======================================================= \\

    public Economy eco;
    public ShopHandler shophandler;
    public LocationHolder locationholder;

    // ======================================================= \\

    private PluginManager pm;

    // ======================================================= \\

    private SpawnCommand spawncommand;

    // ======================================================= \\

    @Override
    public void onEnable()
    {
        // setup stuff via method
        handleConfig();
        handleCommands();

        // set up handlers/holders **
        shophandler = new ShopHandler(this);
        locationholder = new LocationHolder(this);

        // setup economy **
        eco = new Economy(this);
        eco.setupEconomy();

        // register events **
        pm = getServer().getPluginManager();
        pm.registerEvents(new zJoinEvent(this), this);
        pm.registerEvents(new zInteractEvent(this), this);
        pm.registerEvents(new zLeaveEvent(this), this);

        spawncommand.spawnlocation = locationholder.getSpawn();

        reloadWarps();
    }

    // ======================================================= \\

    // config.yml
    private void handleConfig()
    {
        config = new File(getDataFolder() + "config.yml");
        if (!config.exists())
        {
            getConfig().addDefault("Spawn_Location", "World,0,0,0");
            getConfig().options().copyDefaults(true);
        }

    }

    // commands
    private void handleCommands()
    {
        getCommand("buy").setExecutor(new BuyCommand(this));
        getCommand("give").setExecutor(new GiveCommand(this));
        getCommand("killall").setExecutor(new KillAllCommand(this));
        getCommand("money").setExecutor(new MoneyCommand(this));
        getCommand("setmoney").setExecutor(new SetMoneyCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("setwarp").setExecutor(new SetWarpCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("teleport").setExecutor(new TeleportCommand(this));
        getCommand("tphere").setExecutor(new TeleportHereCommand(this));
        getCommand("time").setExecutor(new TimeCommand(this));

        spawncommand = new SpawnCommand(this);
    }

    public void reloadWarps()
    {
        warpsFile = new File(getDataFolder() + File.separator + "warps.yml");
        if (!warpsFile.exists())
        {
            try
            {
                warpsFile.createNewFile();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // ======================================================= \\

}
