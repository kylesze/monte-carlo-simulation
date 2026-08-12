package com.kylesze.montecarlo;

public class computation {

    monteCarloMain monteCarlo = new monteCarloMain();
    statistics statistics = new statistics();

        public double meanComputation ( double[][] userInputStorage ){ 

            int N =(int)userInputStorage[0][0];

            double[] sample = new double[N];

            for ( int i = 0 ; i<= N-1 ; i++ ){

                sample[i]=userInputStorage[1][i];

            }

            double mean = monteCarlo.montecarlo(N, 1, 0, sample);

            return mean;

        }


        public double varianceComputation ( double[][] userInputStorage , double mean){

            int N =(int)userInputStorage[0][0];

            double[] sample = new double[N];

            for ( int i = 0 ; i<= N-1 ; i++ ){  

                sample[i]=userInputStorage[1][i];

            }

            double variance = statistics.varianceApprox(N, mean, sample);

            return variance;

        }

}
