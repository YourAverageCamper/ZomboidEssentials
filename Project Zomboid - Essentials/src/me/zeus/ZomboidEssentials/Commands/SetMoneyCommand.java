
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Resources.EcoPlayer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetMoneyCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public SetMoneyCommand(ZomboidEssentials plugin)
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
            if (sender.hasPermission("ZomboidEssentials.SetMoney") || sender.hasPermission("ZomboidEssentials.*"))
            {
                if (args.length == 0)
                {
                    sender.sendMessage(ChatColor.RED + "You must supply a name and/or amount!");
                    return false;
                }

                else if (args.length == 1)
                {
                    try
                    {
                        ecoplayer = plugin.eco.ecoPlayers.get(sender.getName());
                        ecoplayer.setMoney(Integer.parseInt(args[0]));
                        sender.sendMessage(ChatColor.GREEN + "Added $" + Integer.parseInt(args[0]) + " to your bank.");
                    } catch (NumberFormatException nfe)
                    {
                        sender.sendMessage(ChatColor.RED + "Invalid number format!");
                        return false;
                    }
                }

                else if (args.length >= 2)
                {
                    Player target = plugin.getServer().getPlayer(args[0]);

                    if (target != null)
                    {
                        try
                        {
                            int amount = Integer.parseInt(args[1]);
                            ecoplayer = plugin.eco.ecoPlayers.get(target.getName());
                            ecoplayer.setMoney(amount);
                            sender.sendMessage(ChatColor.GREEN + "Set " + target.getName() + "'s money to $" + amount);
                        } catch (NumberFormatException nfe)
                        {
                            sender.sendMessage(ChatColor.RED + "Invalid number format!");
                            return false;
                        }
                    }
                }

            } else
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to check your balance!");
            }
        }
        return false;
    }
    // ======================================================= \\

}
