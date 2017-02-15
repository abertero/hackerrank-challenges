package cl.scotiabank;

//@Controller
public class RestServices {

    //@RequestMapping(value = "/fibonacci/{n}", method = {RequestMethod.GET})
    //@ResponseBody
    public GetNElementFibonacciResponse getNElementFibonacci(/*@PathVariable*/ int n) {
        return new GetNElementFibonacciResponse(FibonacciNumbers.getFibonacci(n));
    }

    //@RequestMapping(value = "/fibonacci/all/{n}", method = {RequestMethod.GET})
    //@ResponseBody
    public GetAllNElementsFibonacciResponse getAllNElementFibonacci(/*@PathVariable*/ int n) {
        Integer[] fibonacciArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            fibonacciArray[i] = FibonacciNumbers.getFibonacci(i);
        }
        return new GetAllNElementsFibonacciResponse(fibonacciArray);
    }

    //@RequestMapping(value = "/factorial/{n}", method = {RequestMethod.GET})
    //@ResponseBody
    public GetNFactorialResponse getNFactorial(/*@PathVariable*/ int n) {
        return new GetNFactorialResponse(getFactorial(n));
    }

    public static Integer getFactorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public class GetNElementFibonacciResponse {
        private Integer result;

        public GetNElementFibonacciResponse(Integer result) {
            this.result = result;
        }
    }

    public class GetAllNElementsFibonacciResponse {
        private Integer[] results;

        public GetAllNElementsFibonacciResponse(Integer[] results) {
            this.results = results;
        }
    }

    public class GetNFactorialResponse {
        private Integer result;

        public GetNFactorialResponse(Integer result) {
            this.result = result;
        }
    }
}
