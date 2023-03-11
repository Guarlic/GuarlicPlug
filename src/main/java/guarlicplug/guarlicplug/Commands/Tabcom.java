package guarlicplug.guarlicplug.Commands;

import java.util.List;
import java.util.ArrayList;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.TabCompleter;

public class Tabcom implements TabCompleter {
    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] arg) {
        if (arguments.isEmpty()) {
            arguments.add("set");
            arguments.add("get");
            arguments.add("del");
        }

        List<String> result = new ArrayList<String>();

        if (arg.length == 1 ) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(arg[0].toLowerCase())) {
                    result.add(a);
                }
            }

            return result;
        }

        return arguments;
    }
}
