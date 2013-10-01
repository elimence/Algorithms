# Analysis Of Algorithms

* Efficienty of an algorithm can be measured in terms of:
  	* Execution time `(time complexity)`
  	* The amount of memory required `(space complexity)`

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
* Formally, the `time complexity T(n)` of an algorithm is `O(f(n)) `of the order f(n)`` if, for some positive constants C1 and C2 for all but finitely many values of `n`
`C1 * f(n) <= T(n) <= C2 * f(n)

* This gives `upper` and `lower bounds` on the amount of workd done for all sufficiently large `n`