package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class LotteryToys {
    Scanner scanner ;
    List<Toy> toys;
    Queue<Toy> listArrayPrize;

    public LotteryToys() {
        this.toys = new ArrayList<>();
        this.listArrayPrize = new PriorityQueue<>();
        scanner = new Scanner(System.in);
    }


    public void createToy(){
        try  {

            System.out.println("Введите id игрушки (это должно быть число): ");
            String id = scanner.next();
            int toy_id = Integer.parseInt(id);
            for (Toy toy: toys){
                if (toy_id == toy.getId()){
                    throw new RuntimeException();
                }
            }
            if (toy_id < 1) {
                throw new IdNumberException();
            }
            System.out.println("Введите частоту выпадения игрушки\n" +
                    "(это должно быть число 1 до 100): ");
            String change = scanner.next();
            int toy_change = Integer.parseInt(change);
            if (toy_change < 1 || toy_change > 100) {
                throw new ChangeToyException();
            }
            System.out.println("Введите количество игрушек: ");
            String count = scanner.next();
            int toy_count = Integer.parseInt(count);
            if (toy_count < 1){
                throw new CountNumberException();
            }
            System.out.println("Введите название игрушки: ");
            String name = scanner.next();
            toys.add(new Toy(toy_id, toy_change,toy_count, name));
            System.out.printf("Создана новая игрушка %s и\nдобавлена список игушек!\n\n", name);

        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число!\n");
        } catch (ChangeToyException | IdNumberException | CountNumberException e) {
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Совпадение id игрушек!\n");
        }
    }
    public void changeToyChange(){
        try{
            System.out.println("Введите id игрушки, у которой изменить частоту выпадения: ");
            String id = scanner.next();
            int idToy = Integer.parseInt(id);
            for (Toy t : toys){
                if (t.getId() == idToy){
                    System.out.println("Введите частоту выпадения, которую вы хотите установить: ");
                    String change = scanner.next();
                    int changeToy = Integer.parseInt(change);
                    if (changeToy < 1 || changeToy > 100){
                        throw new ChangeToyException();
                    }
                    t.setChange(changeToy);
                }
            }
            System.out.println("Изменения внесены успешно!\n");
        }catch (NumberFormatException e){
            System.out.println("Вы ввели не число!");
        }catch (ChangeToyException e){
            System.out.println(e.getMessage());
        }

    }

    public void changeToyPrize(){
        System.out.println("Игрушку под каким id хотите добавить в Призовой список: ");
        String id = scanner.next();
        try {
            int toy_id = Integer.parseInt(id);
            if (toy_id < 1) {
                throw new IdNumberException();
            }
            for (Toy toy: toys) {
                if (toy_id == toy.getId()) {
                    this.listArrayPrize.add(toy);
                    System.out.printf("Игрушка %s добавлена в Призовой список!\n\n",toy.getName());
                }
            }

        }catch (NumberFormatException e){
            System.out.println("Вы ввели не число!");
        } catch (IdNumberException e){
            System.out.println(e.getMessage());
        }


    }

    public void getToyPrize(){
        if (!this.listArrayPrize.isEmpty()){
            Toy toy = this.listArrayPrize.poll();
            toy.setCount();
            if (toy.getCount() == 0){
                toys.remove(toy);
            }
            try (FileWriter writer = new FileWriter("ToyPrize.txt",true)){
                writer.write(toy.dataToFile());
                writer.write("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Выпала игрушка %s\n",toy.dataToFile());
        }
        else {
            System.out.println("Список с призовыми Игрушками пустой!");
        }
    }

}
