
package me.zeus.ZomboidEssentials.Listeners;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Misc.Warp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;



public class zInteractEvent implements Listener {

    private ZomboidEssentials plugin;

    public zInteractEvent(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        if (e.getClickedBlock() != null)
        {
            if (e.getClickedBlock().getType().equals(Material.WALL_SIGN))
            {
                Sign sign = (Sign) e.getClickedBlock().getState();
                if (sign.getLine(0) != null && sign.getLine(0).equalsIgnoreCase("[Warp]"))
                {
                    if (sign.getLine(1) != null)
                    {
                        try
                        {
                            e.getPlayer().teleport(new Warp(plugin).getWarpLocation(sign.getLine(1)));
                        } catch (NullPointerException npe)
                        {
                            e.getPlayer().sendMessage(ChatColor.RED + "Invalid warp! ");
                        }
                    }
                }
            }
        }
    }

}
