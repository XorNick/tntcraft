package net.xornick.tntcrafter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class TNTCrafter extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (command.getName().equalsIgnoreCase("tnt")) {
            Player player = (Player) sender;
            if (!player.hasPermission("tntcrafter.use")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
                return true;
            }
            Inventory inventory = player.getInventory();
            ItemStack sulphur = new ItemStack(Material.SULPHUR);
            ItemStack tnt = new ItemStack(Material.TNT);

            if (inventory.containsAtLeast(sulphur, 4)) {
                inventory.removeItem(sulphur);
                inventory.addItem(new ItemStack(tnt));
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You do not have enough ingredients for this item!");
            }
        }
        return false;
    }
}
