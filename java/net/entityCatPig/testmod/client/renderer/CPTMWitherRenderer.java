package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMWitherModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMWitherAuraLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;




public class CPTMWitherRenderer extends BipedEntityRenderer<WitherEntity, CPTMWitherModel<WitherEntity>> {

    private static final Identifier WITHER_INVULNERABLE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwithervulnerable.png");
    private static final Identifier WITHER_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwither.png");


    public CPTMWitherRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMWitherModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITHER_LAYER)), 0.6F);
        this.addFeature(new CPTMWitherAuraLayer(this, p_i46143_1_));
    }

    public int getBlockLight(WitherEntity p_225624_1_, BlockPos p_225624_2_) {
        return 15;
    }

    public Identifier getTexture(WitherEntity p_110775_1_) {
        int i = p_110775_1_.getInvulnerableTimer();
        return i > 0 && (i > 80 || i / 5 % 2 != 1) ? WITHER_INVULNERABLE_LOCATION : WITHER_LOCATION;
    }

}
