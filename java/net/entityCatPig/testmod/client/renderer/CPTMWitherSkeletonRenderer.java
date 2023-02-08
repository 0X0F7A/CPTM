package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMWitherSkeletonModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.util.Identifier;




public class CPTMWitherSkeletonRenderer extends BipedEntityRenderer<WitherSkeletonEntity, CPTMWitherSkeletonModel<WitherSkeletonEntity>> {
    private static final Identifier WITHER_SKELETON_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwitherskeleton.png");

    public CPTMWitherSkeletonRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMWitherSkeletonModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITHER_SKELETON_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITHER_SKELETON_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITHER_SKELETON_LAYER_OA))));
    }

    public Identifier getTexture(WitherSkeletonEntity p_110775_1_) {
        return WITHER_SKELETON_LOCATION;
    }

}