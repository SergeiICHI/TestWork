// Паролем р будем называть строку из т символов, которая состоит из строчных латинских букв.
// Георгий придумал особый метод для шифрования паролей на своем сайте. Для этого он берет исходный пароль, выбирает не более К позиций в строке и удаляет символы с этих позиций. 
// Чтобы добавить однозначности своему шифрованию, он выбирает позиции так, чтобы в полученной строке
// было как можно меньше различных символов.
// Пока что Георгий занят реализацией другого функционала для своего сайта, поэтому просит вас помочь реализовать описанный выше алгоритм шифрования и по заданному паролю р наити
// количество различных символов в пароле после шифрования


package tinkoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class tinkoff2 {
    // С помощью этой функции выводим МИНИМАЛЬНО возможное оставшееся кол символов.
    public static Integer deleteValue(String x, Integer y){
        HashMap<Character, Integer> chars = new HashMap<>();

        for(int i = 0; i < x.length(); i++){
            if (chars.containsKey(x.charAt(i))){
                chars.put(x.charAt(i), chars.get(x.charAt(i)) +1);
            }
            else{
                chars.put(x.charAt(i), 1);
            }
        }


        ArrayList<Integer> values  = new ArrayList<>(chars.values());
        Collections.sort(values);

        Integer count = values.size();
        for(int i = 0; i< values.size();i++){
            if(y - values.get(i) >= 0){
                y = y - values.get(i);
                count -=1;
            }
        }
        return count;
    }


    //создаем пароль 
    public static String newPassword(Integer x) {
        Scanner in2 = new Scanner(System.in);
        
        String password = in2.nextLine();
        // if(password.length()!=x){
        //     return null;
        // }
        in2.close();
        return password;
      
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        String[] y = x.split(" ");
        Integer passLenght = Integer.parseInt(y[0]);
        Integer maxDeleteValue = Integer.parseInt(y[1]);

        String password = newPassword(passLenght);

        Integer minValue = deleteValue(password, maxDeleteValue);

        System.out.println(minValue);

        in.close();

    }
}