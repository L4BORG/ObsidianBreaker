package com.creeperevents.oggehej.obsidianbreaker.nms;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockBreakAnimation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

public class v1_8_R3 implements NMS {
	@Override
	public void sendCrackEffect(Location location, int damage) {
		int x = location.getBlockX(), y = location.getBlockY(), z = location.getBlockZ();
		int dimension = ((CraftWorld) location.getWorld()).getHandle().dimension;
		PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(location.hashCode(), new BlockPosition(x, y, z), damage);
		((CraftServer) Bukkit.getServer()).getHandle().sendPacketNearby(x, y, z, 30, dimension, packet);
	}
}
