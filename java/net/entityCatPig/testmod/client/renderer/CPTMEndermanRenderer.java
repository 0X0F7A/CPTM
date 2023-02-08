package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMEndermanModel;
import net.entityCatPig.testmod.client.renderer.layers.CPTMHeldBlockLayer;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.Random;


public class CPTMEndermanRenderer extends BipedEntityRenderer<EndermanEntity, CPTMEndermanModel<EndermanEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmenderman.png");
    protected final Random newRandom = new Random();

    public CPTMEndermanRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMEndermanModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMAN_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMAN_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ENDERMAN_LAYER_OA))));
        this.addFeature(new CPTMHeldBlockLayer(this));
    }

    public void render(EndermanEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, VertexConsumerProvider p_225623_5_, int p_225623_6_) {
        BlockState blockstate = p_225623_1_.getCarriedBlock();
        CPTMEndermanModel<EndermanEntity> endermanmodel = this.getModel();
        endermanmodel.carrying = blockstate != null;
        endermanmodel.creepy = p_225623_1_.isAngry();
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    public Vec3d getPositionOffset(EndermanEntity p_225627_1_, float p_225627_2_) {

        if (p_225627_1_.isAngry()) {
            double d0 = 0.02D;
            return new Vec3d(newRandom.nextGaussian() * 0.02D, 0.0D, newRandom.nextGaussian() * 0.02D);
        } else {
            return super.getPositionOffset(p_225627_1_, p_225627_2_);
        }
    }

    public int getBlockLight(EndermanEntity p_225624_1_, BlockPos p_225624_2_) {
        return 15;
    }

    public Identifier getTexture(EndermanEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
