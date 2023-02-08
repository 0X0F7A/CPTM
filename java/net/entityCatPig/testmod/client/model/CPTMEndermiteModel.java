package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermiteEntity;


public class CPTMEndermiteModel<T extends EndermiteEntity> extends PlayerEntityModel<T> {
    public CPTMEndermiteModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMEndermiteModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_,p_i46303_2_);
        this.child = false;
    }
    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true),64,64);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        if (true) {
            p_225598_1_.push();
            if (true) {
                float f = 1.5F / 2.0F;
                p_225598_1_.scale(f, f, f);
            }

            p_225598_1_.translate(0.0D, (double)(16.0F / 16.0F), (double)(0.0F / 16.0F));
            this.getHeadParts().forEach((p_228230_8_) -> {
                p_228230_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            p_225598_1_.pop();
            p_225598_1_.push();
            float f1 = 1.0F / 2.0F;
            p_225598_1_.scale(f1, f1, f1);
            p_225598_1_.translate(0.0D, (double)(24.0F / 16.0F), 0.0D);
            this.getBodyParts().forEach((p_228229_8_) -> {
                p_228229_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            p_225598_1_.pop();
        } else {
            this.getHeadParts().forEach((p_228228_8_) -> {
                p_228228_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            this.getBodyParts().forEach((p_228227_8_) -> {
                p_228227_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
        }

    }

    protected Iterable<ModelPart> getBodyParts() {
        return super.getBodyParts();
    }
    protected Iterable<ModelPart> getHeadParts() {
        return Iterables.concat(super.getHeadParts(), ImmutableList.of(this.hat));
    }
}
