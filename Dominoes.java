
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
public class Dominoes {
    StringBuilder dominoes;    
    ActionFactory af = new ActionFactory();
    public String pushDominoes(final String dominoes){
        Objects.requireNonNull(dominoes);
        this.dominoes = new StringBuilder( dominoes);
        final Map<Integer, Action> actions = verifyAndScanDominoes();
        System.out.println("actions = "+actions);
        processActions(actions);
        return this.dominoes.toString();
    }

    private Map<Integer, Action> verifyAndScanDominoes(){
        final Map<Integer, Action> actionList = new HashMap<>();
        for(int i=0;i<dominoes.length();i++){
            final char c= dominoes.charAt(i);
            if(c=='L'){
                actionList.put(i,af.createAction(ActionType.L, i,Optional.empty()));
            }else if(c=='R'){
                actionList.put(i,af.createAction(ActionType.R, i,Optional.empty()));
            }else if(c=='.'){

            }else{
                throw new RuntimeException ("Invalid input character ["+c+"]");
            }            
        }    
        return actionList;    
    }

    /**
     * Process every action (by marking square and creating new action for target square
     * Collisions kill the action
     * When no actions left we are done.
     */
    private void processActions( final Map<Integer, Action> actionList){
        System.out.println("actions = "+actionList + " len = "+dominoes.length());
        final Map<Integer, Action> nextActions = new HashMap<>();
        for(final Action a:actionList.values()){
            if(a.actionType==ActionType.L){
                dominoes.replace(a.i, a.i+1, ActionType.L.toString());
                final Action next = af.createAction(ActionType.L, a.i-1, Optional.of(nextActions));
                if(next==null)  // remove collision
                    nextActions.remove(a.i-1);
                else if(a.i>0)
                    nextActions.put(a.i-1, next);

            }
            if(a.actionType==ActionType.R){
                dominoes.replace(a.i, a.i+1, ActionType.R.toString());
                final Action next = af.createAction(ActionType.R, a.i+1, Optional.of(nextActions));
                if(next==null)  // remove collision
                    nextActions.remove(a.i+1);
                else if(a.i<dominoes.length()-1)
                    nextActions.put(a.i+1, next);
            }
        }
        if(nextActions.size()>0)        
            processActions(nextActions);
        return;
    }

    enum ActionType{
        L,R
    }

    class ActionFactory{
        public Action createAction(final ActionType at, final int i, final Optional<Map<Integer, Action>> done){
            if(!done.isEmpty() && done.get().get(i)!=null){// collision
                return null;
            }          
            return new Action(at, i);
        }
    }


    class Action{
        ActionType actionType;
        int i;
        Action(final ActionType at, final int i){
            this.actionType = at;
            this.i = i;
        }

        public String toString(){
            return actionType.toString();
        }
    }
    public static void main(final String[] args) {
        System.out.println(new Dominoes().pushDominoes("..R...L..R."));
    }
}


