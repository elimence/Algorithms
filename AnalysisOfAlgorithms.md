# Analysis Of Algorithms

* Efficienty of an algorithm can be measured in terms of:
  	* Execution time `time complexity`
  	* The amount of memory required `space complexity`

 * The measure which is most important depends on the limitations of the technology available at time of analysis


## Time Complexity
 
* For most algorithms analyzed here, time complexity comparisons are more interesting than space complexity comparisons.
* Time complexity: A measure of the amount of time required to execute an algorithm

* Factors that `should not` affect time complexity analysis:
	* The programming language chosen to implement the algorithm
	* The quality of the compiler
	* The speed of the computer on which the algorithm is to be executed

* Objectives of time complexity analysis:
	* To determine the feasibility of an algorithm by estimating an `upper bound` on the amount of work performed
	* To compare different algorithms before deciding on which one to implement

* Time complexity expresses the relationship between the `size of the input` and the `run time` for the algorithm and is usually expressed as a proportionality rather than an exact function

* To simplify analysis, we sometimes ignore work that takes a `constant` amount of time, independent of the input size

* Simplifies analysis can be based on number of:
	* Arithmetic operations performed
	* Comparisons made
	* Times through a critical loop etc

## Big-O Notation
* Formally, the `time complexity T(n)` of an algorithm is `O(f(n)) of the order f(n)` if, for some positive constants C1 and C2 for all but finitely many values of `n`
`![equation](http://latex.codecogs.com/gif.latex?C_%7B1%7D%20*%20f%28n%29%20%5Cleq%20T%28n%29%20%5Cleq%20C_%7B2%7D%20*%20f%28n%29)`

* This gives `upper` and `lower bounds` on the amount of work done for all sufficiently large `n`

* We wamt am easily recognized elementary function to describe the performance of the algorithm, so we use the `dominant term` of `T(n)`: it determines teh basic `shape` of the function

## Worst Case vs. Average Case
* Worst case analysis is used to find an upper bound on an algorithm performance for large problems (large `n`)
* Average case analysis determines the average (or `expected`) performance
* Worst case time complexity is usually simpler to work out

## Big-O Analysis in General
* With independent nested loops: The number of iterations of the inner loop is independent of the number of iterations of the outer loop
	* `Example`
	
	```javascript
	int x = 0;

	for (int j = 1; j <= n/2; j++)
		for (int k = 1; k <= n*n; k++)
			x = x + j + k;
	```
