/*
Given a string with the initial condition of dominoes, where:

. represents that the domino is standing still
L represents that the domino is falling to the left side
R represents that the domino is falling to the right side

Figure out the final position of the dominoes. If there are dominoes that get pushed on both ends, the force cancels out and that domino remains upright.

Example:
Input:  ..R...L..R.
Output: ..RR.LL..RR

Here is your starting point:

class Solution(object):
  def pushDominoes(self, dominoes):
    # Fill this in.

print Solution().pushDominoes('..R...L..R.')
# ..RR.LL..RR
*/
class Solution {}
    constructor() { }

    let d;
  
    pushDominoes(dominoes){
        d=dominoes;
        scanDominoes()
    }


    scanDominoes(){
        Map actionSet = new Map();
        
    } 
}


console.log(new Solution().pushDominoes('..R...L..R.')
// ..RR.LL..RR