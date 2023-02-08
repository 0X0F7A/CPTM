package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMPiglinModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.util.Identifier;

public class CPTMPiglinRenderer extends BipedEntityRenderer<PiglinEntity, CPTMPiglinModel<PiglinEntity>> {

    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmpiglin.png");

    public CPTMPiglinRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMPiglinModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_LAYER_OA))));
    }

    public Identifier getTexture(PiglinEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected boolean isShaking(PiglinEntity p_230495_1_) {
        return p_230495_1_.shouldZombify();
    }
}
