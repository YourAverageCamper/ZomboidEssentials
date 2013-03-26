
package me.zeus.ZomboidEssentials.Core;


import me.zeus.ZomboidEssentials.Commands.MoneyCommand;
import me.zeus.ZomboidEssentials.Commands.SetMoneyCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportCommand;
import me.zeus.ZomboidEssentials.Commands.TeleportHereCommand;
import me.zeus.ZomboidEssentials.Listeners.zJoinEvent;
import me.zeus.ZomboidEssentials.Listeners.zLeaveEvent;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ZomboidEssentials extends JavaPlugin {

    // ======================================================= \\

    public Economy eco;

    private PluginManager pm;

    private zJoinEvent zjoinevent;
    private zLeaveEvent zleaveevent;
    private MoneyCommand moneycommand;
    private SetMoneyCommand setmoneycommand;
    private TeleportCommand teleportcommand;
    private TeleportHereCommand teleportherecommand;

    // ======================================================= \\

    @Override
    public void onEnable()
    {
        // set up variables
        zjoinevent = new zJoinEvent(this);
        zleaveevent = new zLeaveEvent(this);
        moneycommand = new MoneyCommand(this);
        setmoneycommand = new SetMoneyCommand(this);
        teleportcommand = new TeleportCommand(this);
        teleportherecommand = new TeleportHereCommand(this);

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
    }

    // ======================================================= \\

}
