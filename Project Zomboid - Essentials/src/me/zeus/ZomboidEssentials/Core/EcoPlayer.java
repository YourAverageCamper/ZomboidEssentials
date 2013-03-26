
package me.zeus.ZomboidEssentials.Core;


public class EcoPlayer {

    // ======================================================= \\

    private int money;
    private String name;

    // ======================================================= \\

    private ZomboidEssentials plugin;

    public EcoPlayer(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
    }

    public EcoPlayer(ZomboidEssentials plugin, String name)
    {
        this.plugin = plugin;
        this.name = name;
        money = 0;
    }

    // ======================================================= \\

    public void setMoney(int amount)
    {
        money = amount;
    }

    public void addMoney(int amount)
    {
        money += amount;
    }

    public void saveMoney()
    {
        plugin.eco.getAccounts().set(getName(), getMoney());
        plugin.eco.save();
    }

    public void loadMoney()
    {
        money = plugin.eco.getAccounts().getInt(name);
    }

    // ======================================================= \\

    public int getMoney()
    {
        return money;
    }

    public int getMoney(EcoPlayer p)
    {
        return p.money;
    }

    public String getName()
    {
        return name;
    }

    public String getName(EcoPlayer p)
    {
        return p.name;
    }

    public boolean hasAccount()
    {
        return plugin.eco.getAccounts().contains(name);
    }

    public boolean hasAccount(String iss)
    {
        return plugin.eco.getAccounts().contains(iss);
    }

    // ======================================================= \\

}
