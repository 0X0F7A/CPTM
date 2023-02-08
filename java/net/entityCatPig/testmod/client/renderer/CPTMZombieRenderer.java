package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMZombieModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;




public class CPTMZombieRenderer extends BipedEntityRenderer<ZombieEntity, CPTMZombieModel<ZombieEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmzombie.png");

    public CPTMZombieRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMZombieModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIE_LAYER_OA))));
    }

    public Identifier getTexture(ZombieEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected boolean isShaking(ZombieEntity p_230495_1_) {
        return p_230495_1_.isConvertingInWater();
    }
}