import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    int add(String text){
        // 공백일 경우
        if (Objects.isNull(text)){
            return 0;
        }

        // 기본 구분자(쉼표 또는 콜론)일 경우
        int sum = 0;
        if (text.indexOf(',') != -1 || text.indexOf(':') != -1){
            String [] numbers = text.split(",|:");
            for(String number : numbers){
                int num = Integer.parseInt(number);
                // 음수를 전달할 경우
                if (num < 0) throw new RuntimeException();
                sum += num;
            }
            return sum;
        }

        // 커스텀 구분자
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()){
            String customDelimiter = matcher.group(1);
            String [] numbers = matcher.group(2).split(customDelimiter);
            for(String number : numbers){
                int num = Integer.parseInt(number);
                // 음수를 전달할 경우
                if (num < 0) throw new RuntimeException();
                sum += num;
            }
            return sum;
        }

        return sum;
    }

}
