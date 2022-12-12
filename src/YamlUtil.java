import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class YamlUtil {

    public static void save(PhoneBook pb) throws IOException {


        File file = new File("/Users/marincsakt/IdeaProjects/PhoneBook/src/dump.yaml");
        FileWriter writer = new FileWriter(file);


        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);


        Representer representer = new Representer();
        representer.addClassTag(Person.class, Tag.MAP);


        Yaml yaml = new Yaml(representer, options);

        yaml.dump(pb.getPeople(), writer);

    }

}
