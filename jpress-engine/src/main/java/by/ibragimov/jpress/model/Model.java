package by.ibragimov.jpress.model;

import by.ibragimov.jpress.metadata.Post;
import by.ibragimov.jpress.model.helpers.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Model {

    public Map<String, Object> model = new HashMap<>();

    @Autowired
    private List<Helper> helpers;

    public List<Post> posts = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Put all helpers method to model
        helpers.forEach(helper -> model.put(helper.getName(), helper));

        model.put("posts", posts);
    }

}
