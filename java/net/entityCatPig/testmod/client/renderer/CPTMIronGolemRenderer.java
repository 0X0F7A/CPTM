package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMIronGolemModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMIronGolemCracksLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;




public class CPTMIronGolemRenderer extends BipedEntityRenderer<IronGolemEntity, CPTMIronGolemModel<IronGolemEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmirongolem.png");

    public CPTMIronGolemRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMIronGolemModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_IRON_GOLEM_LAYER)), 0.5F);
        this.addFeature(new CPTMIronGolemCracksLayer(this));
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_IRON_GOLEM_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_IRON_GOLEM_LAYER_OA))));
    }

    public Identifier getTexture(IronGolemEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected void setupTransforms(IronGolemEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupTransforms(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
        if (!((double)p_225621_1_.limbDistance < 0.01D)) {
            float f = 13.0F;
            float f1 = p_225621_1_.limbAngle - p_225621_1_.limbDistance * (1.0F - p_225621_5_) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            p_225621_2_.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * f2));
        }
    }
}