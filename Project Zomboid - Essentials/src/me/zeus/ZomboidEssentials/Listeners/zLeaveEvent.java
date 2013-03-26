
package me.zeus.ZomboidEssentials.Listeners;


import me.zeus.ZomboidEssentials.Core.EcoPlayer;
import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class zLeaveEvent implements Listener {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public zLeaveEvent(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    private EcoPlayer eleaver;
    private Player quitter;

    @EventHandler
    public void onJoin(PlayerQuitEvent e)
    {
        // vars
        quitter = e.getPlayer();
        eleaver = new EcoPlayer(plugin, quitter.getName());

        // eco stuff
        eleaver.saveMoney();
        plugin.eco.ecoPlayers.remove(quitter.getName());

    }

    // ======================================================= \\

}
