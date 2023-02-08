package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMEndermiteModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.util.Identifier;




public class CPTMEndermiteRenderer extends BipedEntityRenderer<EndermiteEntity, CPTMEndermiteModel<EndermiteEntity>> {
    private static final Identifier ENDERMITE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmendermite.png");

    public CPTMEndermiteRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMEndermiteModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMITE_LAYER)), 0.2F);
        //this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMITE_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMITE_LAYER_OA))));
    }

    protected float getLyingAngle(EndermiteEntity p_77037_1_) {
        return 180.0F;
    }

    public Identifier getTexture(EndermiteEntity p_110775_1_) {
        return ENDERMITE_LOCATION;
    }
}
