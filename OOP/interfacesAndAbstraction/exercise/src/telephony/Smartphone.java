package telephony;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone (List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();

        for (String url : urls) {
            if (!hasDigit(url)) {
                output.append("Browsing: ");
                output.append(url).append("!").append(System.lineSeparator());
//                System.out.println("Browsing: " + url + "!");
            }else {
                output.append("Invalid URL!");
//                System.out.println("Invalid URL!");
            }
        }
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();

        for (String number: numbers) {
            if (!hasLetters(number)) {
                output.append("Calling... ");
                output.append(number).append(System.lineSeparator());
//                System.out.println("Calling... " + number);
            }else {
//                System.out.println("Invalid number!");
                output.append("Invalid number!");
            }
        }
        return output.toString();
    }

    private boolean hasLetters(String number) {
        char[] charArray = number.toCharArray();

        boolean isLetter = false;

        for (char c : charArray) {
            if (Character.isLetter(c)) {
                isLetter = true;
            }
        }
        return isLetter;
    }

    private boolean hasDigit(String url) {
        boolean isDigit = false;

        char[] charArray = url.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                isDigit = true;
            }
        }
        return isDigit;
    }

}
