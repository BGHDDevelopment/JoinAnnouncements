package me.noodles.join.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * Author:  Kim (Thinkverse) Hallberg <work@hallberg.kim>
 * Created: 2020-04-11 05:29
 */
public class Common {

    public static void tell(final CommandSender sender, final String... messages) {
        Arrays.stream(messages).map(Common::translate).forEach(sender::sendMessage);
    }

    public static void tell(final CommandSender sender, final List<String> messages) {
        messages.stream().map(Common::translate).forEach(sender::sendMessage);
    }

    private static String translate(final String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

}
