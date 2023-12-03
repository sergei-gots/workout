package org.workout.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MiddleValue {

    public static void workout() {
        try {
            perform();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/
    public static void perform() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {


            String[] parts = reader.readLine().split(" ");
            if (parts.length != 3) {
              throw new IOException("Count of numbers must be = 3. " +
             "Numbers must be split by ' ' (space symbol).");
            }

            int[] nums = new int[3];

            try {
                Arrays.setAll(nums,  i -> Integer.parseInt(parts[i]));
            } catch (Exception e) {
                throw new IllegalArgumentException("Input must be in format '<num1> <num2> <num3>'" );
            }

            int middleValue =  (nums[0] > nums[1]) ?
                    (Math.min(nums[2], nums[0])) :  (Math.min(nums[2], nums[1]));
            writer.write(String.valueOf(middleValue));
        }
    }
}
