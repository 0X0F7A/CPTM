package net.entityCatPig.testmod.client.renderer.layers;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMCatModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.Identifier;




public class CPTMCatCollarLayer extends FeatureRenderer<CatEntity, CPTMCatModel<CatEntity>> {
    private static final Identifier CAT_COLLAR_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cat/cat_collar.png");
    private EntityRendererFactory.Context catContext;

    public CPTMCatCollarLayer(FeatureRendererContext<CatEntity, CPTMCatModel<CatEntity>> p_i50948_1_, EntityRendererFactory.Context context) {
        super(p_i50948_1_);
        this.catContext = context;
    }

    public void render(MatrixStack p_225628_1_, VertexConsumerProvider p_225628_2_, int p_225628_3_, CatEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (p_225628_4_.isTamed()) {
            float[] afloat = p_225628_4_.getCollarColor().getColorComponents();
            render(this.getContextModel(), new CPTMCatModel<>(catContext.getPart(ModEntityTypes.MODEL_CAT_LAYER_COLLAR)), CAT_COLLAR_LOCATION, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, afloat[0], afloat[1], afloat[2]);
        }
    }
}
