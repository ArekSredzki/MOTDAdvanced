package ca.ziddia.motd;
 
import java.util.logging.Logger;

import org.bukkit.event.server.ServerListener;
import org.bukkit.event.server.PluginEvent;
import com.nijikokun.bukkit.Permissions.Permissions;
 
public class MOTDAdvancedPluginListener extends ServerListener {
       
    private MOTDAdvanced plugin;
    private final Logger log = Logger.getLogger("Minecraft");
    
    public MOTDAdvancedPluginListener(MOTDAdvanced instance){
        this.plugin = instance;
    }
    
    public void onPluginEnabled(PluginEvent event){
    	if(event.getPlugin().getDescription().getName().equals("Permissions")) {
    		MOTDAdvanced.Permissions = ((Permissions) plugin.getServer().getPluginManager().getPlugin("Permissions")).getHandler();
    		log.info("MOTDAdvanced - Found Permissions");
    	}
    }
    
}