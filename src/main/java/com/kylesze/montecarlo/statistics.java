package com.kylesze.montecarlo;

public class statistics {

    monteCarloMain monteCarlo = new monteCarloMain();

    //ApproxMean:
    public double meanApprox (int N, double[] sampleArray ){

        double mean = monteCarlo.montecarlo(N, 1, 0, sampleArray);

        return mean;

    }



    //ApproxVariance:
    public double varianceApprox ( int N, double mean , double[] sampleArray ){ 

        double variance = monteCarlo.montecarlo(N, 2, mean, sampleArray);

        return variance;

    }



    //Standard Deviation
    public double standardDeviation ( double variance ){

        double standard_deviation = Math.sqrt(variance);

        return standard_deviation;

    }



    //Theoretical Mean (Discrete)
    public double meanPoisson ( double lambda ){

        double mean = lambda;

        return mean;

    }


    public double meanBinomial ( double nTrial, double probabilityOfSuccess){

        double mean = nTrial*probabilityOfSuccess;

        return mean;

    }


    public double meanBernoulli ( double probabilityOfSuccess){

        double mean = probabilityOfSuccess;

        return mean;

    }


    public double meanGeometric ( double probabilityOfSuccess ){

        double mean = 1/probabilityOfSuccess;

        return mean;

    }


    public double meanNegativeBinomial ( double r, double probabilityOfSuccess ){

        double mean = (r*(1-probabilityOfSuccess))/probabilityOfSuccess;

        return mean;

    }


    public double meanHypergeometric ( double totalPopulationSize, double numberOfSuccesses , double numberOfDraws){

        double mean = (numberOfDraws*numberOfSuccesses)/totalPopulationSize;

        return mean;

    }



    //Theoretical Mean (Continuous)
        public double meanUniform ( double lowerBound , double uppperBound ){

        double mean = (lowerBound+uppperBound)/2;

        return mean;

    }


    public double meanNormal ( double mean , double standardDeviation ){

        return mean;

    }


    public double meanExponential ( double mean ){

        return mean;

    }


    public double meanGamma ( double shape, double scale ){

        double mean = shape*scale;

        return mean ;

    }


    public double meanLognormal ( double underlyingMeanOfLog , double underlyingSDOfLog ){

        double mean = Math.exp(underlyingMeanOfLog+((Math.pow(underlyingSDOfLog, 2)/2)));

        return mean;

    }



    //Theoretical Variance (Discrete)
    public double variancePoisson ( double lambda ){

        double variance = lambda;

        return variance; 

    }


    public double varianceBinomial ( double nTrials, double probabilityOfSuccess){

        double variance = nTrials*probabilityOfSuccess*(1-probabilityOfSuccess);

        return variance;

    }


    public double varianceBernoulli ( double probabilityOfSuccess){

        double variance = probabilityOfSuccess*(1-probabilityOfSuccess);

        return variance;

    }


    public double varianceGeometric ( double probabilityOfSuccess ){

        double variance = (1-probabilityOfSuccess)/Math.pow(probabilityOfSuccess, 2);

        return variance;

    }


    public double varianceNegativeBinomial ( double r, double probabilityOfSuccess ){

        double variance = (r*(1-probabilityOfSuccess))/Math.pow(probabilityOfSuccess, 2);

        return variance;

    }


    public double varianceHypergeometric ( double totalPopulationSize, double numberOfSuccesses , double numberOfDraws){

        double expression1 = numberOfDraws* (numberOfSuccesses/totalPopulationSize);

        double expression2 = ((totalPopulationSize-numberOfSuccesses)/totalPopulationSize)*((totalPopulationSize-numberOfDraws)/(totalPopulationSize-1));

        double variance = expression1*expression2;

        return variance;

    }



    //Theoretical Variance (Continuous)
    public double varianceUniform ( double lowerBound , double uppperBound ){

        double variance = (Math.pow(uppperBound-lowerBound,2))/12;

        return variance;

    }


    public double varianceNormal ( double mean , double standardDeviation){

        double variance = Math.pow(standardDeviation, 2);

        return variance;

    }


    public double varianceExponential ( double mean ){

        double variance = Math.pow(mean, 2);

        return variance;

    }


    public double varianceGamma ( double shape, double scale ){

        double variance = (shape)*Math.pow(scale, 2);

        return variance ;

    }


    public double varianceLognormal ( double underlyingMeanOfLog , double underlyingSDOfLog ){

        double expression1 = 2*(underlyingMeanOfLog) + Math.pow(underlyingSDOfLog, 2);

        double expression2 = Math.exp(underlyingSDOfLog*underlyingSDOfLog);

        double variance = Math.exp(expression1) * (expression2 - 1);

        return variance;

    }
    


    //Statistics Error Info
    public double errorMean ( double theoryMean , double approxMean ){

        double expression = approxMean - theoryMean;

        double error = Math.abs(expression);

        return error;

    }

    public double errorVariance (double theoryVar , double approxVar ){

        double expression = approxVar-theoryVar;

        double error = Math.abs(expression);

        return error;

    }

    public double errorSD (double theorySD , double approxSD ){

        double expression = approxSD-theorySD;

        double error = Math.abs(expression);

        return error;

    }


    public double percentageError (double errorValue , double theoryValue ){

        double expression = errorValue / Math.abs(theoryValue);

        double percentageError = expression*100;

        return percentageError;

    }



}
