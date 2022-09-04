class SolutionSumOfThree {
    long[] mt = {};
    long[] ret = new long[3];
    public long[] sumOfThree(long num) {
        if(num%3 !=0)
            return mt;
        long mid = num/3;
        ret[0]=mid-1;
        ret[1]=mid;
        ret[2]=mid+1;
        return ret;
    }
    public long[] sumOfThreeV1(long num) {
        if(num%3 !=0)
            return new long[]{};
        long mid = num/3;
        return new long[]{mid-1,mid,mid+1};
    }
}