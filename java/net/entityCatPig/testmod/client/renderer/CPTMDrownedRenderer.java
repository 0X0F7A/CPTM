package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMDrownedModel;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

import static net.entityCatPig.testmod.init.ModEntityTypes.*;

public class CPTMDrownedRenderer extends BipedEntityRenderer<DrownedEntity, CPTMDrownedModel<DrownedEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmdrowned.png");

    public CPTMDrownedRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMDrownedModel<>(p_i46143_1_.getPart(MODEL_DROWNED_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(MODEL_DROWNED_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(MODEL_DROWNED_LAYER_OA))));
    }

    public Identifier getTexture(DrownedEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected void setupTransforms(DrownedEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupTransforms(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
        float f = p_225621_1_.getLeaningPitch(p_225621_5_);
        if (f > 0.0F) {
            p_225621_2_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(MathHelper.lerp(f, p_225621_1_.getPitch(), -10.0F - p_225621_1_.getPitch())));
        }

    }

    protected boolean isShaking(DrownedEntity p_230495_1_) {
        return p_230495_1_.isConvertingInWater();
    }
}