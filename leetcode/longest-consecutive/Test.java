class Test {
    
    Solution1 sol = new Solution1();
    public static void main(String[] args) {
        Test test = new Test();
        test.runTests();
    }

    public void runTests(){
        example1();
        example2();
        example3();
    }

    public void example1(){
        int[] data = {100,4,200,1,3,2};
        int ans = sol.longestConsecutive(data);
        System.out.println("Example1 = "+ans);
        assert 4 == ans;
    }
    public void example2(){
        int[] data = {0,3,7,2,5,8,4,6,0,1};
        int ans = sol.longestConsecutive(data);
        System.out.println("Example2 = "+ans);
        assert 9 == ans;
    }
 
    public void example3(){
        int[] data = {1,2,0,1};
        int ans = sol.longestConsecutive(data);
        System.out.println("Example2 = "+ans);
        assert 3 == ans;
    }   

    public void example4(){
        int[] data = {9,8,7,6};
        int ans = sol.longestConsecutive(data);
        System.out.println("Example3 = "+ans);
        assert 4 == ans;
    }   
    public void example5(){
        int[] data = {3,1,4,2};
        int ans = sol.longestConsecutive(data);
        System.out.println("Example4 = "+ans);
        assert 4 == ans;
    }   
}