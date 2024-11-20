package LevaLev.afk.Listeners;

import LevaLev.afk.Afk;
import LevaLev.afk.Utils.ShardDataStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class MenuHandler implements Listener {

    Afk plugin;

    public MenuHandler(Afk plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        //Menu list
        final String tokenShop = ChatColor.BLUE + "" + ChatColor.BOLD + "AFK Shop";

        //Determine which inventory is open
        if (e.getView().getTitle().equalsIgnoreCase(tokenShop)) {
            //Figure out what button was clicked
            switch (e.getCurrentItem().getType()) {
                case GRAY_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    break;
                case SPAWNER:
                    switch (e.getSlot()) {
                        case 10:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 25) {
                                p.sendMessage("You purchased a " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "ZOMBIE" + ChatColor.RESET + " Spawner for" + ChatColor.DARK_PURPLE + " 25 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"vs give "+p.getName()+" zombie 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -25);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                        case 11:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 35) {
                                p.sendMessage("You purchased a " + ChatColor.GRAY + "" + ChatColor.BOLD + "SKELETON" + ChatColor.RESET + " Spawner for" + ChatColor.DARK_PURPLE + " 35 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"vs give "+p.getName()+" skeleton 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -35);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                        case 12:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 50) {
                                p.sendMessage("You purchased a " + ChatColor.GREEN + "" + ChatColor.BOLD + "CREEPER" + ChatColor.RESET + " Spawner for" + ChatColor.DARK_PURPLE + " 50 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"vs give "+p.getName()+" creeper 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -50);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                        case 13:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 80) {
                                p.sendMessage("You purchased a " + ChatColor.GOLD + "" + ChatColor.BOLD + "BLAZE" + ChatColor.RESET + " Spawner for" + ChatColor.DARK_PURPLE + " 80 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"vs give "+p.getName()+" blaze 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -80);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                        case 14:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 150) {
                                p.sendMessage("You purchased a " + ChatColor.WHITE + "" + ChatColor.BOLD + "IRON GOLEM" + ChatColor.RESET + " Spawner for" + ChatColor.DARK_PURPLE + " 150 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"vs give "+p.getName()+" IRON_GOLEM 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -150);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                    }
                case TRIPWIRE_HOOK:
                    switch (e.getSlot()) {
                        case 15:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 15) {
                                p.sendMessage("You purchased a " + ChatColor.RED + "" + ChatColor.BOLD + "RUBY" + ChatColor.RESET + " Key for" + ChatColor.DARK_PURPLE + " 15 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"crate key give "+p.getName()+" ruby 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -15);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                        case 16:
                            if (ShardDataStorageUtil.getShardAmount(p.getUniqueId()) >= 60) {
                                p.sendMessage("You purchased a " + ChatColor.BLUE + "" + ChatColor.BOLD + "SAPPHIRE" + ChatColor.RESET + " Key for" + ChatColor.DARK_PURPLE + " 60 shards");
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"crate key give "+p.getName()+" sapphire 1");
                                try {
                                    ShardDataStorageUtil.updateShardData(p.getUniqueId(), -60);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You do not have enough afk shards for this purchase");
                            }
                            e.setCancelled(true);
                            p.closeInventory();
                            break;
                    }
            }

            e.setCancelled(true);
        }
    }

}
