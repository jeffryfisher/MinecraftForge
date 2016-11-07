/*
 * Minecraft Forge
 * Copyright (c) 2016.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.event;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * 
 * AnvilUpdateEvent is fired when a player places items in both the left and right slots of a anvil.
 * If the event is canceled, vanilla behavior will not run, and the output will be set to null.
 * If the event is not canceled, but the output is not null, it will set the output and not run vanilla behavior.
 * if the output is null, and the event is not canceled, vanilla behavior will execute.
 */
@Cancelable
public class AnvilUpdateEvent extends Event
{
    private final ItemStack left;      // The left side of the input
    private final ItemStack right;     // The right side of the input
    private final String name;         // The name to set the item, if the user specified one.
    private final EntityPlayer player; // The player who is updating the anvil.
    private ItemStack output;          // Set this to set the output stack
    private int cost;                  // The base cost, set this to change it if output != null
    private int materialCost; // Number of items from the right slot to be consumed by repair. Leave as 0 to consume the entire stack.

    public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, int cost, EntityPlayer player)
    {
        this.left = left;
        this.right = right;
        this.name = name;
        this.setCost(cost);
        this.player = player;
        this.setMaterialCost(0);
    }

    /**
     * Callers may update their code to acquire and pass the anvil-changing player to the other constructor
     */
    @Deprecated
    public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, int cost)
    {
        this (left, right, name, cost, null);
    }

    public ItemStack getLeft() { return left; }
    public ItemStack getRight() { return right; }
    public String getName() { return name; }
    public EntityPlayer getPlayer() { return player; }
    public ItemStack getOutput() { return output; }
    public void setOutput(ItemStack output) { this.output = output; }
    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }
    public int getMaterialCost() { return materialCost; }
    public void setMaterialCost(int materialCost) { this.materialCost = materialCost; }
}
