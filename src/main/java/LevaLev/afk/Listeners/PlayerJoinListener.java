package LevaLev.afk.Listeners;

import LevaLev.afk.Utils.ShardDataStorageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.io.IOException;
import java.util.UUID;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {


        UUID uuid = e.getPlayer().getUniqueId();
        int amount = 0;

        if (!ShardDataStorageUtil.hasBeenRegistered(uuid)) {
            try {
                ShardDataStorageUtil.createShardData(uuid, amount);
            } catch (IOException o) {
                throw new RuntimeException(o);
            }
        }

    }

}
