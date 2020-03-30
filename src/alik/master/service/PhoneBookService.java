package alik.master.service;

import java.util.Scanner;

public class PhoneBookService {

    public static void start() {
        System.out.println("* Введи /help, если у вас есть вопросы!");

        String cmd;
        do {
            Scanner input = new Scanner(System.in);

            CommandService.executeCommand((cmd = input.next()));
        } while (!CommandService.isExitCommand(cmd));
    }
}