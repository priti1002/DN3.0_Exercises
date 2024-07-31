
public interface Notification {
    void send(String message);
}

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}


public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

public abstract class NotificationDecorator implements Notification {
    protected Notification decoratedNotification;

    public NotificationDecorator(Notification decoratedNotification) {
        this.decoratedNotification = decoratedNotification;
    }

    @Override
    public void send(String message) {
        decoratedNotification.send(message);
    }
}

public class LoggingDecorator extends NotificationDecorator {
    public LoggingDecorator(Notification decoratedNotification) {
        super(decoratedNotification);
    }

    @Override
    public void send(String message) {
        System.out.println("Logging: Sending message - " + message);
        decoratedNotification.send(message);
    }
}


public class PriorityDecorator extends NotificationDecorator {
    private String priority;

    public PriorityDecorator(Notification decoratedNotification, String priority) {
        super(decoratedNotification);
        this.priority = priority;
    }

    @Override
    public void send(String message) {
        System.out.println("Priority: " + priority);
        decoratedNotification.send(message);
    }
}


public class FormattingDecorator extends NotificationDecorator {
    public FormattingDecorator(Notification decoratedNotification) {
        super(decoratedNotification);
    }

    @Override
    public void send(String message) {
        String formattedMessage = "[Formatted] " + message;
        decoratedNotification.send(formattedMessage);
    }
}
public class NotificationClient {
    public static void main(String[] args) {
        // Create a basic email notification
        Notification email = new EmailNotification();
        
        // Add logging and formatting functionalities
        Notification emailWithLogging = new LoggingDecorator(email);
        Notification emailWithLoggingAndFormatting = new FormattingDecorator(emailWithLogging);

        // Send a notification with both functionalities applied
        emailWithLoggingAndFormatting.send("Hello, world!");

        // Create a basic SMS notification
        Notification sms = new SMSNotification();

        // Add priority and logging functionalities
        Notification smsWithPriority = new PriorityDecorator(sms, "High");
        Notification smsWithPriorityAndLogging = new LoggingDecorator(smsWithPriority);

        // Send a notification with both functionalities applied
        smsWithPriorityAndLogging.send("Important message!");
    }
}
