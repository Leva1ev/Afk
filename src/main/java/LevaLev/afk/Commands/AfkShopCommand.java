package LevaLev.afk.Commands;

import LevaLev.afk.Afk;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AfkShopCommand implements CommandExecutor {


    Afk plugin;

    public AfkShopCommand(Afk plugin) {
        this.plugin = plugin;
    }

    public boolean hasAvaliableSlot(Player player){
        Inventory inv = player.getInventory();
        for (ItemStack item: inv.getContents()) {
            if(item == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender instanceof Player p){
            plugin.openTokenShop(p);
        }
        return true;
    }

}
