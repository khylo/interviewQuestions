class SolutionPens {
    public long waysToBuyPensPencils(int total, int penCost, int pencilCost) {
        int[] dc = dearCheap(penCost,pencilCost);
        int dearIterations = total/dc[0];
        long iterations = dearIterations+total/dc[1]+1;
        //System.out.println("Total %d, pen %d, pencil %d, Initial count %d".formatted(total, penCost, pencilCost, iterations));
        for (int i = 1; i <= dearIterations; i++) {
            int newTotal = total-(i*dc[0])-dc[1];
            if(newTotal>=0){         
                iterations+=newTotal/dc[1]+1;
                //System.out.println("%d dear : New count %d".formatted(i,iterations));
            }
        }
        return iterations;
    }

    private int[] dearCheap(int a, int b){
        if(a>b)
            return new int[]{a,b};
        return new int[]{b,a};
    }
    

    /* exceeds time for 1000000,1,1 */
    public int waysToBuyPensPencilsLoops(int total, int penCost, int pencilCost) {
        int iterations=0;
        for (int i = 0;i<=total/penCost; i++) { // pens
            for (int j = 0; j<=total/pencilCost; j++) { //pencils
                if(penCost*i+pencilCost*j <= total){
                    //System.out.println("waysToBuyPensPencil %d: %d pens %d pencils ".formatted(iterations,i,j));
                    iterations++;
                }
            }
        }
        return iterations;
    }
}