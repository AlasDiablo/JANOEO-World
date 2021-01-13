package fr.alasdiablo.janoeo.worlds.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;

public class JSaplingBlock extends SaplingBlock {
    public JSaplingBlock(Tree treeIn, String registryName) {
        super(treeIn, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT));
        this.setRegistryName(registryName);
    }
}
