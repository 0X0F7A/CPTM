package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMSnowGolemModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMSnowGolemHeldLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.Identifier;




public class CPTMSnowGolemRenderer extends BipedEntityRenderer<SnowGolemEntity, CPTMSnowGolemModel<SnowGolemEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmsnowgolem.png");

    public CPTMSnowGolemRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMSnowGolemModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_SNOW_GOLEM_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SNOW_GOLEM_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SNOW_GOLEM_LAYER_OA))));
        this.addFeature(new CPTMSnowGolemHeldLayer(this,p_i46143_1_.getItemRenderer()));
    }

    public Identifier getTexture(SnowGolemEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
