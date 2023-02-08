package net.entityCatPig.testmod.client.renderer.layers;

import com.google.common.collect.ImmutableMap;
import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMIronGolemModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.Identifier;

import java.util.Map;


public class CPTMIronGolemCracksLayer extends FeatureRenderer<IronGolemEntity, CPTMIronGolemModel<IronGolemEntity>> {
    private static final Map<IronGolemEntity.Crack, Identifier> resourceLocations = ImmutableMap.of(
            IronGolemEntity.Crack.LOW, new Identifier(TestMod.MOD_ID,"textures/entity/cptmirongolem1.png"),
            IronGolemEntity.Crack.MEDIUM, new Identifier(TestMod.MOD_ID,"textures/entity/cptmirongolem2.png"),
            IronGolemEntity.Crack.HIGH, new Identifier(TestMod.MOD_ID,"textures/entity/cptmirongolem3.png"));

    public CPTMIronGolemCracksLayer(FeatureRendererContext<IronGolemEntity, CPTMIronGolemModel<IronGolemEntity>> p_i226040_1_) {
        super(p_i226040_1_);
    }

    public void render(MatrixStack p_225628_1_, VertexConsumerProvider p_225628_2_, int p_225628_3_, IronGolemEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (!p_225628_4_.isInvisible()) {
            IronGolemEntity.Crack irongolementity$cracks = p_225628_4_.getCrack();
            if (irongolementity$cracks != IronGolemEntity.Crack.NONE) {
                Identifier resourcelocation = resourceLocations.get(irongolementity$cracks);
                renderModel(this.getContextModel(), resourcelocation, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
