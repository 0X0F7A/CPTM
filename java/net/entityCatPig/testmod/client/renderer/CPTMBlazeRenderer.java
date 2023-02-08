package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMBlazeModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;




public class CPTMBlazeRenderer extends BipedEntityRenderer<BlazeEntity, CPTMBlazeModel<BlazeEntity>> {
    private static final Identifier BLAZE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmblaze.png");

    public CPTMBlazeRenderer(EntityRendererFactory.Context p_i46191_1_) {
        super(p_i46191_1_, new CPTMBlazeModel<>(p_i46191_1_.getPart(ModEntityTypes.MODEL_BLAZE_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BlazeEntity p_110775_1_) {
        return BLAZE_LOCATION;
    }
    
    public int getBlockLight(BlazeEntity p_225624_1_, BlockPos p_225624_2_) {
        return 15;
    }
}