package com.scrl0.test;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scrl0.test.blocks.ModdedBlocks;

@Mod(TestMod.MOD_ID)
public class TestMod
{
	/*Должно совпадать с modid в mods.toml*/
	public static final String MOD_ID = "test";
	
    private static final Logger LOGGER = LogManager.getLogger();

    public TestMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    /*Регистрация блоков и предметов, ну и вроде как всего остального*/
    @Mod.EventBusSubscriber(modid=MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	/*Регистрация блоков*/
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> e) {
            LOGGER.info("HELLO from Register Block");
            new ModdedBlocks();
			e.getRegistry().register(ModdedBlocks.moddedStone);
			e.getRegistry().register(ModdedBlocks.moddedStoneBlack);
        }
        /*Регистрация предметов, а также отдельных предмето-блоков(блок поставленный и блок в руке - разные вещи)*/
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
        	Item.Properties properties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
        	
        	LOGGER.info("HELLO from Register Item");
        	e.getRegistry().register(new BlockItem(ModdedBlocks.moddedStone, properties));
        	e.getRegistry().register(new BlockItem(ModdedBlocks.moddedStoneBlack, properties));
        }
    }
}
