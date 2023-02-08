package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;


public class CPTMBlazeModel<T extends MobEntity> extends CPTMFlyingPlayerModel<T> {

    private final ModelPart[] upperBodyParts;

    public CPTMBlazeModel(ModelPart mdp) {
        super(mdp, true);
        this.upperBodyParts = new ModelPart[8];

        for(int i = 0; i < this.upperBodyParts.length; ++i) {
            this.upperBodyParts[i] = mdp.getChild("rods"+i);
        }

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = CPTMFlyingPlayerModel.getModelData(new Dilation(0.0F));
        ModelPartData modelPartData = modelData.getRoot();
        for(int i = 0; i < 8; ++i) {
            modelPartData.addChild("rods"+i,
                    ModelPartBuilder.create().uv(0,78)
                            .cuboid(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F,new Dilation(0.0F)),
                    ModelTransform.pivot(0.0f,10.0f,1.0f));
        }
        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.upperBodyParts[0],this.upperBodyParts[1],
                this.upperBodyParts[2],this.upperBodyParts[3],this.upperBodyParts[4],this.upperBodyParts[5],
                this.upperBodyParts[6],this.upperBodyParts[7]));
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_,p_225597_2_,p_225597_3_,p_225597_4_,p_225597_5_,p_225597_6_);
        float f = p_225597_4_ * (float)Math.PI * -0.1F;

        for(int i = 0; i < 4; ++i) {
            this.upperBodyParts[i].pivotY = -1.0F + MathHelper.cos(((float)(i * 2) + p_225597_4_) * 0.25F);
            this.upperBodyParts[i].pivotX = -1.0F + MathHelper.cos(f) * 12.0F;
            this.upperBodyParts[i].pivotZ = -1.0F + MathHelper.sin(f) * 12.0F;
            ++f;
        }
        for(int i = 4; i < 8; ++i) {
            this.upperBodyParts[i].pivotY = 7.0F + MathHelper.cos(-((float)(i * 2) + p_225597_4_) * 0.3F);
            this.upperBodyParts[i].pivotX = -1.0F + MathHelper.cos(-f) * 10.0F;
            this.upperBodyParts[i].pivotZ = -1.0F + MathHelper.sin(-f) * 10.0F;
            ++f;
        }

    }
}
