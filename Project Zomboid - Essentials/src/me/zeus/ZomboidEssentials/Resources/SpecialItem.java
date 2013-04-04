
package me.zeus.ZomboidEssentials.Resources;


import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public enum SpecialItem
{

    AIR(WeaponType.AIR),
    NOOB_SWORD(WeaponType.NOOB_SWORD),
    NOOB_BOW(WeaponType.NOOB_BOW);

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
            meta = is.getItemMeta();
            meta.setLore(Arrays.asList("§5You're a noob for using this!"));
            meta.setDisplayName("§eNoob Sword");
            is.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
            is.setItemMeta(meta);
            return is;
        case NOOB_BOW:
            is = new ItemStack(Material.BOW, 1);
            meta = is.getItemMeta();
            meta.setLore(Arrays.asList("§5Still can't afford REAL equipment?"));
            meta.setDisplayName("§eNoob Bow");
            is.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
            is.setItemMeta(meta);
        }
        return null;
    }

}
