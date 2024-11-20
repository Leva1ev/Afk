package LevaLev.afk.Commands;

import LevaLev.afk.Utils.ShardDataStorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class ShardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 2) {
            if (sender instanceof Player p) {
                p.sendMessage("Correct usage: /shard <player> <amount>");
            }
        }

        if (args.length == 2) {
            try{
                UUID uuid = Bukkit.getPlayer(args[0]).getUniqueId();
                int addAmount = Integer.parseInt(args[1]);

                int amount = ShardDataStorageUtil.getShardAmount(uuid);

                amount += addAmount;

                try {
                    ShardDataStorageUtil.updateShardData(uuid, amount);
                    Player t = Bukkit.getPlayer(args[0]);
                    t.sendMessage(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"AFK "+ChatColor.RESET+"You have received"+ChatColor.LIGHT_PURPLE+" 1 shard"+ChatColor.WHITE+" for being AFK");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }catch (NumberFormatException | NullPointerException e){
                sender.sendMessage("Correct usage: /shard <player> <amount>");
            }

        }



        return true;
    }

}
