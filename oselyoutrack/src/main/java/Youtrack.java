import org.llorllale.youtrack.api.DefaultYouTrack;
import org.llorllale.youtrack.api.YouTrack;
import org.llorllale.youtrack.api.session.PermanentToken;

public class Youtrack {


    public static void main(String[] args) {
        final YouTrack youtrack = new DefaultYouTrack(
                new PermanentToken("your_token").login()   //login
        );


        try {


        youtrack.projects()
                .stream()                                        //stream of all projects
                .filter(p -> p.id().equals("project_id"))
                .get()
                .issues()
                .create("summary", "description") //create issue for the selected project
                .comments()
                .post("This is my first comment!");
        } Exception () {

        }
    }
}
