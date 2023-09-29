package tasks.leetcode;

import java.util.HashMap;

public class CompactFeatureMap {
    private HashMap<String, Float> featureMap;

    public CompactFeatureMap() {
        featureMap = new HashMap<>();
    }

    public void insert(String feature, float probability) {
        featureMap.put(feature, probability);
    }

    public float lookup(String feature) {
        return featureMap.getOrDefault(feature, -1.0f);
    }

    public static void main(String[] args) {
        CompactFeatureMap cfm = new CompactFeatureMap();
        cfm.insert("feature1", 0.5f);
        System.out.println(cfm.lookup("feature1"));  // Виводить: 0.5
        System.out.println(cfm.lookup("feature2"));  // Виводить: -1.0
    }

    /*
        Використання хешування: Замість того, щоб зберігати повний рядок, ви можете зберігати хеш-значення рядка.
        Це дозволить зменшити розмір даних. Проте, у вас може виникнути проблема зі збігами хешів (колізіями),
         тому важливо вибрати хороший алгоритм хешування.

        Префіксне дерево (Trie): Ви можете зберігати рядки в префіксному дереві, де кожен шлях від кореня
        до листка представляє окремий рядок. В листках дерева можна зберігати відповідне значення імовірності.

        Стиснення даних: Використовуйте алгоритми стиснення (наприклад, gzip) для зберігання рядків та їх значень.

        Диференційне зберігання: Оскільки ідентифікатори рядків відсортовані, ви можете зберігати лише різницю між сусідніми ідентифікаторами.

        Використання бази даних: Великі об'єми даних часто зберігаються в оптимізованих базах даних,
        які використовують внутрішнє стиснення та інші оптимізації для зберігання даних.

        Під час вибору підходу слід також враховувати час доступу до даних та час, необхідний для виконання операції lookup.
     */

}
