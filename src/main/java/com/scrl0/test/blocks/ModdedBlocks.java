package com.scrl0.test.blocks;

import com.scrl0.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;


/*Класс с блоками из мода, сделан для того, чтобы логически разделить вещи из мода и не нагромождать всё в одном файле */
public class ModdedBlocks {
	/* Внутренний класс-чертёж по которому в дальнейшем будем создавать блоки
	 * Вообще отдельные классы для блоков делают, если у них есть какие-то свои необычные свойства
	 * Ну а также делают один шаблон, чтоб было проще потом блоки регистрировать, ведь через ванильные методы там нагромаждение*/
	private static class ModdedBlock extends Block {
		ModdedBlock(String registerName, int harvestLevel, float hardness, float resistance) {
		super(Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(harvestLevel)
				.hardnessAndResistance(hardness, resistance));
		setRegistryName(registerName);
		
		}
	}
	/*ObjectHolder выделет место в памяти при загрузке майна для вещи(если я правильно понял)
	 * А ниже регистрация блока*/
	//1
	@ObjectHolder(TestMod.MOD_ID + ":modded_stone")
	public static Block moddedStone = new ModdedBlock("modded_stone", 1, 2, 5);
	//2
	@ObjectHolder(TestMod.MOD_ID + ":modded_stone_black")
	public static Block moddedStoneBlack = new ModdedBlock("modded_stone_black", 1, 2, 5);

	
	
}
