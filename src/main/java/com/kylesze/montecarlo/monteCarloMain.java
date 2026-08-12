package com.kylesze.montecarlo;

public class monteCarloMain {

        public double montecarlo (int N , int K , double C , double[] sampleArray ){ 

            double expectation = 0;

                for ( int i = 0 ; i<=sampleArray.length-1 ; i++ ){

                    double x = sampleArray[i];

                    double compute = Math.pow(x-C, K);

                    expectation += compute;

                }

            double result = expectation/N;

            return result;

       }

    }
    //Mean: K=1 & C=0
    //Variance: K=2 & C=mean


