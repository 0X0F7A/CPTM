package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMWanderingTraderModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.util.Identifier;




public class CPTMWanderingTraderRenderer extends BipedEntityRenderer<WanderingTraderEntity, CPTMWanderingTraderModel<WanderingTraderEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwanderingtrader.png");

    public CPTMWanderingTraderRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMWanderingTraderModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_WANDERING_TRADER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WANDERING_TRADER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WANDERING_TRADER_LAYER_OA))));
    }

    public Identifier getTexture(WanderingTraderEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
