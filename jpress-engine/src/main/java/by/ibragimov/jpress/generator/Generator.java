package by.ibragimov.jpress.generator;

import by.ibragimov.jpress.application.JettyServer;
import by.ibragimov.jpress.application.banner.Banner;
import by.ibragimov.jpress.filters.JPressFilter;
import by.ibragimov.jpress.generator.markup.AsciiDocEngine;
import by.ibragimov.jpress.generator.template.TemplateEngine;
import by.ibragimov.jpress.model.Model;
import by.ibragimov.jpress.model.Settings;
import by.ibragimov.jpress.utils.FileService;
import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@Component
public class Generator implements ApplicationListener<ContextStartedEvent> {

    @Autowired
    private AsciiDocEngine asciiDocEngine;

    @Autowired
    private List<JPressFilter> jPressFilters;

    @Autowired
    private TemplateEngine jadeEngine;

    @Autowired
    private TemplateEngine freemarkerEngine;

    @Autowired
    private Banner banner;

    @Autowired
    private JettyServer jettyServer;

    @Autowired
    private FileService fileService;

    @Autowired
    private Settings settings;


    @Autowired
    private Model model;


    /**
     * Pages generation of that should be initiated manually.
     */
    private static final Set<String> STATIC_PAGES = ImmutableSet.of("home", "index", "404", "search");

    /**
     * Open questions
     * 1. How to localize post/page?
     *
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {

        banner.print();

        fileService.scanFolder(Paths.get(settings.getInput()))
                .forEach(pair -> System.out.println(pair.getLeft() + " " + pair.getRight().getFileName()));

        System.out.println(freemarkerEngine.render(settings.getTemplate() + "/" + "index.ftl", model.model));

        System.out.println(asciiDocEngine.convert(new File("./hleb-in/content/Hello World.adoc")));

        System.out.println(jadeEngine.render(settings.getTemplate() + "/" + "404.jade", model.model));

        jettyServer.run();

        /**
         * Generate:
         *      posts
         *      pages
         *      arhive
         *      index
         *      tags
         *      rss
         *      sitemap
         *
         */
    }
}
