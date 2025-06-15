package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    String str = "the sky is blue";
        System.out.println(reverseWords(str));
//        PriorityQueue<Character> maps = new PriorityQueue<>((a,b)-> {
//            return a.values() - b.values();
//        });
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(String sr: arr){
            System.out.print(sr+",");
        }
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = arr.length-1; i >= 0; i--){
            if(!arr[i].isBlank()){
                stringBuilder.append(arr[i]).append(" ");
                System.out.println(stringBuilder.toString());
            }
        }
        System.out.println(stringBuilder.toString());
        if(!stringBuilder.isEmpty()){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(isOpen(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                checkAndRemove(stack, s.charAt(i));
            }
        }
        return stack.size() == 0;
    }
    public boolean isOpen(char c){
        return c == '(' || c == '{' || c == '[';
    }
    public char getOpenValue(char c){
        if(c == '}') {
            return '{';
        }else if(c == ')'){
            return '(';
        }else{
            return '[';
        }
    }
    public void checkAndRemove(Stack<Character> stack, char c){
        if(stack.peek() == getOpenValue(c)){
            stack.pop();
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Populate the left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(left[i]+",");
        }
        System.out.println();
        // Populate the right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(right[i]+",");
        }
        System.out.println();
        // Calculate the result array
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static String getAccountNumberMask(String accountNumber) {
        if (accountNumber == null) return null;
        accountNumber = accountNumber.trim();
        if (accountNumber.length() <= 4) {
            return accountNumber;
        }
        return accountNumber.substring(accountNumber.length() - 4);
    }

    static void print(int i, List<List<Integer>> list, List<Integer> temp, int[] arr, int target, int sum) {
        if (i >= arr.length) {
            if (sum == target) {
                list.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        if (sum + arr[i] <= target) {
            temp.add(arr[i]);
            sum += arr[i];
            print(i, list, temp, arr, target, sum);
            temp.remove((Integer) arr[i]);
            sum -= arr[i];
            print(i + 1, list, temp, arr, target, sum);
        } else {
            print(i + 1, list, temp, arr, target, sum);
        }
    }


    public static List<String> validateMandatoryGeneralFields(Object obj, Set<String> mandatoryFields) {
        List<String> errorMessages = new ArrayList<>();
        for (String fieldPath : mandatoryFields) {
            validateFieldPath(obj, fieldPath, errorMessages);
        }
        return errorMessages;
    }

    private static void validateFieldPath(Object obj, String fieldPath, List<String> errorMessages) {
        if (obj == null) {
            return;
        }

        String[] fieldNames = fieldPath.split("\\.");
        validateFieldPathRecursive(obj, fieldNames, 0, "", errorMessages);
    }

    private static void validateFieldPathRecursive(Object obj, String[] fieldNames, int index, String parentField, List<String> errorMessages) {
        if (obj == null || index >= fieldNames.length) {
            return;
        }

        Class<?> clazz = obj.getClass();
        String fieldName = fieldNames[index];
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(obj);
            String fullFieldName = parentField.isEmpty() ? fieldName : parentField + "." + fieldName;

            if (value == null) {
                errorMessages.add(fullFieldName);
                return;
            }

            // Final field in the path
            if (index == fieldNames.length - 1) {
                if (value instanceof List<?>) {
                    List<?> list = (List<?>) value;
                    if (list.isEmpty()) {
                        errorMessages.add(fullFieldName + " must have at least one item.");
                    }
                } else if (value instanceof Set<?>) {
                    Set<?> set = (Set<?>) value;
                    if (set.isEmpty()) {
                        errorMessages.add(fullFieldName + " must have at least one item.");
                    }
                }
                // You can add more primitive/null checks here as needed
            } else {
                // Continue recursion
                if (value instanceof List<?>) {
                    List<?> list = (List<?>) value;
                    if (list.isEmpty()) {
                        errorMessages.add(fullFieldName + " must have at least one item.");
                    } else {
                        for (Object item : list) {
                            validateFieldPathRecursive(item, fieldNames, index + 1, fullFieldName, errorMessages);
                        }
                    }
                } else {
                    validateFieldPathRecursive(value, fieldNames, index + 1, fullFieldName, errorMessages);
                }
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            errorMessages.add(parentField.isEmpty() ? fieldName : parentField + "." + fieldName);
        }
    }


}


class Task {

    Task task;
    List<String> list = List.of("Hello");
    List<Sample> samples = new ArrayList<>();
    Sample sample = new Sample();
    String id;

    public Task() {
//        this.id = "1";
        this.task = new Task("112221", "shjsdsjsgdjsd");

    }

    public Task(String id, String name) {
        this.id = id;
    }
}

class Sample {
    String sample;
    Test task = new Test();
    public Sample() {
//        this.sample = "yes";
    }

    public Sample(String sample) {
        this.sample = "yes";
    }
}

class Test{
    String name = "sjdj";
}