package com.labswag.seamusfd.blocks.lamps;

import com.labswag.seamusfd.ModLabSwag;
import com.labswag.seamusfd.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by SeamusFD on 6/11/14.
 * All rights belong to me!!
 */
public class BlockLampWhiteA extends Block {
    public BlockLampWhiteA() {
        super(Material.iron);
        this.blockHardness = 10f;
        this.setCreativeTab(ModLabSwag.labSwagTabBlocks);
        this.setBlockName("lampWhiteA");
        this.setLightLevel(1f);
        this.setBlockTextureName(ModInfo.MODID + "lampWhiteA.png");
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
