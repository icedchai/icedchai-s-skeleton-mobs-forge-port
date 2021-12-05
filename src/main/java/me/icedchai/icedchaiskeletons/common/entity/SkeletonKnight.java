package me.icedchai.icedchaiskeletons.common.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SkeletonKnight extends Skeleton {
    public SkeletonKnight(EntityType<? extends SkeletonKnight> entityType, Level world) {
        super(entityType, world);
    }


    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));

    }



    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }


    protected SoundEvent getStepSound() { return SoundEvents.SKELETON_STEP;}

    protected void doFreezeConversion() {
        this.convertTo(EntityInit.STKNIGHT.get(), true);
        if (!this.isSilent()) {
            this.level.levelEvent((Player)null, 1048, this.blockPosition(), 0);
        }

    }
    public static AttributeSupplier.Builder createSKnightAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.MAX_HEALTH, 20)
                ;
    }

    protected void dropCustomDeathLoot(DamageSource DamageSource, int LootingMultiplier, boolean DropsAllowed) {
        super.dropCustomDeathLoot(DamageSource, LootingMultiplier, DropsAllowed);
        Entity entity = DamageSource.getEntity();
        if (entity instanceof Creeper) {
            Creeper creeper = (Creeper)entity;
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(Items.SKELETON_SKULL);
            }
        }

    }
}
