package general;

import java.util.*;

/**
 * Runs in O(n)
 * will have to check performance of hashmap functions
 */
public class BalanceParen {

  public static void main(String[] args) {
    System.out.println(isBalanced(")))))"));
  }
  
  private static boolean isBalanced(String input) {
    Stack<Character> stack  = new Stack<>();

    Map<Character, Character> braces = new HashMap<Character, Character>() {{
      put('(', ')'); put('[', ']'); put('{', '}');
    }};

    for(char ch : input.toCharArray()) {
      if(braces.containsKey(ch)) {
        stack.push(ch); // push open braces into stack
      } else {
        if(stack.isEmpty()) {
          return false; // if we have a close brace and stack is empty, return false
        }
        // compare the closing brace that matches the popped open brace
        // with the close brace in current char ch
        if(ch != braces.get(stack.pop())) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}