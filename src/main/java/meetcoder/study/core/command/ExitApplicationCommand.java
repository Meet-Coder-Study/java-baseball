package meetcoder.study.core.command;

import meetcoder.study.core.console.ConsoleBaseballApplication;

public class ExitApplicationCommand implements Command {

    private final ConsoleBaseballApplication application;

    public ExitApplicationCommand(ConsoleBaseballApplication application) {
        this.application = application;
    }

    @Override
    public void excute() {
        application.exit();
    }

}
