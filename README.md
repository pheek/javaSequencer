javaSequencer
=============

"Integer"-sequecer for the java "foreach" loop.

 for(int x : range(min, max))
 
 instead of incrementing yourself:
 
 for(int x = min; x <= max; x = x + 1)
 
 
 Example to produce all domino stones: 
 
 import static ch.programmieraufgaben.iteration.Sequencer.seq;
 
 for(int first : card(6)) {
          for(int second : range(first, 6)) {
              System.out.println("("+ first + "|" + second + ")");
          }
      }
  
 Or simply use a code 100 times:
 
   for(int i : ord(100)) { 
     myCode(i); }
