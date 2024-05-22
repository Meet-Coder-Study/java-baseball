package meetcoder.study.core.command;

import meetcoder.study.core.BaseballApplication;

public class ExitApplicationCommand implements Command {

    private final BaseballApplication application;

    public ExitApplicationCommand(BaseballApplication application) {
        this.application = application;
    }

    @Override
    public void excute() {
        application.exit();
    }

}
