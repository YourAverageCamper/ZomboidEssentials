
package me.zeus.ZomboidEssentials.Resources;


public enum ShopItem
{

    AIR("Air", 0),
    HEAL("Heal", 50),
    REPAIR_HAND("Repair", 250),
    JUMP("Jump", 50),
    SPEED("Speed", 50),
    STRENGTH("Strength", 50),
    REGEN("Regen", 50),
    NOOB_SWORD("Noob Sword", 15, WeaponType.NOOB_SWORD);

    String name;
    int price;
    WeaponType type;

    ShopItem(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    ShopItem(String name, int price, WeaponType weapon)
    {
        this.name = name;
        this.price = price;
        type = weapon;
    }

    public int getPrice()
    {
        return price;
    }

    public WeaponType getWeaponType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public static ShopItem parseItem(String input)
    {
        if (input != null)
        {
            for (ShopItem it : values())
            {
                if (input.equalsIgnoreCase(it.name.replace(" ", "")))
                {
                    return it;
                }
            }
        }
        return AIR;
    }
}
