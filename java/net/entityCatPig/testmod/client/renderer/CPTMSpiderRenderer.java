package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMSpiderModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;




public class CPTMSpiderRenderer<T extends SpiderEntity> extends BipedEntityRenderer<T, CPTMSpiderModel<T>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmspider.png");

    public CPTMSpiderRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMSpiderModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_SPIDER_LAYER)), 1.0F);
    }

    protected float getLyingAngle(T p_77037_1_) {
        return 180.0F;
    }

    public Identifier getTexture(SpiderEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
