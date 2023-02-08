package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMZombieVillagerModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMVillagerLevelPendantLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.util.Identifier;




public class CPTMZombieVillagerRenderer extends BipedEntityRenderer<ZombieVillagerEntity, CPTMZombieVillagerModel<ZombieVillagerEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmzombievillager.png");

    public CPTMZombieVillagerRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMZombieVillagerModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_VILLAGER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_VILLAGER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_VILLAGER_LAYER_OA))));
        this.addFeature(new CPTMVillagerLevelPendantLayer<>(this,  "zombievillager"));
    }

    public Identifier getTexture(ZombieVillagerEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
    protected boolean isShaking(ZombieVillagerEntity p_230495_1_) {
        return p_230495_1_.isConverting();
    }
}