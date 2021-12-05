package me.icedchai.icedchaiskeletons.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class OptionsHolder
{
    public static class Common
    {
        private static final int defaultSkeletonWeight = 70;
        private static final int defaultStrayWeight = 20;

        public final ForgeConfigSpec.ConfigValue<Integer> skeletonWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> strayWeight;

        private static final int defaultSkeletonMin = 4;
        private static final int defaultSkeletonMax = 4;
        private static final int defaultStrayMax = 4;
        private static final int defaultStrayMin = 4;

        public final ForgeConfigSpec.ConfigValue<Integer> skeletonMin;
        public final ForgeConfigSpec.ConfigValue<Integer> skeletonMax;
        public final ForgeConfigSpec.ConfigValue<Integer> strayMax;
        public final ForgeConfigSpec.ConfigValue<Integer> strayMin;


        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("icedchai's Skeleton Weights");
            this.skeletonWeight = builder.comment("The likelihood that a group of Skeleton Knights will spawn. Default: "+defaultSkeletonWeight)
                    .worldRestart()
                    .define("skeleton-knight-spawn-weight", defaultSkeletonWeight);
            this.strayWeight = builder.comment("The likelihood that a group of Stray Knights will spawn.  Default: "+defaultStrayWeight)
                    .define("stray-spawn-weight", defaultStrayWeight);
            builder.pop();

            
            builder.push("icedchai's Skeleton Groups");
            this.skeletonMin =  builder.comment("The minimum amount of Skeleton Knights that may spawn in any given group. Default: "+defaultSkeletonMin)
                    .worldRestart()
                    .define("skeleton-knight-group-min", defaultSkeletonMin);
            this.skeletonMax =  builder.comment("The maximum amount of Skeleton Knights that may spawn in any given group. Default: "+defaultSkeletonMax)
                    .worldRestart()
                    .define("skeleton-knight-group-max", defaultSkeletonMax);


            this.strayMin =  builder.comment("The minimum amount of Stray Knights that may spawn in any given group. Default: "+defaultStrayMin)
                    .worldRestart()
                    .define("stray-knight-group-min", defaultStrayMin);
            this.strayMax =  builder.comment("The maximum amount of Stray Knights that may spawn in any given group. Default: "+ defaultStrayMax)
                    .worldRestart()
                    .define("stray-knight-group-max", defaultStrayMax);

            builder.pop();

        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static //constructor
    {
        Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();
    }
}