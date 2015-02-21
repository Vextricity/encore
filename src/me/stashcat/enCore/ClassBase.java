package me.stashcat.enCore;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public interface ClassBase {
	
	default void log(String msg){
		log(msg, Level.INFO);
	}

	default void log(String msg, Level lvl){
		Bukkit.getLogger().log(lvl, msg);
	}

	default String format(String msg){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	default void sendMsg(CommandSender s, String msg){
		s.sendMessage(format(msg));
	}

	default void addListElement(FileConfiguration cnf, String key, String... element) {
        List<String> list = cnf.getStringList(key);
        list.addAll(Arrays.asList(element));
        cnf.set(key, list);
    }

	default String getAmountFormat(int amount, String singular, String plural){
    	String amountStr = "" + amount;
    	if (amount == 0)
    		return plural;
    	
    	if (amountStr.charAt(amountStr.length() - 1) == '1')
    		if (amountStr.length() >= 2 && amountStr.charAt(amountStr.length() - 2) == '1')
    			return amountStr + " " + plural;
    		else
    			return amountStr + " " + singular;
    	else
    		return amountStr + " " + plural;
    }

	default int digitize(Object amount){
    	int integer;
    	try{
			integer = Integer.parseInt(amount.toString());
			return integer;
		} catch (NumberFormatException e) {
				return -1;
		}
    }
}
