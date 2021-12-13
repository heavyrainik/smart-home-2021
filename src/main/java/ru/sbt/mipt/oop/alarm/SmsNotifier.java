package ru.sbt.mipt.oop.alarm;

public class SmsNotifier implements Notifier {
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );
	
    @Override
    public void notifyOwner() {
        LOGGER.log("Sending sms");
    }
}
