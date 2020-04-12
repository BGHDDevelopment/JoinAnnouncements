package me.noodles.join.utilities;

import me.noodles.join.Join;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public final class UpdateChecker {
    private final String URL = "https://api.spigotmc.org/legacy/update.php?resource=";

    private final Join plugin;
    private final int resourceId;

    public UpdateChecker(Join plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getLatestVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(getPlugin(), () -> {
           try (InputStream inputStream = new URL(URL + getResourceId()).openStream(); Scanner scanner = new Scanner(inputStream)) {
               if (scanner.hasNext()) {
                   consumer.accept(scanner.next());
               }
           } catch (IOException exception) {
               getPlugin().getLogger().info("Cannot look for updates: " + exception.getMessage());
           }
        });
    }

    private Join getPlugin() {
        return plugin;
    }

    private int getResourceId() {
        return resourceId;
    }

}
