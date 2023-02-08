package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMStrayModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.StrayEntity;
import net.minecraft.util.Identifier;




public class CPTMStrayRenderer extends BipedEntityRenderer<StrayEntity, CPTMStrayModel<StrayEntity>> {
    private static final Identifier SKELETON_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmstray.png");

    public CPTMStrayRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMStrayModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_STRAY_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_STRAY_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_STRAY_LAYER_OA))));
    }

    public Identifier getTexture(StrayEntity p_110775_1_) {
        return SKELETON_LOCATION;
    }
}
