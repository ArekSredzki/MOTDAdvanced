package ca.ziddia.motd;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerEvent;

public class MOTDAdvancedPlayerListener extends PlayerListener{
    @Override
    public void onPlayerJoin(PlayerEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(MOTDAdvanced.messages.getString(MOTDAdvanced.Permissions.getGroup(player.getWorld().getName(), player.getName())));
        System.out.println(MOTDAdvanced.messages.getString(MOTDAdvanced.Permissions.getGroup(player.getWorld().getName(), player.getName())));
    }
}
