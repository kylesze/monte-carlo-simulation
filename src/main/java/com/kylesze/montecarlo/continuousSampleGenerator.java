package com.kylesze.montecarlo;

public class continuousSampleGenerator {
    
    continuousRandomVariateGen continuousGen = new continuousRandomVariateGen();

        public double[] uniformSampleGenerator(int N , double lowerBound , double upperBound ){

            double[] uniformSample= new double[N];

            for( int i = 0 ; i<=N-1 ; i++ ){

                double x = continuousGen.uniformGen(lowerBound, upperBound);

                uniformSample[i]=x;

            }

            return uniformSample;

        }


        public double[] normalSampleGenerator (int N, double mean, double standardDeviation){

            double[] normalSample= new double[N];

            for( int i = 0 ; i<=N-1 ; i++ ){

                double x = continuousGen.normalGen(mean, standardDeviation);

                normalSample[i]=x;

            }

            return normalSample;

        }


        public double[] exponentialSampleGenerator (int N , double mean){

            double[] exponentialSample= new double[N];

            for( int i = 0 ; i<=N-1 ; i++ ){

                double x = continuousGen.exponentialGen(mean);

                exponentialSample[i]=x;

            }

            return exponentialSample;

        }


        public double[] lognormalSampleGenerator (int N, double underlyingMeanOfLog, double underlyingSDOfLog){ 

            //Note:
            //If we assume X is lognormally distributed, then Y=ln(X) is normally distribution. We will input the mean of Y=ln(X) and the sd of Y=ln(X)
            //to obtain the appropriate lognormal distribution induced by X, which will allow us to generate the appropriate random variates to use in our simulation.
            //
            //Fact is, if Y=ln(X) is normal distributed, then X is lognormally distributed. Assuming Y=ln(X), if we know the mean and sd of Y, we can
            //construct the normal distribution induced by Y and since we know Y=ln(X), we can also construct the lognormal dist of X.

            double[] lognormalSample= new double[N];

            for( int i = 0 ; i<=N-1 ; i++ ){

                double x = continuousGen.lognormalGen( underlyingMeanOfLog, underlyingSDOfLog); 

                lognormalSample[i]=x;

            }

            return lognormalSample;

        }


        public double[] gammaSampleGenerator (int N , double shape, double scale ){

            double[] gammaSample= new double[N];

            for( int i = 0 ; i<=N-1 ; i++ ){

                double x = continuousGen.gammaGen(shape, scale);

                gammaSample[i]=x;

            }

            return gammaSample;

        }


        //Note: As we move farther into the tail, the probability density becomes extremely close to zero,
        //so those regions become extremely unlikely to be represented using a finite sample, and since the 
        //Monte Carlo approximation is approximating the expected value over the entire support of a distribution, 
        //the finite approximation may not capture the "full picture" of the expected value. Distributions including,
        //but not limited to, lognormal and gamma somtimes experience this inaccuracy. 
        //(Slow convergence via MC)

}
