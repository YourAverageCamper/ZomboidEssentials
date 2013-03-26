
package me.zeus.ZomboidEssentials.Core;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;



public class Economy {

    // ======================================================= \\

    public Map<String, EcoPlayer> ecoPlayers;

    private ZomboidEssentials plugin;

    public Economy(ZomboidEssentials plugin)
    {
        this.plugin = plugin;
        ecoPlayers = new HashMap<String, EcoPlayer>();
        accountsFile = new File(plugin.getDataFolder() + File.separator + "accounts.yml");
    }

    public Economy()
    {
        ecoPlayers = new HashMap<String, EcoPlayer>();
        accountsFile = new File(plugin.getDataFolder() + File.separator + "accounts.yml");
    }

    // ======================================================= \\

    private File accountsFile;
    private FileConfiguration accounts;
    private File directory;

    // ======================================================= \\

    public void setupEconomy()
    {
        directory = new File(plugin.getDataFolder() + "");
        if (!accountsFile.exists())
        {
            if (!directory.exists())
            {
                directory.mkdir();
            }
            try
            {
                accountsFile.createNewFile();
            } catch (IOException e)
            {
                System.out.println("[Zomboid-Ess] There was an error setting up the economy stuff!");
                e.printStackTrace();
            }
        }
    }

    public void reload()
    {
        if (accountsFile == null)
        {
            accountsFile = new File(plugin.getDataFolder() + File.separator + "accounts.yml");
        }
        accounts = YamlConfiguration.loadConfiguration(accountsFile);
    }

    public void save()
    {
        try
        {
            for (EcoPlayer e : ecoPlayers.values())
            {
                getAccounts().set(e.getName(), e.getMoney());
            }
            accounts.save(accountsFile);
        } catch (IOException e)
        {
            System.out.println("[Zomboid-Ess] There was an error saving the economy stuff!");
        }
    }

    // ======================================================= \\

    public FileConfiguration getAccounts()
    {
        if (accounts == null || accountsFile == null)
        {
            reload();
        }
        return accounts;
    }

    // ======================================================= \\

}
