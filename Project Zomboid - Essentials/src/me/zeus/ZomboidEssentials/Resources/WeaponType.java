
package me.zeus.ZomboidEssentials.Resources;


public enum WeaponType
{

    AIR(""),
    NOOB_SWORD("§eNoob Sword"),
    NOOB_BOW("§eNoob Bow");

    String realName;

    WeaponType(String name)
    {
        realName = name;
    }

    public String getName()
    {
        return realName;
    }

    public String getName(WeaponType type)
    {
        return type.realName;
    }

    public WeaponType getWeapon(String name)
    {
        for (WeaponType w : values())
        {
            if (name.equalsIgnoreCase(w.realName))
            {
                return w;
            } else
            {
                return AIR;
            }
        }
        return AIR;
    }

}
