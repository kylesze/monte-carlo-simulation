package com.kylesze.montecarlo;

import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.GeometricDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

import umontreal.ssj.probdist.NegativeBinomialDist;
import umontreal.ssj.randvar.NegativeBinomialGen;
import umontreal.ssj.rng.MRG32k3a;
import umontreal.ssj.rng.RandomStream;

public class discreteRandomVariateGen {

    RandomStream rng = new MRG32k3a();

    public double binomialGen( int nTrial , double probabilityOfSuccess ){ 

        UniformRandomProvider rng1 = RandomSource.XO_RO_SHI_RO_128_PP.create(); //U ~ U(0,1)

            double U = rng1.nextDouble();

        BinomialDistribution binomialDistribution = new BinomialDistribution(nTrial, probabilityOfSuccess); 

            double binomialRandomVariate = binomialDistribution.inverseCumulativeProbability(U);

            return binomialRandomVariate; 

    }


    public double poissonGen( double lambda ){

        UniformRandomProvider rng1 = RandomSource.XO_RO_SHI_RO_128_PP.create();

            double U = rng1.nextDouble();

        PoissonDistribution poissonDistribution = new PoissonDistribution(lambda);

            double poissonRandomVariate = poissonDistribution.inverseCumulativeProbability(U);

            return poissonRandomVariate; 
    }


    public double geometricGen( double probabilityOfSuccess ){

        UniformRandomProvider rng1 = RandomSource.XO_RO_SHI_RO_128_PP.create();

            double U = rng1.nextDouble();

        GeometricDistribution geometricDistribution = new GeometricDistribution(probabilityOfSuccess);

            double geometricRandomVariate = geometricDistribution.inverseCumulativeProbability(U);

            return geometricRandomVariate; 

    }


    public double hypergeometricGen(int totalPopulationSize, int numberOfSuccesses, int numberOfDraws){

        UniformRandomProvider rng1 = RandomSource.XO_RO_SHI_RO_128_PP.create();

            double U = rng1.nextDouble();
       
        HypergeometricDistribution hypergeometricDistribution = new HypergeometricDistribution(totalPopulationSize, numberOfSuccesses, numberOfDraws);

            double hypergeometricRandomVariate =hypergeometricDistribution.inverseCumulativeProbability(U);

            return hypergeometricRandomVariate; 

    }


    public double negativeBinomialGen( double r , double probabilityOfSuccess){

        NegativeBinomialDist negativeBinomialDistribution = new NegativeBinomialDist( r, probabilityOfSuccess );

            NegativeBinomialGen inverseNegativeBinomial = new NegativeBinomialGen( rng , negativeBinomialDistribution);
            
            double negativeBinomialRandomVariate = inverseNegativeBinomial.nextDouble();

            return negativeBinomialRandomVariate; 

    }


}