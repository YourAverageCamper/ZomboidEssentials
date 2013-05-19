
package me.zeus.ZomboidEssentials.Commands;


import me.zeus.ZomboidEssentials.Core.ZomboidEssentials;
import me.zeus.ZomboidEssentials.Misc.Warp;
import me.zeus.ZomboidEssentials.Util.ZMessenger;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class CMD_SetWarp implements ZCMD {

    @Override
    public boolean execute(CommandSender sender, String[] args)
    {
        if (!(sender.hasPermission("ZomboidEssentials.SetWarp") || sender.hasPermission("ZomboidEssentials.*")))
        {
            ZMessenger.invalidPerms(sender, "ZomboidEssentials.SetWarp");
            return false;
        }

        if (args.length < 1)
        {
            ZMessenger.invalidArgs(sender);
            return false;
        }

        Warp warp = new Warp(args[0], ((Player) sender).getLocation());
        ZomboidEssentials.getInstance().getWarps().put(args[0], warp);
        warp.save();
        ZMessenger.warpSet(sender, args[0]);
        return false;
    }

}
