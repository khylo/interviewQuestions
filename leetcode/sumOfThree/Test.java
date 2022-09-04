
class Test {
    
    SolutionSumOfThree sol = new SolutionSumOfThree();
    public static void main(String[] args) {
        Test test = new Test();
        test.runTests();
    }

    public String toString(long[] arr){
        if(arr.length==0)
            return "[]";
        StringBuilder sb =new StringBuilder("[");
        for(long l: arr)
            sb.append(l+", ");
        sb.replace(sb.length()-2, sb.length()-1, "]");
        return sb.toString();
    }

    public void runTests(){
        example1();
        example2();
    }

    public void example1(){
        long target = 33;
        long[] ans = sol.sumOfThree(target);
        System.out.println("Example "+target+" = "+toString(ans));
        assert(ans.length==3);
        assert(ans[0]==10);
    }
    public void example2(){
        long target = 4;
        long[] ans = sol.sumOfThree(target);
        System.out.println("Example "+target+" = "+toString(ans));
        
        assert(ans.length==0);
    }
 
}