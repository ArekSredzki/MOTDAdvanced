package ca.ziddia.motd;

import java.io.File;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class MOTDAdvanced extends JavaPlugin{
public static PermissionHandler Permissions = null;
 public static MOTDAdvanced instance;
 
 private final MOTDAdvancedPlayerListener playerListener = new MOTDAdvancedPlayerListener();
 private final MOTDAdvancedPluginListener pluginListener = new MOTDAdvancedPluginListener(this);
 public static MOTDAdvancedSettings messages;
 
PluginDescriptionFile pdfFile;

 @Override
 public void onEnable() {
     pdfFile = this.getDescription();
      PluginManager pm = getServer().getPluginManager();
      
      pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
      pm.registerEvent(Event.Type.PLUGIN_ENABLE, pluginListener, Priority.Monitor, this);

 	  PluginDescriptionFile pdfFile = this.getDescription();
      System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
      
      setupPermissions();
      setupMessages();
  }
 private void setupPermissions() {
	 Plugin p = this.getServer().getPluginManager().getPlugin("Permissions");
	 if (p != null && p.isEnabled()) {
		 MOTDAdvanced.Permissions = ((Permissions)p).getHandler();
	 }
 }
	private void setupMessages()
	{
		String directory = this.getFile().getParent() + File.separator + "MOTDAdvanced";
		(new File(directory)).mkdir();
		messages = new MOTDAdvancedSettings(directory + File.separator + "messages.yml");
	}

@Override
 public void onDisable() {
     System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!");
     
}

}



