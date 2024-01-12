package GameService;

import java.util.ArrayList;

public class Constants {
    public static final ArrayList<QA> UFO_CORRECT_ANSWERS = new ArrayList<>(){{
        add(new QA("Ви втрачаєте пам'ять. Прийняти виклик НЛО?","Прийняти виклик", "Відхилити виклик","Ви відхилили виклик. Поразка!"));
        add(new QA("Ви прийняли виклик. Піднятися на капітанський місток?","Піднятися на місток", "Відмовитися підійматися на місток","Ви не пішли на переговори. Поразка!"));
        add(new QA("Ви піднялися на місток: Хто ви?","Розповісти правду про себе.", "Збрехати про себе","Ваша брехня була викрита. Поразка!"));
    }};
    public static final String UFO_WIN_MESSAGE="Вас повернули додому. Перемога!";
}
