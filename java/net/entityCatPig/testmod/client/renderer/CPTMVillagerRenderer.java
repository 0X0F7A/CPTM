package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMVillagerModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMVillagerLevelPendantLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;




public class CPTMVillagerRenderer extends BipedEntityRenderer<VillagerEntity, CPTMVillagerModel<VillagerEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmvillager.png");

    public CPTMVillagerRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMVillagerModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_VILLAGER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_VILLAGER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_VILLAGER_LAYER_OA))));
        this.addFeature(new CPTMVillagerLevelPendantLayer<>(this,  "villager"));
    }

    public Identifier getTexture(VillagerEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

}
