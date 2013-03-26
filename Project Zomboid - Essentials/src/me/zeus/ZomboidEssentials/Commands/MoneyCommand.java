
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.EcoPlayer;
import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class MoneyCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public MoneyCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    private EcoPlayer ecoplayer;

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.Balance") || sender.hasPermission("ZomboidEssentials.*"))
            {
                ecoplayer = plugin.eco.ecoPlayers.get(sender.getName());
                sender.sendMessage(ChatColor.GREEN + "$" + ecoplayer.getMoney());
            } else
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to check your balance!");
            }
        }
        return false;
    }

    // ======================================================= \\

}
