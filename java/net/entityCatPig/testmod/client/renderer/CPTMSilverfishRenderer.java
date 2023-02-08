package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMSilverfishModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.util.Identifier;




public class CPTMSilverfishRenderer extends BipedEntityRenderer<SilverfishEntity, CPTMSilverfishModel<SilverfishEntity>> {
    private static final Identifier ENDERMITE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmsilverfish.png");

    public CPTMSilverfishRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMSilverfishModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_SILVERFISH_LAYER)), 0.2F);
        //this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SILVERFISH_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SILVERFISH_LAYER_OA))));
    }

    protected float getLyingAngle(SilverfishEntity p_77037_1_) {
        return 180.0F;
    }

    public Identifier getTexture(SilverfishEntity p_110775_1_) {
        return ENDERMITE_LOCATION;
    }
}