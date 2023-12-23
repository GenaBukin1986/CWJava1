package org.example;

public class Toy implements Comparable<Toy>{
    int id;
    int change;
    int count;

    public void setChange(int change) {
        this.change = change;
    }

    public int getId() {
        return id;
    }

    String name;

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count = this.count - 1;
    }

    public String getName() {
        return name;
    }

    public Toy(int id, int change, int count, String name) {
        this.id = id;
        this.change = change;
        this.count = count;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id#%d\nНазвание игрушки: %s",this.id,this.name);
    }



    public String dataToFile(){
        return String.format("id#%d Игрушка: %s",this.id,this.name);
    }

    @Override
    public int compareTo(Toy o) {
        if (this.change == o.change) {
            return 0;
        }else if (this.change > o.change){
            return  -1;
        }else {
            return 1;
        }
    }
}
