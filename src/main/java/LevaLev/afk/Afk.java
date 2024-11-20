package LevaLev.afk;

import LevaLev.afk.Commands.AfkShopCommand;
import LevaLev.afk.Commands.ShardCommand;
import LevaLev.afk.Listeners.MenuHandler;
import LevaLev.afk.Listeners.PlayerJoinListener;
import LevaLev.afk.Utils.ShardDataStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;

public final class Afk extends JavaPlugin {

    private static Afk plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        try {
            ShardDataStorageUtil.loadNotes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getCommand("afkshop").setExecutor(new AfkShopCommand(this));
        getCommand("shard").setExecutor(new ShardCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);

    }

    public static Afk getPlugin() {
        return plugin;
    }

    public void openTokenShop(Player player){
        Inventory tokenShop = Bukkit.createInventory(player, 27, ChatColor.BLUE + "" + ChatColor.BOLD + "AFK Shop");

        //Options for menu
        ItemStack zombieSpawner = new ItemStack(Material.SPAWNER);
        ItemMeta zombieSpawnerMeta = zombieSpawner.getItemMeta();
        zombieSpawnerMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "ZOMBIE " + ChatColor.RESET+ "" +ChatColor.WHITE + "Spawner");
        ArrayList<String> zlore = new ArrayList<>();
        zlore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "25 Shards");
        zombieSpawnerMeta.setLore(zlore);
        zombieSpawner.setItemMeta(zombieSpawnerMeta);

        ItemStack skeletonSpawner = new ItemStack(Material.SPAWNER);
        ItemMeta skeletonSpawnerMeta = skeletonSpawner.getItemMeta();
        skeletonSpawnerMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "SKELETON " + ChatColor.RESET+ "" +ChatColor.WHITE + "Spawner");
        ArrayList<String> slore = new ArrayList<>();
        slore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "35 Shards");
        skeletonSpawnerMeta.setLore(slore);
        skeletonSpawner.setItemMeta(skeletonSpawnerMeta);

        ItemStack creeperSpawner = new ItemStack(Material.SPAWNER);
        ItemMeta creeperSpawnerMeta = creeperSpawner.getItemMeta();
        creeperSpawnerMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "CREEPER " + ChatColor.RESET+ "" +ChatColor.WHITE + "Spawner");
        ArrayList<String> clore = new ArrayList<>();
        clore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "50 Shards");
        creeperSpawnerMeta.setLore(clore);
        creeperSpawner.setItemMeta(creeperSpawnerMeta);

        ItemStack blazeSpawner = new ItemStack(Material.SPAWNER);
        ItemMeta blazeSpawnerMeta = blazeSpawner.getItemMeta();
        blazeSpawnerMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLAZE " + ChatColor.RESET+ "" +ChatColor.WHITE + "Spawner");
        ArrayList<String> blore = new ArrayList<>();
        blore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "80 Shards");
        blazeSpawnerMeta.setLore(blore);
        blazeSpawner.setItemMeta(blazeSpawnerMeta);

        ItemStack ironGolemSpawner = new ItemStack(Material.SPAWNER);
        ItemMeta ironGolemSpawnerMeta = ironGolemSpawner.getItemMeta();
        ironGolemSpawnerMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "IRON GOLEM " + ChatColor.RESET+ "" + ChatColor.WHITE + "Spawner");
        ArrayList<String> ilore = new ArrayList<>();
        ilore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "150 Shards");
        ironGolemSpawnerMeta.setLore(ilore);
        ironGolemSpawner.setItemMeta(ironGolemSpawnerMeta);

        ItemStack rubyKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta rubyKeyMeta = rubyKey.getItemMeta();
        rubyKeyMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "RUBY " + ChatColor.RESET+ "" + ChatColor.WHITE + "Key");
        ArrayList<String> rlore = new ArrayList<>();
        rlore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "15 Shards");
        rubyKeyMeta.setLore(rlore);
        rubyKey.setItemMeta(rubyKeyMeta);

        ItemStack sapphireKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta sapphireKeyMeta = sapphireKey.getItemMeta();
        sapphireKeyMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "SAPPHIRE " + ChatColor.RESET+ "" + ChatColor.WHITE + "Key");
        ArrayList<String> splore = new ArrayList<>();
        splore.add(ChatColor.WHITE + "Price: " + ChatColor.DARK_PURPLE + "60 Shards");
        sapphireKeyMeta.setLore(splore);
        sapphireKey.setItemMeta(sapphireKeyMeta);

        //Add everything
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(ChatColor.GRAY+"");
        filler.setItemMeta(fillerMeta);

        for (int i=0;i<10;i++) {
            tokenShop.setItem(i, filler);
        }
        tokenShop.setItem(10, zombieSpawner);
        tokenShop.setItem(11, skeletonSpawner);
        tokenShop.setItem(12, creeperSpawner);
        tokenShop.setItem(13, blazeSpawner);
        tokenShop.setItem(14, ironGolemSpawner);
        tokenShop.setItem(15, rubyKey);
        tokenShop.setItem(16, sapphireKey);
        for (int i=17;i<27;i++) {
            tokenShop.setItem(i, filler);
        }

        player.openInventory(tokenShop);
    }
}
