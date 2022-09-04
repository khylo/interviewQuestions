
class TestPens {
    
    SolutionPens sol = new SolutionPens();
    public static void main(String[] args) {
        TestPens test = new TestPens();
        test.runTests();
    }


    public void runTests(){
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
    }

    public void example1(){
        long ans = sol.waysToBuyPensPencils(20,10,5);
        System.out.println("End 20,10,5 = "+(ans));
        assert(ans==9);
    }
    
    public void example2(){
        long ans = sol.waysToBuyPensPencils(5,10,10);
        System.out.println("End 5,10,10 = "+(ans));
        
        assert(ans==1);
    }
 
    public void example3(){
        long ans1 = sol.waysToBuyPensPencils(10,1,6);
        long ans2 = sol.waysToBuyPensPencilsLoops(10,1,6);
        System.out.println("End 10,1,6= 1: %d   2: %s".formatted(ans1, ans2));
        
        assert(ans2==ans1);       
    }
    
    public void example4(){
        long ans1 = sol.waysToBuyPensPencils(10,1,1);
        long ans2 = sol.waysToBuyPensPencilsLoops(10,1,1);
        System.out.println("End 10,1,1 = 1: %d   2: %s".formatted(ans1, ans2));
        
        assert(ans2==ans1);         
    }
    public void example5(){
        long ans1 = sol.waysToBuyPensPencils(10,5,1);
        long ans2 = sol.waysToBuyPensPencilsLoops(10,5,1);
        System.out.println("End 10,5,1 = 1: %d   2: %s".formatted(ans1, ans2));
        
        assert(ans2==ans1);        
    }
    public void example6(){
        long ans1 = sol.waysToBuyPensPencils(1000000,1,1);
        long ans2 = sol.waysToBuyPensPencilsLoops(1000000,1,1);
        System.out.println("End 100k,1,1 = 1: %d   2: %s".formatted(ans1, ans2));
        
        assert(ans2==ans1);        
    }
}