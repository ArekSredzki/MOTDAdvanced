package ca.ziddia.motd;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class MOTDAdvancedPlayerListener extends PlayerListener{
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(MOTDAdvanced.messages.getString(MOTDAdvanced.Permissions.getGroup(player.getWorld().getName(), player.getName())));
        System.out.println(MOTDAdvanced.messages.getString(MOTDAdvanced.Permissions.getGroup(player.getWorld().getName(), player.getName())));
    }
}
