package eu.gressly.util;

import java.util.Iterator;

/**
 * @author phi@gressly.eu
 * @version 1.2: 2013-07-03
 * 
 * A simple to use "Integer"-sequecer for the java "foreach" loop.
 * Provides Iterators like <code>ord()</code> and <code>card()</code>.
 * 
 * Simply use
 * <code>for(int x : range(min, max))</code>
 * instead of incrementing yourself:
 * <code>for(int x = min; x <= max; x = x + 1)</code>.
 * 
 * Example to produce all domino stones: 
 * <pre>
 * import static eu.gressly.util.Sequencer.*;
 * 
 * for(int first : card(6)) {
 *          for(int second : range(first, 6)) {
 *              System.out.println("("+ first + "|" + second + ")");
 *          }
 *      }</pre>
 *  
 * Or simply use a code 100 times:
 * <pre>
 *   for(int i : ord(100)) { 
 *   myCode(i); }
 * </pre>    
 * 
 *
 * History: first Implementation: May 26, 2009
 * Bugs   : not yet known any, not yet known all.
 */


public class Sequencer {
    
    /**
     * Sequencer starting from "min" (inclusive) ending at "max" (inclusive)
     * Use like this:
     * <code>for(int x : seq(7, 9)) { doSomething(x); }</code>
     */
    public static Iterable<Integer> seq(int min, int max) {
        return new Sequencer().new FromToIterable(min, max);
    }
    
    /**
     * Another word for <code>seq</code>.
     * @see seq()
     */
    public static Iterable<Integer> range(int min, int max) {
        return seq(min, max);
    }
    
    /**
     * Ordinal numbers (starting at 1 = "first"; 2 = "second"; ...)
     * ending at "last" (inclusive).
     * 
     * Ordinal numbers always start at first (1.).
     * Use like this:
     * <code>for(int x : ord(6)) { diceNumber(x); }</code>
     */
    public static Iterable<Integer> ord(int last) {
        return Sequencer.seq(1, last);
    }
    
    /**
     * Cardinal numbers (starting at 0) ending at "max" (inclusive).
     * Cardinal numbers describe "how many elements" (this can be zero).
     * Use like this:
     * <code>for(int x : card(9)) { everyDigit(x); }</code>
     */
    public static Iterable<Integer> card(int max) {
        return Sequencer.seq(0, max);
    }
    
    
    /* inner helper classes */
  
    private class FromToIterator  implements Iterator<Integer> {
        int to, act;
        FromToIterator(int from, int to) {
            this.to = to;
            act = from;
        }
        
        @Override
        public boolean hasNext() { return act <= to;  }
    
        @Override
        public Integer next()    { return act++;      }
      
        /**
         * skip next element.
         */
        @Override
        public void remove()     { act ++;            }
    } // end class FromToIterator
   
    
    private class FromToIterable implements Iterable<Integer> {
        FromToIterator fti;
        private FromToIterable(int from, int to) {
            this.fti  = new FromToIterator(from, to);
        }
        @Override
        public Iterator<Integer> iterator() {
            return this.fti;
        }
    } // end class FromToIterable
    
}  // end of class Sequencer
