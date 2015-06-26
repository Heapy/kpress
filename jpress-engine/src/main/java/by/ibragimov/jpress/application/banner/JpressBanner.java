package by.ibragimov.jpress.application.banner;

import org.springframework.stereotype.Component;

/**
 * Prints jpress banner;
 *
 * @author Ibragimov Ruslan
 */
@Component
public class JpressBanner implements Banner {

    private final static String BANNER =
            "_____________________________________\n" +
            "   _______________ _____ _____ _____\n" +
            "  |_  | ___ \\ ___ \\  ___/  ___/  ___|\n" +
            "    | | |_/ / |_/ / |__ \\ `--.\\ `--.\n" +
            "    | |  __/|    /|  __| `--. \\`--. \\\n" +
            "/\\__/ / |   | |\\ \\| |___/\\__/ /\\__/ /\n" +
            "\\____/\\_|   \\_| \\_\\____/\\____/\\____/\n" +
            "\n" +
            "jpress  static  site  generator  v0.1\n" +
            "_____________________________________";

    @Override
    public void print() {
        System.out.println(BANNER);
    }
}
