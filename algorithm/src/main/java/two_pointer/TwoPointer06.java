package two_pointer;

/**
 * 최대 길이 연속부분수열
 * <p>
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 [1 1 1 1 1 1 1 1] 0 1 이며 그 길이는 8입니다.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다. 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 * <p>
 * ▣ 출력설명
 * 첫 줄에 최대 길이를 출력하세요.
 * <p>
 * ▣ 입력예제 1
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * <p>
 * ▣ 출력예제 1
 * 8
 */

public class TwoPointer06 {
    public int solution(int chance, int[] sequence) {
        int answer = 0;
        int count = 0;
        int lt = 0;
        // sequence[rt]가 0이 나올때 마다 count 증가.
        // count가 chnace를 넘어서면, 원본이 0인 배열을 만날때까지 lt를 이동하고, 만나면 count--
        for (int rt = 0; rt < sequence.length; rt++) {
            if (sequence[rt] == 0) {
                count++;
            }
            while (count > chance) {
                if (sequence[lt] == 0) {
                    count--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoPointer06 twoPointer = new TwoPointer06();

        int result = twoPointer.solution(2, new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1});
        System.out.println("result = " + result);
    }
}
