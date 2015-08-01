package com.aleksey.merchants.Core;

import net.minecraft.block.Block;

import com.aleksey.merchants.Blocks.Devices.BlockCustomAnvilDie;
import com.aleksey.merchants.Blocks.Devices.BlockCustomAnvilDie2;
import com.aleksey.merchants.Blocks.Devices.BlockStall;
import com.aleksey.merchants.Blocks.Devices.BlockStorageRack;
import com.aleksey.merchants.Blocks.Devices.BlockWarehouse;
import com.aleksey.merchants.ItemBlocks.ItemStall;
import com.aleksey.merchants.ItemBlocks.ItemStorageRack;
import com.aleksey.merchants.ItemBlocks.ItemStorageRack2;
import com.aleksey.merchants.ItemBlocks.ItemWarehouse;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList
{
    public static int StallRenderId;
    public static int WarehouseRenderId;
    public static int AnvilDieRenderId;
    public static int StorageRackRenderId;
    
    public static Block Stall;
    public static Block Warehouse;
    public static Block StorageRack;
    public static Block StorageRack2;
    public static Block[] AnvilDies;
    
    public static void registerBlocks()
    {
        GameRegistry.registerBlock(Stall, ItemStall.class, Stall.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(Warehouse, ItemWarehouse.class, Warehouse.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(StorageRack, ItemStorageRack.class, StorageRack.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(StorageRack2, ItemStorageRack2.class, StorageRack2.getUnlocalizedName().substring(5));
        
        for(int i = 0; i < AnvilDies.length; i++)
            GameRegistry.registerBlock(AnvilDies[i], AnvilDies[i].getUnlocalizedName().substring(5));
    }
    
    public static void loadBlocks()
    {
        Stall = new BlockStall().setBlockName("Stall").setHardness(2);
        Warehouse = new BlockWarehouse().setBlockName("Warehouse").setHardness(2);
        StorageRack = new BlockStorageRack(0).setBlockName("StorageRack").setHardness(2);
        StorageRack2 = new BlockStorageRack(16).setBlockName("StorageRack2").setHardness(2);
        
        AnvilDies = new Block[Constants.Dies.length * 2];
        
        int index = 0;
        
        for(int i = 0; i < Constants.Dies.length; i++)
        {
            DieInfo info = Constants.Dies[i];
            String name = "AnvilDie." + info.DieName;
            
            AnvilDies[index++] = new BlockCustomAnvilDie(info).setBlockName(name);
            AnvilDies[index++] = new BlockCustomAnvilDie2(info).setBlockName(name + "2");
        }
    }
}
