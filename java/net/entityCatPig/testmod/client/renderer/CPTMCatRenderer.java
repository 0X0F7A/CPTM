package net.entityCatPig.testmod.client.renderer;


import com.google.common.collect.Maps;
import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMCatModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMCatCollarLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class CPTMCatRenderer extends BipedEntityRenderer<CatEntity, CPTMCatModel<CatEntity>> {

    public static final Map<Integer, Identifier> CPTMTEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
        p_213410_0_.put(0, new Identifier(TestMod.MOD_ID,"textures/entity/cat/tabby.png"));
        p_213410_0_.put(1, new Identifier(TestMod.MOD_ID,"textures/entity/cat/black.png"));
        p_213410_0_.put(2, new Identifier(TestMod.MOD_ID,"textures/entity/cat/red.png"));
        p_213410_0_.put(3, new Identifier(TestMod.MOD_ID,"textures/entity/cat/siamese.png"));
        p_213410_0_.put(4, new Identifier(TestMod.MOD_ID,"textures/entity/cat/british_shorthair.png"));
        p_213410_0_.put(5, new Identifier(TestMod.MOD_ID,"textures/entity/cat/calico.png"));
        p_213410_0_.put(6, new Identifier(TestMod.MOD_ID,"textures/entity/cat/persian.png"));
        p_213410_0_.put(7, new Identifier(TestMod.MOD_ID,"textures/entity/cat/ragdoll.png"));
        p_213410_0_.put(8, new Identifier(TestMod.MOD_ID,"textures/entity/cat/white.png"));
        p_213410_0_.put(9, new Identifier(TestMod.MOD_ID,"textures/entity/cat/jellie.png"));
        p_213410_0_.put(10, new Identifier(TestMod.MOD_ID,"textures/entity/cat/all_black.png"));
    });

    public Identifier getIdentifier(CatEntity catEntityInstance) {
        return new Identifier(TestMod.MOD_ID,catEntityInstance.getTexture().getPath());
        //return CPTMTEXTURE_BY_TYPE.getOrDefault(catEntityInstance.getVariant(), CPTMTEXTURE_BY_TYPE.get(0));
    }
    public CPTMCatRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMCatModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_CAT_LAYER)), 0.2F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_CAT_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_CAT_LAYER_OA))));
        this.addFeature(new CPTMCatCollarLayer(this,p_i46143_1_));
    }

    public Identifier getTexture(CatEntity p_110775_1_) {
        return getIdentifier(p_110775_1_);
    }

    protected void scale(CatEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        p_225620_2_.scale(0.4F, 0.4F, 0.4F);
    }
}
