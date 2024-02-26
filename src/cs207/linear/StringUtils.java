package cs207.linear;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
 * @throws Exception 
   */

//    Step through the characters in the expression
//     When you encounter an open paren or open square bracket, push it 
//       on the stack
//     When you encounter a close paren or close square bracket, pop 
//       the corresponding opening character off the stack.  If the two
//       characters don't match, issue an error.
//     If you encounter a closing character with an empty stack, that 
//       close paren or bracket is mismatched.
//     If the stack is not empty, there are unmatched open or closed parens.

  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    for (int i = 0; i < str.length(); i++ ){
        Character c = str.charAt(i);
        if (c == '(' || c == '[') {
            parens.push(c);
        }
        
        else if (c == ')') {
          if (parens.isEmpty() || parens.peek() != '(') {
            return false;
          } 
          else {
            parens.pop();
          }
        }

        else if (c == ']') {
          if (parens.isEmpty() || parens.peek() != '[') {
            return false;
          } 
          else {
            parens.pop();
          }
        } 
    }
    return (parens.isEmpty());
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils
