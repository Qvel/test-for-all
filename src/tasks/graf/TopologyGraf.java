package tasks.graf;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
короче є інпут ігор команд
[[A,B], [B,C], [D,C], [D,E], [A,E]]

вони відображають, шо:
1. команда А виграла у команди В
2. команда В виграла у команди С

і т д

короче це масив результатів матчів, де перший - переможець, а другий - програвший

і треба надрукувати список всіх команд, але в такому порядку, щоб ті хто виграли завжди були попереду тих, кого вони виграли

тобто
A D B C E - валідно

може так само буде
D A B C E

по інпуту видно що це спрямований ациклічний граф
"Спрямований" означає, що ребра мають напрямок (з одної вершини до іншої).
"Ациклічний" означає, що в графі немає циклів. Оскільки команда не може виграти у себе, ми очікуємо, що граф буде ациклічним

Ребро - це зв'язок між двома вершинами у графі. У вашому випадку, кожен матч можна представити як ребро,
де переможець - початкова вершина, а програвший - кінцева вершина.

Чому кожен матч це спрямоване ребро у графі де переможець вказує на програвшого?
Це найпростіший спосіб представлення відношень перемоги/поразки між командами. Команда, яка виграла, "вказує" на ту, яка програл

Топологічне сортування використовується для впорядкування елементів так,
що якщо є певне відношення між двома елементами (A відноситься до B), то A завжди буде перед B.
У вашому випадку, якщо команда A виграє у команди B, то A повинна йти перед B у списку.

Граф буде виглядати десь так :
A -> B -> C <- D
|              |
v              v
E <------------|

 */
public class TopologyGraf {
    public static void main(String[] args) {
        List<List<String>> matches = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("B", "C"),
                Arrays.asList("D", "C"),
                Arrays.asList("D", "E"),
                Arrays.asList("A", "E")
        );

