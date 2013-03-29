
package me.zeus.ZomboidEssentials.Resources;


import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public enum SpecialItem
{

    AIR(WeaponType.AIR),
    NOOB_SWORD(WeaponType.NOOB_SWORD);

    private WeaponType type;
    private ItemStack is;
    private ItemMeta meta;

    SpecialItem(WeaponType wea)
    {
        type = wea;
    }

    public ItemStack getAsItem()
    {
        switch (type)
        {
        case AIR:
            return null;
        case NOOB_SWORD:
            is = new ItemStack(Material.WOOD_SWORD, 1);
            is.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            meta = is.getItemMeta();
            meta.setLore(Arrays.asList("§5Hah, only noobs use this!"));
            meta.setDisplayName("§eNoob Sword");
            is.setItemMeta(meta);
            return is;
        }
        return null;
    }

}
