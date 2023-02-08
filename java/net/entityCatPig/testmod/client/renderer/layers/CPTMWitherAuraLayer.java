package net.entityCatPig.testmod.client.renderer.layers;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMWitherModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;




public class CPTMWitherAuraLayer extends EnergySwirlOverlayFeatureRenderer<WitherEntity, CPTMWitherModel<WitherEntity>> {
    private static final Identifier WITHER_ARMOR_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwitherarmor.png");
    private final CPTMWitherModel<WitherEntity> model;

    public CPTMWitherAuraLayer(FeatureRendererContext<WitherEntity, CPTMWitherModel<WitherEntity>> p_i50915_1_, EntityRendererFactory.Context context) {
        super(p_i50915_1_);
        this.model = new CPTMWitherModel<>(context.getPart(ModEntityTypes.MODEL_WITHER_LAYER_ARMOR));
    }

    protected float getEnergySwirlX(float p_225634_1_) {
        return MathHelper.cos(p_225634_1_ * 0.02F) * 3.0F;
    }

    protected Identifier getEnergySwirlTexture() {
        return WITHER_ARMOR_LOCATION;
    }

    protected EntityModel<WitherEntity> getEnergySwirlModel() {
        return this.model;
    }
}
