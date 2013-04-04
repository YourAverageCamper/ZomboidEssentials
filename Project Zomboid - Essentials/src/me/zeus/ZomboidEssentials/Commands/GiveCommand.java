
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;



public class GiveCommand implements CommandExecutor {

    // ======================================================= \\

    @SuppressWarnings("unused")
    private ZomboidEssentials plugin;

    public GiveCommand(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("give").setExecutor(this);
    }

    // ======================================================= \\

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.Give") || sender.hasPermission("ZomboidEssentials.*"))
            {
                if (args.length >= 1)
                {
                    try
                    {
                        for (Material mat : Material.values())
                        {
                            if (args[0].equalsIgnoreCase(mat.toString().replace("_", "")))
                            {
                                ((Player) sender).getInventory().addItem(new ItemStack(mat, 64));
                                sender.sendMessage(ChatColor.BLUE + "[Give] " + ChatColor.GREEN + "Gave you: " + args[0]);
                            }
                        }
                    } catch (NullPointerException npe)
                    {
                        sender.sendMessage(ChatColor.BLUE + "[Give] " + ChatColor.RED + "Invalid item type.");
                    }
                }
            } else
            {
                sender.sendMessage(ChatColor.BLUE + "[Give] " + ChatColor.RED + "You don't have permission to use this!");
            }
        }
        return false;
    }
    // ======================================================= \\

}
