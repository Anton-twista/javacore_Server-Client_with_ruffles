package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String host = "netology.homework";
    private static final int port = 8088;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            InetAddress ipAddress = InetAddress.getByName(host);
            Socket socket = new Socket(host, port);

            System.out.print("Подключение к серверу");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("(IP address: " + ipAddress + ", port: " + port + ")");
            Thread.sleep(500);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Thread.sleep(500);
            System.out.println("Сервер запущен!");
            Thread.sleep(500);
            System.out.println("Введите start для начала или введите stop для остановки бота");


            while (true) {
                String word = scanner.nextLine();

                if (word.equals("stop")) {
                    System.out.println("Вы отключились от сервера");
                    out.println(word);
                    break;

                } else if (word.equals("start")) {

                    System.out.println("Давайте начнём!");
                    out.println(word);
                    String rest = in.readLine();
                    System.out.println(rest);

                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equals("stop")) {
                            out.println(line);
                            System.out.println("Вы остновили бота, введите stop ещё раз чтобы выйти с сервера");
                            break;
                        } else
                            out.println(line);
                        String resp = in.readLine();
                        System.out.println(resp);
                    }

                } else {
                    System.out.println("Введите start или stop!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}