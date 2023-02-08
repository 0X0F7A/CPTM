package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMPiglinBruteModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.util.Identifier;

public class CPTMPiglinBruteRenderer extends BipedEntityRenderer<PiglinBruteEntity, CPTMPiglinBruteModel<PiglinBruteEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmpiglinbrute.png");

    public CPTMPiglinBruteRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMPiglinBruteModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_BRUTE_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_BRUTE_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_PIGLIN_BRUTE_LAYER_OA))));
    }

    public Identifier getTexture(PiglinBruteEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected boolean isShaking(PiglinBruteEntity p_230495_1_) {
        return p_230495_1_.shouldZombify();
    }
}