package com.bigo;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomHashTable {

    
    public static void main(String[] args) {
        CustomHashTable cht = new CustomHashTable(5);
        
        cht.set("grapes", 10000);
        cht.set("grapesgrapes", 33);
        cht.set("somecrap", 32340);
        System.out.println(cht.get("grapesgrapes"));
        System.out.println(Arrays.toString(cht.get()));
        System.out.println(cht.keys());

    }
    
    private ArrayList<KeyVal>[] data;
    
    @SuppressWarnings ("unchecked")
    public CustomHashTable(int size) {
        this.data = new ArrayList[size];
    }
    
    private int hash(String key) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (h + key.charAt(i) * i) % this.data.length;
        }
        return h;
    }
    
    public void set(String key, int val) {
        int index = this.hash(key);
        if (this.data[index] == null) {
          this.data[index] = new ArrayList<>();
        }
        this.data[index].add(new KeyVal(key, val));
    }
    
    public ArrayList<KeyVal>[] get() {
        return this.data;
    }
    
    public Integer get(String key) {
        ArrayList<KeyVal> table = this.data[this.hash(key)];
        for (KeyVal item: table) {
            if (item.key.equals(key)) {
                return item.val;
            }
        }
        return null;
    }
    
    public ArrayList<String> keys() {
        ArrayList<String> returnArray = new ArrayList<>();
        for (ArrayList<KeyVal> table: this.data) {
            if (table != null) {
                for (KeyVal item : table) {
                    returnArray.add(item.key);
                }
            }
        }
        return returnArray;
    }
    
    private class KeyVal {
        public String key;
        public int val;
        public KeyVal(String key, int val) {
            this.key = key;
            this.val = val;
        }
        
        public String toString() {
            return String.format("{%s, %s}", this.key, this.val);
        }
    }

}
