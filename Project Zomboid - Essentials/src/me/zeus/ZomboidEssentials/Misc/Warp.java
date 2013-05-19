
package me.zeus.ZomboidEssentials.Misc;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Util.SerializableLocation;

import org.bukkit.Location;



public class Warp implements Serializable {

    // ======================================================= \\

    /**
     * 
     */
    private static final long serialVersionUID = 5480232812850254505L;
    private String name;
    private SerializableLocation location;

    // ======================================================= \\

    public Warp(String name, Location loc)
    {
        this.name = name;
        location = new SerializableLocation(loc);
    }

    public void save()
    {
        File f = new File(ZomboidEssentials.getInstance().getDataFolder() + File.separator + "warps" + File.separator + name + ".warp");
        if (f.exists())
        {
            return;
        }
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(this);
            oos.close();
            System.out.println("Saved warp: " + name);  
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    // ======================================================= \\

    public String getName()
    {
        return name;
    }

    public Location getLocation()
    {
        return location.getLocation();
    }

    // ======================================================= \\

}
