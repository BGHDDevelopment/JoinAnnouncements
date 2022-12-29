package com.bghddevelopment.join.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * Author:  Kim (Thinkverse) Hallberg <work@hallberg.kim>
 * Created: 2020-04-11 05:29
 */
public class Color {

    public static void tell(final CommandSender sender, final String... messages) {
        Arrays.stream(messages).map(Color::translate).forEach(sender::sendMessage);
    }

    public static void tell(final CommandSender sender, final List<String> messages) {
        messages.stream().map(Color::translate).forEach(sender::sendMessage);
    }

    public static String translate(String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

}
