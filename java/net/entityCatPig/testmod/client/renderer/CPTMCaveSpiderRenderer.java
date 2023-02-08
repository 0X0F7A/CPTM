package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMCaveSpiderModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.util.Identifier;




public class CPTMCaveSpiderRenderer<T extends CaveSpiderEntity> extends BipedEntityRenderer<T, CPTMCaveSpiderModel<T>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmcavespider.png");

    public CPTMCaveSpiderRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMCaveSpiderModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_CAVE_SPIDER_LAYER)), 0.5F);
    }

    protected float getLyingAngle(T p_77037_1_) {
        return 180.0F;
    }

    public Identifier getTexture(CaveSpiderEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}