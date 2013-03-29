
package me.zeus.ZomboidEssentials.Core;


import java.io.File;

import me.zeus.ZomboidEssentials.Commands.BuyCommand;
import me.zeus.ZomboidEssentials.Commands.GiveCommand;
import me.zeus.ZomboidEssentials.Commands.KillAllCommand;
import me.zeus.ZomboidEssentials.Commands.MoneyCommand;
import me.zeus.ZomboidEssentials.Commands.SetMoneyCommand;
import me.zeus.ZomboidEssentials.Commands.SetSpawnCommand;
import me.zeus.ZomboidEssentials.Commands.SpawnCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportHereCommand;
import me.zeus.ZomboidEssentials.Handlers.ShopHandler;
import me.zeus.ZomboidEssentials.Listeners.zJoinEvent;
import me.zeus.ZomboidEssentials.Listeners.zLeaveEvent;

import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ZomboidEssentials extends JavaPlugin {

    // ======================================================= \\

    public Economy eco;
    public ShopHandler shophandler;

    private PluginManager pm;
    private Location spawnloc;

    private zJoinEvent zjoinevent;
    private zLeaveEvent zleaveevent;

    private MoneyCommand moneycommand;
    private SetMoneyCommand setmoneycommand;
    private BuyCommand buycommand;
    private TeleportCommand teleportcommand;
    private TeleportHereCommand teleportherecommand;
    private SetSpawnCommand setspawncommand;
    private SpawnCommand spawncommand;
    private KillAllCommand killallcommand;
    private GiveCommand givecommand;

    // ======================================================= \\

    @Override
    public void onEnable()
    {
        File config = new File(getDataFolder() + "config.yml");
        if (!config.exists())
        {
            getConfig().addDefault("Spawn_Location", "World,0,0,0");
            getConfig().options().copyDefaults(true);
        }
        // set up variables
        shophandler = new ShopHandler(this);

        zjoinevent = new zJoinEvent(this);
        zleaveevent = new zLeaveEvent(this);

        moneycommand = new MoneyCommand(this);
        buycommand = new BuyCommand(this);
        setmoneycommand = new SetMoneyCommand(this);
        teleportcommand = new TeleportCommand(this);
        teleportherecommand = new TeleportHereCommand(this);
        setspawncommand = new SetSpawnCommand(this);
        spawncommand = new SpawnCommand(this);
        killallcommand = new KillAllCommand(this);
        givecommand = new GiveCommand(this);

        // eco
        eco = new Economy(this);
        eco.setupEconomy();

        // events
        pm = getServer().getPluginManager();
        pm.registerEvents(zjoinevent, this);
        pm.registerEvents(zleaveevent, this);

        // commands
        getCommand("money").setExecutor(moneycommand);
        getCommand("teleport").setExecutor(teleportcommand);
        getCommand("tphere").setExecutor(teleportherecommand);
        getCommand("setmoney").setExecutor(setmoneycommand);
        getCommand("buy").setExecutor(buycommand);
        getCommand("setspawn").setExecutor(setspawncommand);
        getCommand("spawn").setExecutor(spawncommand);
        getCommand("killall").setExecutor(killallcommand);
        getCommand("give").setExecutor(givecommand);

        spawncommand.spawnlocation = getSpawn();
    }

    // ======================================================= \\

    public Location getSpawn()
    {
        String[] spawnLoc = getConfig().getString("Spawn_Location").split(",");
        spawnloc = new Location(getServer().getWorld(spawnLoc[0]), Double.parseDouble(spawnLoc[1]), Double.parseDouble(spawnLoc[2]),
                Double.parseDouble(spawnLoc[3]));
        spawnloc.setPitch(Float.parseFloat(spawnLoc[4]));
        spawnloc.setYaw(Float.parseFloat(spawnLoc[5]));
        return spawnloc;
    }
}
