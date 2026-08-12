package com.kylesze.montecarlo;

public class discreteSampleGenerator { 

    discreteRandomVariateGen discreteGen = new discreteRandomVariateGen();


    public double[] binomialSampleGenerator(int N , int ntrial , double probabilityOfSuccess ){ 
                                                                                                
        double[] binomialSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){ 

            double x = discreteGen.binomialGen(ntrial, probabilityOfSuccess);

                binomialSample[i]=x;

        }

        return binomialSample;

    }


    public double[] bernoulliSampleGenerator(int N, double probabilityOfSuccess ){

        double[] bernoulliSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){

            double x = discreteGen.binomialGen(1,probabilityOfSuccess); 

                bernoulliSample[i]=x;

        }

        return bernoulliSample;

    }


    public double[] poissonSampleGenerator(int N, double lambda){

        double[] poissonSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){

            double x = discreteGen.poissonGen(lambda); 

                poissonSample[i]=x;

        }

        return poissonSample;

    }


    public double[] geometricSampleGenerator(int N, double probabilityOfSuccess){

        double[] geometricSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){

            double x = discreteGen.geometricGen(probabilityOfSuccess); 

                geometricSample[i]=x+1;
                
        }

        return geometricSample;

    }


    public double[] hypergeometricSampleGenerator( int N , int totalPopulationSize, int numberOfSuccesses , int numberOfDraws){ 

        double[] hypergeometricSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){

            double x = discreteGen.hypergeometricGen(totalPopulationSize, numberOfSuccesses, numberOfDraws); 

                hypergeometricSample[i]=x;

        }

        return hypergeometricSample;

    }


    public double[] negativeBinomialSampleGenerator (int N, double r, double probabilityOfSuccess ){

        double[] negativeBinomialSample= new double[N];

        for( int i = 0 ; i<=N-1 ; i++ ){

            double x = discreteGen.negativeBinomialGen(r,probabilityOfSuccess); 

                negativeBinomialSample[i]=x;

        }

        return negativeBinomialSample;

    }

}
