package com.kylesze.montecarlo;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class continuousRandomVariateGen {


        public double uniformGen (double lowerBound , double upperBound ){ 

                UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();

                        double U = rng.nextDouble();

                UniformRealDistribution uniformDistribution = new UniformRealDistribution(lowerBound,upperBound);

                double uniformRandomVariate = uniformDistribution.inverseCumulativeProbability(U);

                return uniformRandomVariate;

        }


        public double normalGen ( double mean, double standardDeviation ){

                UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();

                        double U = rng.nextDouble();

                NormalDistribution normalDistribution = new NormalDistribution(mean,standardDeviation);

                double normalRandomVariate = normalDistribution.inverseCumulativeProbability(U);

                return normalRandomVariate;

        }


        public double exponentialGen ( double mean ){

                UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();

                        double U = rng.nextDouble();

                 ExponentialDistribution exponentialDistribution = new ExponentialDistribution(mean);

                double exponentialRandomVariate = exponentialDistribution.inverseCumulativeProbability(U);

                return exponentialRandomVariate;

        }


        public double lognormalGen (double underlyingMeanOfLog, double underlyingSDOfLog ){

                UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create(); 

                        double U = rng.nextDouble();

                LogNormalDistribution lognormalDistribution = new LogNormalDistribution(underlyingMeanOfLog, underlyingSDOfLog); 

                double lognormalRandomVariate = lognormalDistribution.inverseCumulativeProbability(U);

                return lognormalRandomVariate;

        }


        public double gammaGen ( double shape, double scale){

                UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();

                        double U = rng.nextDouble();

                GammaDistribution gammaDistribution = new GammaDistribution(shape, scale);

                double gammaRandomVariate = gammaDistribution.inverseCumulativeProbability(U);

                return gammaRandomVariate;

        }


}
