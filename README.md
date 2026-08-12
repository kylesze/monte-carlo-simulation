# Monte Carlo Simulation
## Description
*Monte Carlo Simulation* is an algorithm that helps users estimate the outcomes of uncertain events and compare simulated results with 
theoretical calculations.

## Framework
The project uses uniform samples and inverse-transform sampling to generate random variates, which are then used in the Monte Carlo Simulation
to approximate statistical information such as the mean, variance, or standard deviation of the user-defined probability model.

## Key Features
- Program includes a total of 11 distributions, including, but not limited to, Poisson distributions, Gamma distributions and Lognormal distributions.
- User defined number of random variates to simulate.
- User defined probability distribution to sample from.
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

  *Note that for the simulation, using larger numbers of independent random variates will help with estimation accuracy; though, be careful to not choose a significantly large number that cannot be simulated on your system.*

2) After defining the number of random variates we want to use in the simulation, the program will ask:
```Bash
"What type of distribution would you like to sample (Discrete or Continuous)? "
```

in which the user will enter discrete or continuous. 

  *Note that the program detects spelling errors, but is not case and space sensetive; thus, if you do not enter a correctly spelt input, the program will ask you to reenter a valid input.*

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

4) Once the user chooses their desired distribution, the program will ask the user to enter the necessary parameter values of the chosen distribution. For example:
```bash
"Enter the underlying mean of ln(X):"
"Enter the underlying standard deviation of ln(X):"
```

5) Once the distribution parameters have been setup, the program will start the simulation. Before the program ends, the program will ask the user the following prompt:
```bash
"Do you want to compute the variance or standard deviation [Please type in either: variance, standard_deviation, both or no]? Please enter standard_deviation, variance, both or no. Do you want to compute the variance or standard deviation [Please type in either: variance, standard_deviation, both or no]?"
```

in which the user can choose whether they want additional statistical information including variance, standard deviation or both. 

*Note that selecting entering `no` will only give the user statistical information on the mean (first moment). Moreover, for the statistical information(s) that are not selected, in the result file, their statistical information will be set to zero.*

6) Finally, once the user has selected the type of statistical information they would like to obtain, the program will write the results to `Result.txt` in the project directory.

 
# Screenshots of the Program Running

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
- 

# Acknowledgements


# License


