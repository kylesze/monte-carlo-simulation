package com.kylesze.montecarlo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class userInterface {
    
    public static void main(String[] args) {

////////////////////////////////////////////////////////////////////////////////////(1) N Choice
        Scanner userInput = new Scanner(System.in);

            System.out.print("How many independent random variates would you like to generate for the simulation (Please enter a positive integer)? ");

            int N = userInput.nextInt(); 

            userInput.nextLine();

            double[][] userInputStorage = new double[3][N];

            userInputStorage[0][0]=N;

////////////////////////////////////////////////////////////////////////////////////(2) Distribution choice
boolean userTypeInputNotRecieved = true;
boolean userInputNotRecieved = true;

statistics statistics = new statistics();

discreteSampleGenerator discreteSampleGenerator = new discreteSampleGenerator();
continuousSampleGenerator continuousSampleGenerator = new continuousSampleGenerator();

double theoryMean = 0;
double theoryVariance =0;
double theorySD = 0;

        System.out.print("What type of distribution would you like to sample (Discrete or Continuous)? ");

        while ( userInputNotRecieved ){

            String userInputDistribution = userInput.nextLine(); 

            String userInputDistributionLower= userInputDistribution.toLowerCase();

            String[] userInputSplit1 = userInputDistributionLower.split("\\s"); 

            Arrays.sort(userInputSplit1);

                String[] wordCheck1 = {"discrete", "continuous", "#%^@"};

            for ( int i = 0 ; i<=2 ; i++ ){

                int checkDistributionInput = Arrays.binarySearch(userInputSplit1, wordCheck1[i]);       

                    if ( checkDistributionInput>=0 && i <2 ){

                    System.out.println();

                    String distributionType = wordCheck1[i];

                    switch (distributionType){

                        case "discrete" ->{

                            while ( userTypeInputNotRecieved ){

                                System.out.println("Which discrete distribution would you like to sample from (Poisson, Binomial, Bernoulli, Geometric, Negative Binomial or Hypergeometric)?"); 
                                System.out.print("Enter your choice as: poisson, binomial, bernoulli, geometric, negative_binomial, or hypergeometric: ");

                                String discreteType = userInput.nextLine();
                            
                                String discreteTypeLower= discreteType.toLowerCase();

                                String[] userInputSplit2 = discreteTypeLower.split("\\s"); 

                                Arrays.sort(userInputSplit2);

                                System.out.println();

                                String[] discreteTypes = {"poisson", "binomial", "bernoulli", "geometric", "negative_binomial", "hypergeometric", "#%^@"};

                                    for ( int j = 0 ; j<=6 ; j++){ 

                                        int checkDiscreteType = Arrays.binarySearch(userInputSplit2, discreteTypes[j]);

                                            if ( checkDiscreteType>= 0 && j < 6 ){

                                                String discreteChoice = discreteTypes[j];

                                                    switch(discreteChoice){

                                                        case "poisson" -> {

                                                            System.out.print("Enter the value of lambda: ");

                                                            double userLambdaEntry = userInput.nextDouble();

                                                            double[] poissonSample = discreteSampleGenerator.poissonSampleGenerator(N, userLambdaEntry);

                                                                for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                    userInputStorage[1][k]=poissonSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanPoisson(userLambdaEntry);
                                                            double theoreticalVariance = statistics.variancePoisson(userLambdaEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;
    
                                                        }
                                                        
                                                        case "binomial" -> {

                                                            System.out.print("Enter the number of independent trials: ");

                                                            int userNumberOfIndependentTrialsEntry = userInput.nextInt();

                                                            System.out.print("Enter the probability of success for each trial: ");

                                                            double userProbabilityOfSuccessEntry = userInput.nextDouble();

                                                            double[] binomialSample = discreteSampleGenerator.binomialSampleGenerator(N , userNumberOfIndependentTrialsEntry, userProbabilityOfSuccessEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=binomialSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanBinomial(userNumberOfIndependentTrialsEntry, userProbabilityOfSuccessEntry);
                                                            double theoreticalVariance = statistics.varianceBinomial(userNumberOfIndependentTrialsEntry, userProbabilityOfSuccessEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }
                                                        
                                                        case "bernoulli" -> {

                                                            System.out.print("Enter the probability of success: ");

                                                            double userProbabilityOfSuccessEntry = userInput.nextDouble();

                                                            double[] bernoulliSample = discreteSampleGenerator.bernoulliSampleGenerator(N, userProbabilityOfSuccessEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=bernoulliSample[k];

                                                                }


                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanBernoulli(userProbabilityOfSuccessEntry);
                                                            double theoreticalVariance = statistics.varianceBernoulli(userProbabilityOfSuccessEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }
                                                        
                                                        case "geometric" -> {

                                                            System.out.print("Enter the probability of success: ");

                                                            double userProbabilityOfSuccessEntry = userInput.nextDouble();

                                                            double[] geometricSample = discreteSampleGenerator.geometricSampleGenerator(N, userProbabilityOfSuccessEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=geometricSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false; 

                                                            double theoreticalMean = statistics.meanGeometric(userProbabilityOfSuccessEntry);
                                                            double theoreticalVariance = statistics.varianceGeometric(userProbabilityOfSuccessEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }
                                                        
                                                        case "negative_binomial" -> {

                                                            System.out.print("Enter the value of r: ");

                                                            int userrValue = userInput.nextInt();

                                                            System.out.print("Enter the probability of success: ");

                                                            double userProbabilityOfSuccessEntry = userInput.nextDouble();

                                                            double[] negativeBinomialSample = discreteSampleGenerator.negativeBinomialSampleGenerator(N, userrValue, userProbabilityOfSuccessEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=negativeBinomialSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanNegativeBinomial(userrValue, userProbabilityOfSuccessEntry);
                                                            double theoreticalVariance = statistics.varianceNegativeBinomial(userrValue, userProbabilityOfSuccessEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }
                                                        
                                                        case "hypergeometric" -> {

                                                            System.out.print("Enter the total population size: ");

                                                            int userTotalSizeOfPopulationEntry = userInput.nextInt();

                                                            System.out.print("Enter the number of successes in the population: "); 

                                                            int userNumberOfSuccessInPopulationEntry = userInput.nextInt();

                                                            System.out.print("Enter the number of draws (sample size): ");

                                                            int userNumberOfDrawsEntry = userInput.nextInt();

                                                            double[] hypergeometricSample = discreteSampleGenerator.hypergeometricSampleGenerator(N, userTotalSizeOfPopulationEntry, userNumberOfSuccessInPopulationEntry, userNumberOfDrawsEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=hypergeometricSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanHypergeometric(userTotalSizeOfPopulationEntry, userNumberOfSuccessInPopulationEntry, userNumberOfDrawsEntry);
                                                            double theoreticalVariance = statistics.varianceHypergeometric(userTotalSizeOfPopulationEntry, userNumberOfSuccessInPopulationEntry, userNumberOfDrawsEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }

                                                    }

                                            }else if ( checkDiscreteType<0 && j>=6 && userTypeInputNotRecieved ){

                                                System.out.print("Please enter a valid discrete distribution. ");

                                            }
                                    }

                            }

                        }

                        case "continuous" ->{

                             while ( userTypeInputNotRecieved ){ 

                                System.out.println("Which continuous distribution would you like to sample from (Uniform, Normal, Exponential, Lognormal, or Gamma)? ");
                                System.out.print("Enter your choice as: uniform, normal, exponential, lognormal, or gamma: ");

                                String continuousType = userInput.nextLine();
                            
                                String continuousTypeLower= continuousType.toLowerCase();

                                String[] userInputSplit3 = continuousTypeLower.split("\\s"); 

                                Arrays.sort(userInputSplit3);

                                System.out.println();

                                String[] continuousTypes = {"uniform", "normal", "exponential", "lognormal", "gamma", "#%^@"};

                                for ( int j = 0 ; j<=5 ; j++){ 

                                        int checkContinuousType = Arrays.binarySearch(userInputSplit3, continuousTypes[j]);

                                            if ( checkContinuousType>= 0 && j < 5 ){

                                                String continuousChoice = continuousTypes[j];

                                                    switch(continuousChoice){

                                                        case "uniform" -> {

                                                            System.out.print("Enter the lower bound: ");

                                                            double userLowerBoundEntry = userInput.nextDouble();

                                                            System.out.print("Enter the upper bound: ");

                                                            double userUpperBoundEntry = userInput.nextDouble();

                                                            double[] uniformSample = continuousSampleGenerator.uniformSampleGenerator(N, userLowerBoundEntry, userUpperBoundEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=uniformSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanUniform(userLowerBoundEntry, userUpperBoundEntry);
                                                            double theoreticalVariance = statistics.varianceUniform(userLowerBoundEntry, userUpperBoundEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }

                                                        case "normal" -> {

                                                            System.out.print("Enter the mean: ");

                                                            double userMeanEntry = userInput.nextDouble();

                                                            System.out.print("Enter the standard deviation: ");

                                                            double userStandardDeviationEntry = userInput.nextDouble();

                                                            double[] normalSample = continuousSampleGenerator.normalSampleGenerator(N, userMeanEntry, userStandardDeviationEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=normalSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanNormal(userMeanEntry, userStandardDeviationEntry);
                                                            double theoreticalVariance = statistics.varianceNormal(userMeanEntry, userStandardDeviationEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }

                                                        case "exponential" -> {

                                                            System.out.print("Enter the mean: ");

                                                            double userMeanEntry = userInput.nextDouble();

                                                            double[] exponentialSample = continuousSampleGenerator.exponentialSampleGenerator(N, userMeanEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=exponentialSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanExponential(userMeanEntry);
                                                            double theoreticalVariance = statistics.varianceExponential(userMeanEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;


                                                        }

                                                        case "lognormal" -> {

                                                            System.out.print("Enter the underlying mean of ln(X): ");

                                                            double userUnderlyingMeanOfLog = userInput.nextDouble();

                                                            System.out.print("Enter the underlying standard deviation of ln(X): ");

                                                            double userUnderlyingSDOfLog = userInput.nextDouble();

                                                            double[] lognormalSample = continuousSampleGenerator.lognormalSampleGenerator(N, userUnderlyingMeanOfLog, userUnderlyingSDOfLog);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=lognormalSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanLognormal(userUnderlyingMeanOfLog, userUnderlyingSDOfLog);
                                                            double theoreticalVariance = statistics.varianceLognormal(userUnderlyingMeanOfLog, userUnderlyingSDOfLog);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }

                                                        case "gamma" -> {

                                                            System.out.print("Enter the shape: ");

                                                            double userShapeEntry = userInput.nextDouble();

                                                            System.out.print("Enter the scale: ");

                                                            double userScaleEntry = userInput.nextDouble();

                                                            double[] gammaSample = continuousSampleGenerator.gammaSampleGenerator(N, userShapeEntry, userScaleEntry);

                                                               for ( int k = 0 ; k<= N-1 ; k++ ){

                                                                userInputStorage[1][k]=gammaSample[k];

                                                                }

                                                            userTypeInputNotRecieved = false;

                                                            double theoreticalMean = statistics.meanGamma(userShapeEntry, userScaleEntry);
                                                            double theoreticalVariance = statistics.varianceGamma(userShapeEntry, userScaleEntry);
                                                            double theoreticalSD = statistics.standardDeviation(theoreticalVariance);

                                                            theoryMean += theoreticalMean;
                                                            theoryVariance += theoreticalVariance;
                                                            theorySD += theoreticalSD;

                                                        }

                                                    }

                                                }else if ( checkContinuousType<0 && j>=5 && userTypeInputNotRecieved){

                                                    System.out.print("Please enter a valid continuous distribution. ");

                                                }

                                            }

                        }

                    }

                }


            if ( !userTypeInputNotRecieved ){

            userInputNotRecieved = false;

            }


            }else if ( checkDistributionInput<0 && i>=2 && userInputNotRecieved ) {

                    System.out.print("Please enter either discrete or continuous: ");

            }

        }

    }

System.out.println();

////////////////////////////////////////////////////////////////////////////////////(3) Statistics Info Choice
    userInputNotRecieved=true;

            while ( userInputNotRecieved ){

                System.out.print("Do you want to compute the variance or standard deviation [Please type in either: variance, standard_deviation, both or no]? ");

                String userInputStatistic = userInput.nextLine();

                String userInputStatisticLower= userInputStatistic.toLowerCase(); //convert input to lowercase to avoid issues with case sensetivity.

                String[] userInputSplit = userInputStatisticLower.split("\\s"); //we don't want to care about spacing, only the user's desired input. 

                Arrays.sort(userInputSplit);

                String[] wordCheck = {"variance", "standard_deviation", "both", "no", "#%^@"};

                        for (int i=0 ; i <= 4 ; i++) {

                            int checkStatisticInput = Arrays.binarySearch(userInputSplit, wordCheck[i]);

                                if ( checkStatisticInput>=0 && i < 4 ){

                                    System.out.println();

                                    String choice = wordCheck[i];

                                    switch (choice){

                                        case "variance" -> {

                                            double variance = 1.0;

                                            userInputStorage[2][0] = variance;

                                            userInputNotRecieved = false;

                                        }

                                        case "standard_deviation" -> {

                                            double standard_deviation = 2.0;

                                            userInputStorage[2][0] = standard_deviation;

                                            userInputNotRecieved = false;

                                        }

                                        case "both" -> {

                                            double both = 3.0;

                                            userInputStorage[2][0] = both;

                                            userInputNotRecieved = false;

                                        }

                                        case "no" -> { 

                                            double no = 0.0;

                                            userInputStorage[2][0] = no;

                                            userInputNotRecieved = false;

                                        }

                                    }

                                }else if (checkStatisticInput<0 && i>=4 && userInputNotRecieved ){

                                    System.out.print("Please enter standard_deviation, variance, both or no. ");

                                } 

                        }

            }

////////////////////////////////////////////////////////////////////////////////////(4) Computation
computation computation = new computation();

        double meanResult = 0;
        double varianceResult =0;
        double sdResult = 0;

        int choice = (int)userInputStorage[2][0];

        switch (choice) {

            case 0 ->{

                double mean = computation.meanComputation(userInputStorage);

                meanResult+=mean;

            }

            case 1 -> {

                double mean = computation.meanComputation(userInputStorage);

                double variance = computation.varianceComputation(userInputStorage, mean);

                meanResult+=mean;

                varianceResult+=variance;


            }

            case 2 -> {

                double mean = computation.meanComputation(userInputStorage);

                double variance = computation.varianceComputation(userInputStorage, mean);

                double sd = statistics.standardDeviation(variance);

                meanResult+=mean;

                sdResult+=sd;

            }

            case 3 -> {

                double mean = computation.meanComputation(userInputStorage);

                double variance = computation.varianceComputation(userInputStorage, mean);

                double sd = statistics.standardDeviation(variance);

                meanResult+=mean;

                varianceResult+=variance;

                sdResult+=sd;

            }

        }

        double errorMean = statistics.errorMean(theoryMean, meanResult);
        double errorVariance = statistics.errorVariance(theoryVariance, varianceResult);
        double errorSD = statistics.errorSD(theorySD, sdResult);
        double errorValue1 = statistics.percentageError(errorMean, theoryMean);
        double errorValue2 = statistics.percentageError(errorVariance, theoryVariance);
        double errorValue3 = statistics.percentageError(errorSD, theorySD);

        int checkChoice = (int)userInputStorage[2][0];

        switch (checkChoice) {

            case 0 -> {

                errorVariance*=0;
                errorSD*=0;
                errorValue2*=0;
                errorValue3*=0;

            }

            case 1 -> {

                errorSD*=0;
                errorValue3*=0;

            }

            case 2-> {

                errorVariance*=0;
                errorValue2*=0;

            }

            case 3-> {

                break;

            }

        }

////////////////////////////////////////////////////////////////////////////////////(5) Print results
try{
BufferedWriter writer = new BufferedWriter(new FileWriter("Result.txt"));

    String resultOutput = """
==========================================================================================
==============================Monte Carlo Simulation Results==============================                              
==========================================================================================
Number of Random Variates Simulated: %d 


Approximated Mean: %f 
Absolute Error of the Mean: %f
Percentage Error of the Approximated Mean: %f%%


Approximated Variance: %f
Absolute Error of the Variance: %f
Percentage Error of the Approximated Variance: %f%%


Approximated Standard Deviation: %f
Absolute Error of the Standard Deviation: %f
Percentage Error of the Approximated Standard Deviation: %f%%


Note: 
The approximate variance of a lognormal or gamma distribution may differ significantly from 
its theoretical value due to the slower convergence of the second moment in the Monte Carlo
simulation.


            """.formatted(N,meanResult,errorMean,errorValue1,varianceResult,errorVariance,errorValue2,sdResult,errorSD,errorValue3);


    writer.write(resultOutput);
    writer.close();

}catch (IOException e ) {

e.printStackTrace();
}

    }

}