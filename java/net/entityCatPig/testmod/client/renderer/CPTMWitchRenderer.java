package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMWitchModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.util.Identifier;




public class CPTMWitchRenderer extends BipedEntityRenderer<WitchEntity, CPTMWitchModel<WitchEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmwitch.png");

    public CPTMWitchRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMWitchModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITCH_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITCH_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_WITCH_LAYER_OA))));
    }

    public Identifier getTexture(WitchEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
