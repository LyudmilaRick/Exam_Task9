package ru.skypro;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        // using several catch
        System.out.println("Метод - generateTwoCatch");
        generateTwoCatch(arr);

        // using nested catch
        System.out.println("Метод - generateNestedCatch");
        generateNestedCatch(arr);

        // using my own catch
        System.out.println("Метод - generateOwnCatch");
        generateOwnCatch(arr);
        System.out.println("Метод - generateOwnCatch");
        arr = null;
        generateOwnCatch(arr);

    }

    private static void generateTwoCatch(int[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.print(array[i] / array[i + 1] + " ");
            } catch (ArithmeticException e) { // перехватить ошибку деления на нуль
                System.out.println("Деление на нуль: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) { // перехватить ошибку выхода за пределы массива
                System.out.println("Ошибка выхода за пределы массива: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
    }

    private static void generateNestedCatch(int[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                try {
                    System.out.print(array[i] / array[i + 1] + " ");
                } catch (ArithmeticException e) {
                    System.out.println("Zero division: " + e.getMessage());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of bounds: " + e.getMessage());
            }
        }
    }

    private static void generateOwnCatch(int[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                if (array[i + 1] == 0) {
                    throw new NullElementException();
                }
                System.out.print(array[i] / array[i + 1] + " ");
                ;
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NullElementException e) {
            System.out.println("Ошибка обращения к массиву: " + e.getMessage());
        }
    }
}
