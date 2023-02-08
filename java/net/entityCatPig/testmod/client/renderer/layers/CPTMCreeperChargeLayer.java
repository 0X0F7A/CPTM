package net.entityCatPig.testmod.client.renderer.layers;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMCreeperModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.EnergySwirlOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;




public class CPTMCreeperChargeLayer extends EnergySwirlOverlayFeatureRenderer<CreeperEntity, CPTMCreeperModel<CreeperEntity>> {
    private static final Identifier POWER_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmcreeperarmor.png");
    private final CPTMCreeperModel<CreeperEntity> model;
    public CPTMCreeperChargeLayer(FeatureRendererContext<CreeperEntity, CPTMCreeperModel<CreeperEntity>> p_i50947_1_, EntityRendererFactory.Context context) {
        super(p_i50947_1_);
        this.model = new CPTMCreeperModel<>(context.getPart(ModEntityTypes.MODEL_CREEPER_LAYER_ARMOR));
    }

    protected float getEnergySwirlX(float p_225634_1_) {
        return p_225634_1_ * 0.01F;
    }

    protected Identifier getEnergySwirlTexture() {
        return POWER_LOCATION;
    }

    protected EntityModel<CreeperEntity> getEnergySwirlModel() {
        return this.model;
    }
}
