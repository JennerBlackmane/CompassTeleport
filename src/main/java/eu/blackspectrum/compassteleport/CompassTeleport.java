package eu.blackspectrum.compassteleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.*;

import eu.blackspectrum.compassteleport.listeners.*;
import eu.blackspectrum.compassteleport.handlers.*;

import java.util.*;

public class CompassTeleport extends JavaPlugin
{
    public YamlHandler yamlHandler;
    public CommandHandler commandHandler;
    public PlayerListener playerListener;
    public HashMap<String, Boolean> teleportingPlayers = new HashMap<String, Boolean>();
    
    @Override
	public void onEnable() {
        this.yamlHandler = new YamlHandler(this);
        this.logInfo("Yamls loaded!");
        this.commandHandler = new CommandHandler(this);
        this.logInfo("Commands registered!");
        this.playerListener = new PlayerListener(this);
        this.logInfo("Listeners registered!");
    }
    
    @Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
    	return commandHandler.onCommand(sender, cmd, label, args);
    }
    
    public void logInfo(final String message) {
        this.getLogger().info(message);
    }
    
    public void logWarning(final String message) {
        this.getLogger().warning(message);
    }
    
}
