package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMZombiefiedPiglinModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.util.Identifier;

public class CPTMZombiefiedPiglinRenderer extends BipedEntityRenderer<ZombifiedPiglinEntity, CPTMZombiefiedPiglinModel<ZombifiedPiglinEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmzombiefiedpiglin.png");

    public CPTMZombiefiedPiglinRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMZombiefiedPiglinModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIFIED_PIGLIN_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIFIED_PIGLIN_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ZOMBIFIED_PIGLIN_LAYER_OA))));
    }

    public Identifier getTexture(ZombifiedPiglinEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected boolean isShaking(MobEntity p_230495_1_) {
        return p_230495_1_ instanceof AbstractPiglinEntity && ((AbstractPiglinEntity)p_230495_1_).shouldZombify();
    }
}
