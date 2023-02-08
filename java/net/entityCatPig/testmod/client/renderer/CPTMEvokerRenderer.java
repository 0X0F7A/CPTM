package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMEvokerModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.util.Identifier;


public class CPTMEvokerRenderer extends BipedEntityRenderer<EvokerEntity, CPTMEvokerModel<EvokerEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmevoker.png");

    public CPTMEvokerRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMEvokerModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_EVOKER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_EVOKER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_EVOKER_LAYER_OA))));
    }

    public Identifier getTexture(EvokerEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}