        List<List<String>> matchesSecond = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("B", "C"),
                Arrays.asList("C", "D"),
                Arrays.asList("D", "A")
        );
        // A -> B -> C -> D -> A
        System.out.println(createGraph(matches));
        System.out.println(convertToResult(createGraph(matches)));
        System.out.println(convertToResult(createGraph(matchesSecond)));
        task();
    }

    // Функція для створення графа на основі списку матчів
    private static Map<String, List<String>> createGraph(List<List<String>> matches) {
        Map<String, List<String>> graph = new HashMap<>();  // Створюємо новий порожній граф

        for (List<String> match : matches) {  // Перебираємо кожен матч у списку матчів
            String winner = match.get(0);    // Визначаємо переможця
            String loser = match.get(1);     // Визначаємо програвшого

            graph.putIfAbsent(winner, new ArrayList<>());  // Якщо переможця ще немає в графі, додаємо його
            graph.get(winner).add(loser);   // Додаємо програвшого до списку команд, які програли переможцю
        }

        return graph;  // Повертаємо створений граф
    }

    //my decision
    private static List<String> convertToResult(Map<String, List<String>> map) {
        List<String> winners = new ArrayList<>(map.keySet());
        List<String> losers = map.values().stream().flatMap(Collection::stream).filter(
                loser -> !winners.contains(loser)
        ).distinct().collect(Collectors.toList());
        winners.addAll(losers);
        return winners;
    }

    //trying to understand topology sort
    private static void task() {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        addEdge(graph,"A", "B");
        addEdge(graph, "B", "C");
        addEdge(graph, "D", "C");
        addEdge(graph,"D", "E");
        addEdge(graph,"A", "E");

        System.out.println(graph);
        List<String> result = topologicalSort(graph, visited, stack);
        System.out.println(result);
        System.out.println(result);
    }

    // Додати ребро до графа
    private static void addEdge(Map<String, List<String>> graph, String source, String dest) {
        // Якщо вершина відсутня у графі, ініціалізуємо її порожнім списком
        graph.putIfAbsent(source, new ArrayList<>());
        // Додаємо ребро до графа (додати сусіда)
        graph.get(source).add(dest);
    }

    // Функція для DFS
    /*
        DFS (Depth-First Search) — це алгоритм глибинного пошуку, який використовується для обходу або пошуку структур даних,
        як от графів. Основна ідея полягає в тому, щоб відвідати вершину та рекурсивно відвідувати всі сусідні вершини.
     */
    private static void dfs(Map<String, List<String>> graph, Set<String> visited, Stack<String> stack, String node) {
        // Відзначити вершину як відвідану
        visited.add(node);
        // Обійти всіх сусідів поточної вершини
        graph.getOrDefault(node, new ArrayList<>()).forEach(neighbor -> {
            // Якщо сусід ще не відвіданий, то відвідуємо його
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, stack, neighbor);
            }
        });
        // Після відвідування всіх сусідів, додати вершину до стеку
        stack.push(node);
    }

    // Головна функція для топологічного сортування
    /*
    Топологічне сортування — це лінійний порядок вершин такий, що якщо є ребро з вершини
    �
    U до вершини
    �
    V, то
    �
    U завжди передує
    �
    V у порядку. Для ациклічного спрямованого графа завжди існує такий порядок.

    Ось основні кроки для топологічного сортування:

    Використовуйте DFS (глибинний пошук) для визначення порядку завершення для кожної вершини.
    Додавайте вершину в результат (або стек) тільки після того, як ви завершили відвідування всіх її сусідів.
    Заберіть вершини зі стеку — це буде ваш топологічний порядок.
     */
    public static List<String> topologicalSort(Map<String, List<String>> graph, Set<String> visited, Stack<String> stack) {
        // Запускаємо DFS для кожної вершини
        graph.keySet().forEach(node -> {
            if (!visited.contains(node)) {
                dfs(graph, visited, stack, node);
            }
        });

        // Додаємо вершини до результату в тому порядку, як вони лежать у стеку
        List<String> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    /*
    Stack - це підклас класу Vector, що реалізує стандартну структуру даних "стек".
     Стек - це колекція елементів, яка підтримує дві основні операції:

    push - додати елемент на вершину стеку.
    pop - вилучити та повернути верхній елемент стеку.
    Основна особливість стеку полягає в тому, що він працює за принципом "останній прийшов - перший вийшов" (LIFO - Last In First Out).

    Ось невеличкий приклад з Stack:
     */
    private static void stackWork() {
        // Створення нового стеку
        Stack<Integer> stack = new Stack<>();

        // Додавання елементів у стек
        stack.push(1);  // Вершина стеку: 1
        stack.push(2);  // Вершина стеку: 2
        stack.push(3);  // Вершина стеку: 3

        // Виведення верхнього елемента стеку (без вилучення)
        System.out.println(stack.peek());  // Виведе: 3

        // Вилучення елементів зі стеку
        System.out.println(stack.pop());  // Виведе: 3 (і вилучить його зі стеку)
        System.out.println(stack.pop());  // Виведе: 2 (і вилучить його зі стеку)

        // Перевірка, чи стек порожній
        System.out.println(stack.isEmpty());  // Виведе: false, бо є ще елемент 1

        System.out.println(stack.pop());  // Виведе: 1
        System.out.println(stack.isEmpty());  // Виведе: true, бо стек тепер порожній
    }

    //BFS (Breadth-First Search, пошук в ширину).
    /*
        У BFS вершини графа або дерева відвідуються "по ширині", тобто спочатку відвідуються всі сусіди поточної вершини,
         перш ніж переходити до їх сусідів. Для реалізації BFS часто використовується структура даних черга (queue).
     */
    /*
    Вірно, у BFS (пошук в ширину) для стандартної реалізації не використовується рекурсія. Замість цього використовується структура даних черга (Queue).

    Ось коротке пояснення:

    Ініціалізація: Спочатку ми додаємо початкову вершину до черги.

    Головний цикл: Поки черга не порожня:

    Дістаємо (та видаляємо) вершину з переду черги.
    Відвідуємо її.
    Додаємо всіх невідвіданих сусідів до кінця черги.
    Цей процес продовжується, поки всі доступні вершини не будуть відвідані.

    Тому, BFS дійсно не використовує рекурсію. Замість рекурсивного "занурення" в глибину графа,
    як це робить DFS, BFS "розширюється" в ширину графа, обходячи всі вершини на одному рівні,
    перш ніж переходити до наступного рівня.
     */
    public static List<String> bfs(Map<String, List<String>> graph, String start) {
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.println(vertex);

            for (String neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    //Queue
    /*
    Queue (черга) - це інтерфейс в Java, який належить до Java Collections Framework.
    Його основна ідея полягає в тому, що він представляє колекцію елементів,
    яка підтримує операції вставки на одному кінці і видалення на іншому. Це так звана структура даних "FIFO" (First-In, First-Out),
    тобто перший, хто прийшов, - перший, хто вийшов.

    Основні методи Queue:

    add(e) - додає елемент e в кінець черги. Кидає виняток, якщо операція не вдалася (наприклад, якщо черга повна у випадку обмеженої черги).
    offer(e) - також додає елемент в кінець черги, але повертає false, якщо операція не вдалася, замість кидання винятку.
    remove() - видаляє та повертає елемент з початку черги. Кидає виняток, якщо черга порожня.
    poll() - видаляє та повертає елемент з початку черги. Повертає null, якщо черга порожня.
    element() - повертає, але не видаляє елемент з початку черги. Кидає виняток, якщо черга порожня.
    peek() - повертає, але не видаляє елемент з початку черги. Повертає null, якщо черга порожня.
     */
    private static void workWithQueue() {
        Queue<String> queue = new LinkedList<>();

        // Додаємо елементи до черги
        queue.add("Apple");
        queue.offer("Banana");

        // Виводимо верхній елемент без його видалення
        System.out.println(queue.peek());  // Apple

        // Видаляємо та повертаємо верхній елемент
        System.out.println(queue.poll());  // Apple

        // Знову додаємо елемент
        queue.add("Cherry");

        // Виводимо розмір черги
        System.out.println(queue.size());  // 2

        // Перевіряємо, чи черга порожня
        System.out.println(queue.isEmpty());  // false

        // Виводимо та видаляємо всі елементи
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
