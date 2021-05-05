package ru.sbt.mipt.oop.alarm;

public class SmsNotifier implements Notifier {
    @Override
    public void notifyOwner() {
        System.out.println("Sending sms");
    }
}
