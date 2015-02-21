package me.stashcat.enCore;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public interface enPlugin extends ClassBase {
    Map<String, Listener> listeners = new HashMap<String, Listener>();

    default public void onEnable(){
    	init();
        for (Listener list : listeners.values())
            Bukkit.getPluginManager().registerEvents(list, (Plugin) this);
        init();
        log("Enabled.");
    }

    default public void onDisable(){
    	
    }

    void init();
    
    default void addListener(String id, Listener l){
    	listeners.put(id, l);
    }
}
