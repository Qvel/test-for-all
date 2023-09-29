package tasks.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
K-closest Points

Problem: Given a set of n points, each with coordinates (x,y), return the k-closest points to the origin (0,0).

Для рішення цієї задачі ми можемо використовувати структуру даних,
відому як максимальна купа (max heap). Ми будемо зберігати відстані від початку до точок у максимальній купі.
 Якщо розмір купи перевищить k, ми просто видалимо найбільший елемент.
 В кінці наша купа буде містити k найближчих точок.
 */
public class KClosestPoint {
    public int[][] kClosest(int[][] points, int K) {

        //k - це капасіті конкретно в конструкторі тут
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return getDistance(p2) - getDistance(p1);
            }
        });


        /*
        Для кожної точки з масиву points ми додаємо її в чергу maxHeap з допомогою метода offer.
        Після додавання кожної точки ми перевіряємо, чи перевищує розмір черги K (кількість бажаних найближчих точок).
        Якщо розмір черги більший за K, ми видаляємо точку з найбільшою відстанню (оскільки це максимальна купа) за допомогою метода poll.
         Це забезпечує, що в черзі залишаються лише K найближчих точок.
        Зверніть увагу, що offer може бути використаний замість add для додавання елемента в чергу.
         Головна відмінність полягає в тому, що offer повертає false, якщо елемент не може бути доданий до черги (зазвичай через обмеження ємності),
          тоді як add викидає виняток IllegalStateException. Однак, у випадку з PriorityQueue в Java,
           ці два методи фактично працюють однаково, оскільки PriorityQueue не має фіксованої ємності.
         */
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];
        while (K > 0) {
            result[--K] = maxHeap.poll();
        }

        return result;
    }

    /*
    це формула, по суті теореми піфагора = х2 + у2 (але без кореня), бо з коренем - то дорога операція
     */
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /*
    У завданні "K-closest Points" параметр
    k вказує на кількість точок, які потрібно повернути.
     */
    public static void main(String[] args) {
        KClosestPoint obj = new KClosestPoint();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int K = 2;

        int[][] result = obj.kClosest(points, K);
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
