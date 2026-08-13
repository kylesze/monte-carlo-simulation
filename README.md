# Monte Carlo Simulation
## Description
*Monte Carlo Simulation* is an algorithm that helps users estimate the outcomes of uncertain events by approximating the mean, variance, 
and standard deviation in a single run, and evaluating the accuracy of those estimates against analytical solutions. 

## Framework
The project uses uniform samples and inverse-transform sampling to generate random variates, which are then used in the Monte Carlo Simulation 
to approximate the mean, variance, and standard deviation of the user-defined probability model.

## Key Features
- Program includes a total of 11 distributions, including, but not limited to, Poisson distributions, Gamma distributions, and Lognormal distributions.
- User-defined number of random variates to simulate.
- User-defined probability distribution to sample from.
- Error comparisons between simulated and theoretical values.

# Installation Guide / Quick Start

### Requirements
- Java 21
- Apache Maven

### Installation 
1) Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/kylesze/monte-carlo-simulation
cd monte-carlo-simulation
```

2) After navigating to the project directory, compile the project using Maven:

```bash
mvn compile
```

3) Run the program:

```bash
mvn exec:java
```

The simulation results are written to `Result.txt` in the project directory.


# Usage

1) Upon starting the program, the program will prompt:
```Bash
"How many independent random variates would you like to generate for the simulation (Please enter a positive integer)?"
```

in which the user will enter a positive integer.

  *Note that for the simulation, using larger numbers of independent random variates will help with estimation accuracy; though, be careful not to choose a significantly large number that cannot be simulated on your system.*

2) After defining the number of random variates we want to use in the simulation, the program will ask:
```Bash
"What type of distribution would you like to sample (Discrete or Continuous)? "
```

in which the user will enter discrete or continuous. 

  *Note that the program detects spelling errors, but is not case and space-sensitive; thus, if you do not enter a correctly spelled input, the program will ask you to re-enter a valid input.*

3) If the user choses discrete, the program will ask:
```bash
"Which discrete distribution would you like to sample from (Poisson, Binomial, Bernoulli, Geometric, Negative Binomial or Hypergeometric)?
Enter your choice as: poisson, binomial, bernoulli, geometric, negative_binomial, or hypergeometric:"
```

in which the user will choose a discrete distribution. If the user choses continuous, the program will ask: 
```bash
"Which continuous distribution would you like to sample from (Uniform, Normal, Exponential, Lognormal, or Gamma)? 
Enter your choice as: uniform, normal, exponential, lognormal, or gamma:"
```

in which the user will choose a continuous distribution. 

4) Once the user selects their desired distribution, the program will ask them to enter the necessary parameter values for that distribution. For example:
```bash
"Enter the underlying mean of ln(X):"
"Enter the underlying standard deviation of ln(X):"
```

5) Once the distribution parameters have been set up, the program will start the simulation. Before the program ends, it will ask the user the following question:
```bash
"Do you want to compute the variance or standard deviation [Please type in either: variance, standard_deviation, both or no]? Please enter standard_deviation, variance, both or no. Do you want to compute the variance or standard deviation [Please type in either: variance, standard_deviation, both or no]?"
```

in which the user can choose whether to include additional statistical information, such as variance, standard deviation, or both. 

*Note that selecting `no` will only give the user statistical information on the mean (first moment). Moreover, for statistical information that is not selected, the corresponding values in the result file will be set to zero.*

6) Finally, once the user has selected the type of statistical information they would like to obtain, the program will write the results to `Result.txt` in the project directory.

 
# Example / Screenshots 

### Discrete Example
<img width="975" height="113" alt="Screenshot 2026-08-12 at 19 24 32" src="https://github.com/user-attachments/assets/4c45ad51-1f21-4437-95c2-3a38502df3d9" />

<img width="1408" height="91" alt="Screenshot 2026-08-12 at 19 26 19" src="https://github.com/user-attachments/assets/84cb3d5d-aed8-4c10-9130-de79533dc981" />

### Results

<img width="757" height="520" alt="Screenshot 2026-08-12 at 19 26 52" src="https://github.com/user-attachments/assets/ce8298db-a477-46f2-9691-577b487a1fde" />


### Continuous Example

<img width="897" height="118" alt="Screenshot 2026-08-12 at 19 30 18" src="https://github.com/user-attachments/assets/9d626b39-3b93-437c-ade2-da31aed7c034" />

<img width="1405" height="90" alt="Screenshot 2026-08-12 at 19 32 20" src="https://github.com/user-attachments/assets/86f2b730-9e6b-4431-987c-c3d4103e033a" />


### Results

<img width="732" height="525" alt="Screenshot 2026-08-12 at 19 32 49" src="https://github.com/user-attachments/assets/6896ebd1-fada-4bb6-8910-7cbc9a7786e2" />


# Version History

### V1.2.0
- Stable release.
- Added theoretical computations to the statistics class.
- Added error computations.
- Added Maven command-line execution.
  

### V1.1.0
- Fixed bugs related to user input detection in the user interface.
- Added spelling, spacing, and case-sensitivity features to user input detection.
- Added output of simulation results to `Result.txt`.
- Created a new computation class.

### V1.0.0
- Initial release.
- Fixed bugs related to the discrete and continuous random variate generators.
- Fixed bugs related to the lognormal sample generator. 

# Resources
- [SSJ](https://umontreal-simul.github.io/ssj/) for random number generation and probability distribution.
- [Apache Commons Math](https://commons.apache.org/proper/commons-math/) for math and statistic classes.
- [Apache Commons RNG](https://commons.apache.org/proper/commons-rng/) for random number generation.


# License
This program is licensed under the Apache License 2.0.
