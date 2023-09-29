package tasks.leetcode;

import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[999]; // Ідеально тут повинні бути ваші числа.

        // Для прикладу, припустимо, що відсутнє 123:
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i != 123) {
                arr[index++] = i;
            }
        }

        //System.out.println(findMissingNumber(arr));  // Тут має вивестися 123
        System.out.println(findMissingNumberXOR(arr));
    }

    public static int findMissingNumber(int[] arr) {
        int totalSum = 500500;  // Сума перших 1000 натуральних чисел
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        return totalSum - arrSum;
    }

    public static int findMissingNumberMap(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i,1);
        }

        for(int i = 1; i<=1000; i++){
            if(!map.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }

    /*
    XOR (від англ. "exclusive or", іноді його позначають як ^) - це бітова операція, яка повертає 1 (істину) для вхідних бітів,
     які є різними, та 0 (брехня) для вхідних бітів, які є однаковими.
     */
    public static int findMissingNumberXOR(int[] arr) {
        int xorTotal = 0;
        for (int i = 1; i <= 1000; i++) {
            xorTotal ^= i;
        }

        for (int num : arr) {
            xorTotal ^= num;
        }

        return xorTotal;
    }

    // part 2
    public int[] findMissingNumbersXOR(int[] arr) {
        int xorTotal = 0;

        // Проводимо XOR для чисел від 1 до 1000
        for (int i = 1; i <= 1000; i++) {
            xorTotal ^= i;
        }

        // Проводимо XOR для кожного числа з масиву
        for (int num : arr) {
            xorTotal ^= num;
        }

        // Визначаємо найправіший встановлений біт xorTotal
        int rightmostSetBit = xorTotal & -xorTotal;
        int missing1 = 0, missing2 = 0;

        // Розділяємо числа з масиву на дві групи: де цей біт встановлений і де не встановлений
        for (int num : arr) {
            if ((num & rightmostSetBit) == 0) {
                missing1 ^= num;
            } else {
                missing2 ^= num;
            }
        }

        // Розділяємо числа від 1 до 1000 на дві групи, аналогічно
        for (int i = 1; i <= 1000; i++) {
            if ((i & rightmostSetBit) == 0) {
                missing1 ^= i;
            } else {
                missing2 ^= i;
            }
        }

        // Повертаємо два відсутніх числа
        return new int[]{missing1, missing2};
    }



    public int[] findMissingNumbersSet(int[] arr) {
        // Створюємо набір для зберігання усіх чисел з масиву
        Set<Integer> numberSet = new HashSet<>();

        for (int num : arr) {
            numberSet.add(num);
        }

        int[] missingNumbers = new int[2];
        int index = 0;

        // Ітеруємося через числа від 1 до 1000 і перевіряємо, які з них відсутні в наборі
        for (int i = 1; i <= 1000; i++) {
            if (!numberSet.contains(i)) {
                missingNumbers[index] = i;
                index++;
                // Якщо знайдено обидва відсутні числа - завершуємо пошук
                if (index == 2) {
                    break;
                }
            }
        }

        // Повертаємо два відсутніх числа
        return missingNumbers;
    }

}
