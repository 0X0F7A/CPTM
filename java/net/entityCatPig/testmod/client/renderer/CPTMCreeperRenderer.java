package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMCreeperModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMCreeperChargeLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Random;


public class CPTMCreeperRenderer extends BipedEntityRenderer<CreeperEntity, CPTMCreeperModel<CreeperEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmcreeper.png");
    protected final Random newRandom = new Random();

    public CPTMCreeperRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMCreeperModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_CREEPER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_CREEPER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_CREEPER_LAYER_OA))));
        this.addFeature(new CPTMCreeperChargeLayer(this,p_i46143_1_));
    }

    protected void scale(CreeperEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        float f = p_225620_1_.getClientFuseTime(p_225620_3_);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        p_225620_2_.scale(f2, f3, f2);
    }

    protected float getAnimationCounter(CreeperEntity p_225625_1_, float p_225625_2_) {
        float f = p_225625_1_.getClientFuseTime(p_225625_2_);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }

    public Identifier getTexture(CreeperEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}