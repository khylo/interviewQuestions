import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This problem was recently asked by Google:

There are n people lined up, and each have a height represented as an integer. A murder has happened right in front of them, 
and only people who are taller than everyone in front of them are able to see what has happened. How many witnesses are there?

Example:
Input: [3, 6, 3, 4, 1]  
Output: 3
Explanation: Only [6, 4, 1] were able to see in front of them.
 #
 #
 # #
####
####
#####
36341                                 x (murder scene)
Here's your starting point:

def witnesses(heights):
  # Fill this in.

print witnesses([3, 6, 3, 4, 1])
# 3
 */
public class TallPeople {

  public int witnesses(List<Integer> heights){
    Collections.reverse(heights);
    int first = heights.get(0);
    List<Integer> listOfResults = join(first,  canSee(heights.subList(1, heights.size()), first));
    System.out.println(listOfResults);
    return listOfResults.size();
  }

  public List<Integer> canSee(List<Integer> heights, int tallest){
    System.out.println("Checking  "+heights+". Tallest =  "+tallest);
    int next = heights.get(0);
    if(heights.size()==1){
      if(next> tallest) {
        return asList(new Integer[]{next});
      }else{
        return asList();
      }
    }
    if(next> tallest) {
      return join(next, canSee(heights.subList(1, heights.size()), next));
    }
    System.out.println("Not adding "+next+". Can't see over "+tallest);
    return canSee(heights.subList(1, heights.size()), tallest);
  }

  public List<Integer> join(Integer i, List<Integer> list){
    System.out.println("adding "+i+" to "+list);
    list.add(i);
    return list;
  }

  private List<Integer> asList(){
    return new ArrayList<>();
  }

  private List<Integer> asList(Integer[] a){
    ArrayList<Integer> ret = new ArrayList<>(a.length);
    for(int i=0;i<a.length;i++){
      ret.add(a[i]);
    }
    return ret;
  }
  
  public static void main(String[] args) {
    TallPeople p = new TallPeople();
    System.out.println( p.witnesses(p.asList(new Integer[]{3, 6, 3, 4, 1 })));
  }

  
    
}