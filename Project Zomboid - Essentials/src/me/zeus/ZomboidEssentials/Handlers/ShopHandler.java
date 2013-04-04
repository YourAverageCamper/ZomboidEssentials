
package me.zeus.ZomboidEssentials.Handlers;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Resources.EcoPlayer;
import me.zeus.ZomboidEssentials.Resources.ShopItem;
import me.zeus.ZomboidEssentials.Resources.SpecialItem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



public class ShopHandler {

    // ======================================================= \\

    @SuppressWarnings("unused")
    private ZomboidEssentials plugin;

    public ShopHandler(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    // ======================================================= \\

    public void buyItem(EcoPlayer p, ShopItem item, int amount)
    {
        int total = 0;
        Player player = Bukkit.getServer().getPlayer(p.getName());
        total = item.getPrice() * amount;
        if (p.getMoney() >= total)
        {
            player.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.GREEN + "You purchased " + item.getName() + " for $" + total);
            p.setMoney(p.getMoney() - total);
            handleBought(p, item, amount);
        } else
        {
            player.sendMessage(ChatColor.BLUE + "[Shop] " + ChatColor.RED + "Insufficient funds!");
            return;
        }
    }

    // ======================================================= \\

    private void handleBought(EcoPlayer p, ShopItem item, int amount)
    {
        Player player = Bukkit.getServer().getPlayer(p.getName());

        switch (item)
        {
        case AIR:
            break;
        case HEAL:
            player.setHealth(20);
            player.setFoodLevel(20);
            break;
        case REPAIR_HAND:
            player.getItemInHand().setDurability((short) 0);
            break;
        case JUMP:
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1, 20 * 30));
            break;
        case SPEED:
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 20 * 30));
            break;
        case STRENGTH:
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 20 * 30));
            break;
        case REGEN:
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 20 * 30));
            break;
        case NOOB_SWORD:
            player.getInventory().addItem(SpecialItem.NOOB_SWORD.getAsItem());
            break;
        case NOOB_BOW:
            player.getInventory().addItem(SpecialItem.NOOB_SWORD.getAsItem());
            break;
        }

    }

    // ======================================================= \\

}
