package com.nus.duke.command;

import java.util.List;

import com.nus.duke.data.Task;
import com.nus.duke.ui.TextUi;

/**
 * FindCommand class encapsulates the logic for processing a "find" command.
 */
public class FindCommand extends Command {

    public static final String COMMAND = "find";
    public static final String IMPROPER_USAGE_FORMAT = "Improper command format";
    public static final String USAGE_MESSAGE = COMMAND + ": Search for text in tasks\n"
            + "Usage: find [text]\n"
            + "Example: find books";
    public static final String SUCCESS_MESSAGE_TEMPLATE = "Here are the tasks containing '%s'\n%s";
    public static final String SUCCESS_MESSAGE_EMPTY_TEMPLATE = "You have no tasks containing '%s'";

    private final String searchText;

    public FindCommand(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        List<Task> tasks = this.taskList.getList();
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).containsText(this.searchText)) {
                found = true;
                builder.append(i + TextUi.INDEX_OFFSET).append(": ")
                        .append(this.taskList.getList().get(i)).append("\n");
            }
        }
        if (found) {
            return String
                    .format(SUCCESS_MESSAGE_TEMPLATE, this.searchText, builder.toString().trim());
        } else {
            return String.format(SUCCESS_MESSAGE_EMPTY_TEMPLATE, this.searchText);
        }
    }

    /**
     * Parses and validate the arguments then returns the command object.
     *
     * @param arguments command arguments
     * @return FindCommand if successful and IncorrectCommand if unsuccessful.
     */
    public static Command parseArguments(String arguments) {
        if (arguments != null && !arguments.trim().isEmpty()) {
            return new FindCommand(arguments.trim());
        } else {
            return new IncorrectCommand(IMPROPER_USAGE_FORMAT + "\n" + USAGE_MESSAGE);
        }
    }
}
