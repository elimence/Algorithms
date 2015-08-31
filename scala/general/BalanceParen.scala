package general

import scala.collection.mutable.Stack
import scala.collection.immutable.HashMap

object BalanceParen {
	def main(args: Array[String]) {
		args map { (str: String) => println(str+ " : "+ isBalanced(str)) }
	}
	def isBalanced(input: String): Boolean = {
		val stack = new Stack[Char]
		val brace = HashMap('(' -> ')', '[' -> ']', '{' -> '}')

		input map (( ch: Char ) => {
			if( brace contains ch ) stack push ch
			else {
				if( stack.isEmpty )              		return false
				if( brace.get(stack.pop) != Some(ch) ) 	return false
			}
		})
		return stack.isEmpty
	}
}