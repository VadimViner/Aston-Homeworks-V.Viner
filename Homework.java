public class Homework {

    public class Task1 {
        public void printThreeWords() {
            System.out.println("Banana");
            System.out.println("Orange");
            System.out.println("Apple");
        }
    }

    public class Task2 {
        public void checkSumSign() {
            int a = 1;
            int b = 2;
            int c = a + b;
            if (c >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }
        }
    }

    public class Task3 {
        public void printColor() {
            int value = 101;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (value <= 100) {
                System.out.println("Желтый");
            } else {
                System.out.println("Зеленый");
            }
        }
    }

    public class Task4 {
        public void compareNumbers() {
            int a = 55;
            int b = 10;
            if (a >= b) {
                System.out.println("a >= b");
            } else {
                System.out.println("a < b");
            }
        }
    }

    public class Task5 {
        public boolean Sum(int a, int b) {
            int sum = a + b;
            return sum >= 10 && sum <= 20;
        }
    }

    public class Task6 {
        public void checkNubmer(int number) {
            if (number >= 0) {
                System.out.println("Число положительное");
            } else {
                System.out.println("Число отрицательное");
            }
        }
    }

    public class Task7{
        public boolean Check(int number){
            return number < 0;
        }}

    public class Task8{
        public void lineNumberMethod(){
            String line = "Привет!";
            int number = 5;
            for (int i = 0; i < number; i++){
                System.out.println(line);
            }
        }}

    public class Task9 {
        public boolean isLeapYear(int year) {
            if (year % 400 == 0) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            } else if (year % 4 == 0) {
                return true;
            } else {
                return false;
            }
        }}

    public class Task10{
        public void flipGeroOne() {
            int[] arr = {1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1};

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else if (arr[i] == 1) {
                    arr[i] = 0;
                }
            }

            for (int element : arr) {
                System.out.print(element + " ");
            }
        }
    }

    public class Task11 {
        public void fillerOneToHundred() {
            int[] arr = new int[100];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            for (int element : arr) {
                System.out.print(element + " ");
            }
        }
    }

    public class Task12 {
        public void toMuliplyLessThanSix() {
            int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

            for (int i = 0; i < array.length; i++) {
                if (array[i] < 6) {
                    array[i] *= 2;
                }
            }
            for (int element : array) {
                System.out.print(element + " ");
            }
        }
    }

    public class Task13 {
        public void getDiagonal() {
            int n = 10;
            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                array[i][i] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public class Task14 {
        public int[] createArray(int len, int initialValue) {
            int[] array = new int[len];

            for (int i = 0; i < len; i++) {
                array[i] = initialValue;
            }

            return array;
        }
    }

    public static void main(String[] arg) {
        Homework homework = new Homework();
        Task1 task1 = homework.new Task1();
        task1.printThreeWords();
        System.out.println();

        Task2 task2 = homework.new Task2();
        task2.checkSumSign();
        System.out.println();

        Task3 task3 = homework.new Task3();
        task3.printColor();
        System.out.println();

        Task4 task4 = homework.new Task4();
        task4.compareNumbers();
        System.out.println();

        Task5 task5 = homework.new Task5();
        System.out.println(task5.Sum(10, 20));
        System.out.println();

        Task6 task6 = homework.new Task6();
        task6.checkNubmer(5);
        System.out.println();

        Task7 task7 = homework.new Task7();
        System.out.println(task7.Check(5));
        System.out.println();

        Task8 task8 = homework.new Task8();
        task8.lineNumberMethod();
        System.out.println();

        Task9 task9 = homework.new Task9();
        int year = 2024;
            System.out.println("Год " + year + " високосный: " + task9.isLeapYear(year));
        System.out.println();

        Task10 task10 = homework.new Task10();
        task10.flipGeroOne();
        System.out.println();
        System.out.println();

        Task11 task11 = homework.new Task11();
        task11.fillerOneToHundred();
        System.out.println();
        System.out.println();

        Task12 task12 = homework.new Task12();
        task12.toMuliplyLessThanSix();
        System.out.println();
        System.out.println();

        Task13 task13 = homework.new Task13();
        task13.getDiagonal();
        System.out.println();

        Task14 task14 = homework.new Task14();
        int len = 10;
        int initialValue = 5;
        int[] resultArray = task14.createArray(len, initialValue);

        for (int element : resultArray) {
            System.out.print(element + " ");
        }

    }
}







