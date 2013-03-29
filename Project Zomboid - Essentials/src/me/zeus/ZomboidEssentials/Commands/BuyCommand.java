
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Resources.EcoPlayer;
import me.zeus.ZomboidEssentials.Resources.ShopItem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class BuyCommand implements CommandExecutor {

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public BuyCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    private EcoPlayer ecoplayer;

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {

            if (args.length < 2)
            {
                sender.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.RED + "You must specify an item and amount to buy!");
                return false;
            }

            else if (args.length >= 2)
            {
                if (args[0] != null && args[1] != null)
                {
                    try
                    {

                        int amount = Integer.parseInt(args[0]);
                        ecoplayer = plugin.eco.ecoPlayers.get(sender.getName());

                        if (ShopItem.parseItem(args[1]).equals(ShopItem.AIR))
                        {
                            sender.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.RED + "You can't buy air!");
                            return false;
                        }

                        plugin.shophandler.buyItem(ecoplayer, ShopItem.parseItem(args[1]), amount);

                    } catch (NumberFormatException nfe)
                    {
                        sender.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.RED + "Invalid amount!");
                        return false;
                    }
                } else
                {
                    sender.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.RED + "You must specify an amount and item!!");
                    return false;
                }
            }

        }
        return false;
    }
    // ======================================================= \\

}
