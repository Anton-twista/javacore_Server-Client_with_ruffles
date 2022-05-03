package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        int port = 8088;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                String line = in.readLine();
                out.println("Введите имя:");

                String name = in.readLine();
                out.println(String.format("Привет %s ", name + " ты ребёнок?(yes/no)"));

                line = in.readLine();
                if (line.equals("yes")) {
                    out.println(String.format("Добро пожаловать в детскую комнату %s ", name + " давай играть!"
                            + " Нажмите Enter чтобы продолжить"));
                } else if (line.equals("no")) {
                    out.println(String.format("Добро пожаловать во возрослую жизнь %s", name + ", Иди работай!"
                            + " Нажмите Enter чтобы продолжить"));
                } else {
                    out.println("Вы ввели неверное значение, нажмите Enter");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}