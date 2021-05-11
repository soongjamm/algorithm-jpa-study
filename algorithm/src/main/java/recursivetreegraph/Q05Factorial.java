package recursivetreegraph;

/**
 * 팩토리얼
 * <p>
 * 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요. 예를 들어 5! = 5*4*3*2*1=120입니다.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * <p>
 * ▣ 출력설명
 * 첫 번째 줄에 N팩토리얼 값을 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 5
 * <p>
 * ▣ 출력예제 1
 * 120
 */

public class Q05Factorial {

    public int solution(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * solution(n - 1);
    }


    public static void main(String[] args) {
        Q05Factorial factorial = new Q05Factorial();
        int result = factorial.solution(5);
        System.out.println("result = " + result);
    }
}
