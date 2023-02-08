package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMVexModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;




public class CPTMVexRenderer extends BipedEntityRenderer<VexEntity, CPTMVexModel<VexEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmvex.png");

    public CPTMVexRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMVexModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_VEX_LAYER)), 0.2F);
    }

    public Identifier getTexture(VexEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected void scale(VexEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        p_225620_2_.scale(0.4F, 0.4F, 0.4F);
    }
    protected int getBlockLight(VexEntity p_225624_1_, BlockPos p_225624_2_) {
        return 15;
    }
}
