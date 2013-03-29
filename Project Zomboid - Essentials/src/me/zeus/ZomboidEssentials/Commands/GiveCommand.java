
package me.zeus.ZomboidEssentials.Commands;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    // ======================================================= \\

    private List<Material> closestMatches(String input)
    {
        ArrayList<Material> matchList = new ArrayList<Material>();
        for (Material mat : Material.values())
        {
            if (mat.name().replace("_", " ").toLowerCase().equals(input.toLowerCase()) || String.valueOf(mat.getId()).equals(input))
            {
                return Arrays.asList(mat);
            } else if (mat.name().replace("_", " ").toLowerCase().contains(input.toLowerCase()))
            {
                matchList.add(mat);
            }
        }
        return matchList;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if (sender.hasPermission("ZomboidEssentials.Give") || sender.hasPermission("ZomboidEssentials.*"))
            {
                String[] inputs = Arrays.toString(args).replace(",", "").replace("[", "").replace("]", "").split(":");

                String input = inputs[0];
                int data = inputs.length > 2 ? Integer.parseInt(inputs[2]) : 0, amount = inputs.length > 1 ? Integer.parseInt(inputs[1]) : 64;
                List<Material> matList = closestMatches(input);
                String[] matArray = new String[matList.size()];
                for (int i = 0; i < matList.size(); i++)
                {
                    matArray[i] = matList.get(i).name().toLowerCase().replace("_", " ");
                }
                if (matList.size() > 1)
                {
                    sender.sendMessage(ChatColor.BLUE + "[Give] " + ChatColor.GOLD + "Did you mean: ");
                    sender.sendMessage(Arrays.toString(matArray).replace("[", "").replace("]", ""));
                } else if (matList.size() == 1)
                {
                    sender.sendMessage(ChatColor.RED + "[Give] " + ChatColor.WHITE + "Giving you " + amount + " "
                            + matList.get(0).name().toLowerCase().replace("_", " ") + (data == 0 ? "" : ":" + data) + "!!");
                    ((Player) sender).getInventory().addItem(new ItemStack(matList.get(0), amount, (byte) data));
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
