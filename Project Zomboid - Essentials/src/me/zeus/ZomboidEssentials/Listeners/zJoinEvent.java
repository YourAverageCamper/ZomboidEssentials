
package me.zeus.ZomboidEssentials.Listeners;


import me.zeus.ZomboidEssentials.Core.EcoPlayer;
import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class zJoinEvent implements Listener {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public zJoinEvent(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    private EcoPlayer ejoiner;
    private EcoPlayer ecoplayer;
    private Player joiner;

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        // vars
        joiner = e.getPlayer();
        ecoplayer = new EcoPlayer(plugin);
        ejoiner = new EcoPlayer(plugin, joiner.getName());

        // setup economy
        if (ecoplayer.hasAccount(joiner.getName()))
        {
            ejoiner.loadMoney();
            plugin.eco.ecoPlayers.put(joiner.getName(), ejoiner);
        } else
        {
            plugin.eco.ecoPlayers.put(joiner.getName(), ejoiner);
        }

    }

    // ======================================================= \\

}
