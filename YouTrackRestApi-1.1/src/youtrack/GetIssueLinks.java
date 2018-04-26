package youtrack;

import com.sun.istack.internal.NotNull;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

/**
 * Created by egor.malyshev on 02.04.2014.
 */
public class GetIssueLinks extends ListCommand<Issue, IssueLink> {
    public GetIssueLinks(@NotNull Issue owner) {
        super(owner);
    }

    @Override
    HttpRequestBase createMethod() {
        return new HttpGet(owner.getYouTrack().getHostAddress() + "issue/" + owner.getId() + "/link");
    }
}