package csi213.assignment3;

import java.util.Comparator;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ListArray<Integer> list = new ListArray<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}

