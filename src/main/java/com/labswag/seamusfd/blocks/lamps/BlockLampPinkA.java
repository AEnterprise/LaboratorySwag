package com.labswag.seamusfd.blocks.lamps;

import com.labswag.seamusfd.ModLabSwag;
import com.labswag.seamusfd.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by SeamusFD on 6/14/14.
 * All rights belong to me!!
 */
public class BlockLampPinkA extends Block {
    public BlockLampPinkA() {
        super(Material.iron);
        this.blockHardness = 10f;
        this.setCreativeTab(ModLabSwag.labSwagTabBlocks);
        this.setBlockName("lampPinkA");
        this.setLightLevel(1f);
        this.setBlockTextureName(ModInfo.MODID + "lampPink.png");
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
