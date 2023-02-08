package net.entityCatPig.testmod.client.renderer;


import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMElderGuardianModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;




public class CPTMElderGuardianRenderer extends BipedEntityRenderer<ElderGuardianEntity, CPTMElderGuardianModel<ElderGuardianEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmelderguardian.png");
    private static final Identifier GUARDIAN_BEAM_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/guardian_beam.png");
    private static final RenderLayer BEAM_RENDER_TYPE = RenderLayer.getEntityCutoutNoCull(GUARDIAN_BEAM_LOCATION);

    public CPTMElderGuardianRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMElderGuardianModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ELDER_GUARDIAN_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ELDER_GUARDIAN_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ELDER_GUARDIAN_LAYER_OA))));
    }

    public boolean shouldRender(ElderGuardianEntity p_225626_1_, Frustum p_225626_2_, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
        if (super.shouldRender(p_225626_1_, p_225626_2_, p_225626_3_, p_225626_5_, p_225626_7_)) {
            return true;
        } else {
            if (p_225626_1_.hasBeamTarget()) {
                LivingEntity livingentity = p_225626_1_.getBeamTarget();
                if (livingentity != null) {
                    Vec3d vector3d = this.fromLerpedPosition(livingentity, (double)livingentity.getHeight() * 0.5D, 1.0F);
                    Vec3d vector3d1 = this.fromLerpedPosition(p_225626_1_, (double)p_225626_1_.getStandingEyeHeight(), 1.0F);
                    return p_225626_2_.isVisible(new Box(vector3d1.x, vector3d1.y, vector3d1.z, vector3d.x, vector3d.y, vector3d.z));
                }
            }

            return false;
        }
    }

    private Vec3d fromLerpedPosition(LivingEntity p_177110_1_, double p_177110_2_, float p_177110_4_) {
        double d0 = MathHelper.lerp((double)p_177110_4_, p_177110_1_.lastRenderX, p_177110_1_.getX());
        double d1 = MathHelper.lerp((double)p_177110_4_, p_177110_1_.lastRenderY, p_177110_1_.getY()) + p_177110_2_;
        double d2 = MathHelper.lerp((double)p_177110_4_, p_177110_1_.lastRenderZ, p_177110_1_.getZ());
        return new Vec3d(d0, d1, d2);
    }

    public void render(ElderGuardianEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, VertexConsumerProvider p_225623_5_, int p_225623_6_) {
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        LivingEntity livingentity = p_225623_1_.getBeamTarget();
        if (livingentity != null) {
            float f = p_225623_1_.getBeamProgress(p_225623_3_);
            float f1 = (float)p_225623_1_.world.getTime() + p_225623_3_;
            float f2 = f1 * 0.5F % 1.0F;
            float f3 = p_225623_1_.getStandingEyeHeight();
            p_225623_4_.push();
            p_225623_4_.translate(0.0D, (double)f3, 0.0D);
            Vec3d vector3d = this.fromLerpedPosition(livingentity, (double)livingentity.getHeight() * 0.5D, p_225623_3_);
            Vec3d vector3d1 = this.fromLerpedPosition(p_225623_1_, (double)f3, p_225623_3_);
            Vec3d vector3d2 = vector3d.subtract(vector3d1);
            float f4 = (float)(vector3d2.length() + 1.0D);
            vector3d2 = vector3d2.normalize();
            float f5 = (float)Math.acos(vector3d2.y);
            float f6 = (float)Math.atan2(vector3d2.z, vector3d2.x);
            p_225623_4_.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((((float)Math.PI / 2F) - f6) * (180F / (float)Math.PI)));
            p_225623_4_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(f5 * (180F / (float)Math.PI)));
            int i = 1;
            float f7 = f1 * 0.05F * -1.5F;
            float f8 = f * f;
            int j = 64 + (int)(f8 * 191.0F);
            int k = 32 + (int)(f8 * 191.0F);
            int l = 128 - (int)(f8 * 64.0F);
            float f9 = 0.2F;
            float f10 = 0.282F;
            float f11 = MathHelper.cos(f7 + 2.3561945F) * 0.282F;
            float f12 = MathHelper.sin(f7 + 2.3561945F) * 0.282F;
            float f13 = MathHelper.cos(f7 + ((float)Math.PI / 4F)) * 0.282F;
            float f14 = MathHelper.sin(f7 + ((float)Math.PI / 4F)) * 0.282F;
            float f15 = MathHelper.cos(f7 + 3.926991F) * 0.282F;
            float f16 = MathHelper.sin(f7 + 3.926991F) * 0.282F;
            float f17 = MathHelper.cos(f7 + 5.4977875F) * 0.282F;
            float f18 = MathHelper.sin(f7 + 5.4977875F) * 0.282F;
            float f19 = MathHelper.cos(f7 + (float)Math.PI) * 0.2F;
            float f20 = MathHelper.sin(f7 + (float)Math.PI) * 0.2F;
            float f21 = MathHelper.cos(f7 + 0.0F) * 0.2F;
            float f22 = MathHelper.sin(f7 + 0.0F) * 0.2F;
            float f23 = MathHelper.cos(f7 + ((float)Math.PI / 2F)) * 0.2F;
            float f24 = MathHelper.sin(f7 + ((float)Math.PI / 2F)) * 0.2F;
            float f25 = MathHelper.cos(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
            float f26 = MathHelper.sin(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
            float f27 = 0.0F;
            float f28 = 0.4999F;
            float f29 = -1.0F + f2;
            float f30 = f4 * 2.5F + f29;
            VertexConsumer ivertexbuilder = p_225623_5_.getBuffer(BEAM_RENDER_TYPE);
            MatrixStack.Entry matrixstack$entry = p_225623_4_.peek();
            Matrix4f matrix4f = matrixstack$entry.getPositionMatrix();
            Matrix3f matrix3f = matrixstack$entry.getNormalMatrix();
            vertex(ivertexbuilder, matrix4f, matrix3f, f19, f4, f20, j, k, l, 0.4999F, f30);
            vertex(ivertexbuilder, matrix4f, matrix3f, f19, 0.0F, f20, j, k, l, 0.4999F, f29);
            vertex(ivertexbuilder, matrix4f, matrix3f, f21, 0.0F, f22, j, k, l, 0.0F, f29);
            vertex(ivertexbuilder, matrix4f, matrix3f, f21, f4, f22, j, k, l, 0.0F, f30);
            vertex(ivertexbuilder, matrix4f, matrix3f, f23, f4, f24, j, k, l, 0.4999F, f30);
            vertex(ivertexbuilder, matrix4f, matrix3f, f23, 0.0F, f24, j, k, l, 0.4999F, f29);
            vertex(ivertexbuilder, matrix4f, matrix3f, f25, 0.0F, f26, j, k, l, 0.0F, f29);
            vertex(ivertexbuilder, matrix4f, matrix3f, f25, f4, f26, j, k, l, 0.0F, f30);
            float f31 = 0.0F;
            if (p_225623_1_.age % 2 == 0) {
                f31 = 0.5F;
            }

            vertex(ivertexbuilder, matrix4f, matrix3f, f11, f4, f12, j, k, l, 0.5F, f31 + 0.5F);
            vertex(ivertexbuilder, matrix4f, matrix3f, f13, f4, f14, j, k, l, 1.0F, f31 + 0.5F);
            vertex(ivertexbuilder, matrix4f, matrix3f, f17, f4, f18, j, k, l, 1.0F, f31);
            vertex(ivertexbuilder, matrix4f, matrix3f, f15, f4, f16, j, k, l, 0.5F, f31);
            p_225623_4_.pop();
        }

    }

    private static void vertex(VertexConsumer p_229108_0_, Matrix4f p_229108_1_, Matrix3f p_229108_2_, float p_229108_3_, float p_229108_4_, float p_229108_5_, int p_229108_6_, int p_229108_7_, int p_229108_8_, float p_229108_9_, float p_229108_10_) {
        p_229108_0_.vertex(p_229108_1_, p_229108_3_, p_229108_4_, p_229108_5_).color(p_229108_6_, p_229108_7_, p_229108_8_, 255).texture(p_229108_9_, p_229108_10_).overlay(OverlayTexture.DEFAULT_UV).light(15728880).normal(p_229108_2_, 0.0F, 1.0F, 0.0F).next();
    }

    protected void setupTransforms(ElderGuardianEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        float f = this.model.NSwimAmount;
        if (f > 0.0F) {
            super.setupTransforms(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
            float f3 = p_225621_1_.isTouchingWater() ? -90.0F - p_225621_1_.getPitch() : -90.0F;
            float f4 = MathHelper.lerp(f, 0.0F, f3);
            p_225621_2_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(f4));
            if (p_225621_1_.isInSwimmingPose()) {
                p_225621_2_.translate(0.0D, -1.0D, (double)0.3F);
            }
        } else {
            super.setupTransforms(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
        }

    }

    public Identifier getTexture(ElderGuardianEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}
